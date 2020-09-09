package io.github.jmgloria07.toktive.api.business.share;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.api.business.call.TwitterCall;
import io.github.jmgloria07.toktive.api.objects.CallStatus;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.messages.SocialMessage;
import twitter4j.Status;
import twitter4j.TwitterException;

@Component
public class TwitterShareStrategy implements ShareStrategy {

	@Autowired
	private TwitterCall auth;
	
	private static final String URL_TWITTER_PREPEND = "https://twitter.com/i/web/status/";
	
	@Override
	public CallStatus share(SocialMessage message) {
		//TODO: create proper logging
		System.out.println("sharing via Twitter: " + message);
		
		Optional<Status> status = Optional.empty();
		String errorMessage = "";
		try {
			status = Optional.of(auth.publish(message.getMessage()));
		} catch (TwitterException e) {
			errorMessage = e.getErrorMessage();
		}
		
		return buildSocialStatus(status, errorMessage);
	}

	@Override
	public SocialNetwork getStrategyName() {
		return SocialNetwork.TW;
	}
	
	private CallStatus buildSocialStatus(Optional<Status> status, String errorMessage) {
		String url = "";
		CallStatus.Status socialStatus = CallStatus.Status.FAIL;
		
		if (status.isPresent()) {
			url = URL_TWITTER_PREPEND + status.map(Status::getId).get();
			socialStatus = CallStatus.Status.SUCCESS;
		}
		System.out.println(url + " " + socialStatus + " " + errorMessage);
		
		return new CallStatus(socialStatus, url, errorMessage);
	}

}
