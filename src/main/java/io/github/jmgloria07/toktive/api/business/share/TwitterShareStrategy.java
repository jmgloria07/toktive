package io.github.jmgloria07.toktive.api.business.share;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.api.business.authentication.TwitterAuth;
import io.github.jmgloria07.toktive.api.objects.SocialMessage;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.SocialStatus;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Component
public class TwitterShareStrategy implements ShareStrategy {

	@Autowired
	private TwitterAuth auth;
	
	private static final String TWITTER_URL_PREPEND = "https://twitter.com/i/web/status/";
	
	@Override
	public SocialStatus share(SocialMessage message) {
		//TODO: create proper logging
		System.out.println("sharing via Twitter: " + message);
		Twitter twitter = auth.getTwitterInstance();
		
		Optional<Status> status = Optional.empty();
		String errorMessage = "";
		try {
			status = Optional.of(twitter.updateStatus(message.getMessage()));
		} catch (TwitterException e) {
			errorMessage = e.getErrorMessage();
		}
		
		return buildSocialStatus(status, errorMessage);
	}

	@Override
	public SocialNetwork getStrategyName() {
		return SocialNetwork.TW;
	}
	
	private SocialStatus buildSocialStatus(Optional<Status> status, String errorMessage) {
		String url = "";
		SocialStatus.Status socialStatus = SocialStatus.Status.FAIL;
		if (status.isPresent()) {
			url = TWITTER_URL_PREPEND + 
					status.map(Status::getId).flatMap(Optional::ofNullable)
						.get();
			socialStatus = SocialStatus.Status.SUCCESS;
		}
		System.out.println(url + " " + socialStatus + " " + errorMessage);
		
		return new SocialStatus(socialStatus, url, errorMessage);
	}

}