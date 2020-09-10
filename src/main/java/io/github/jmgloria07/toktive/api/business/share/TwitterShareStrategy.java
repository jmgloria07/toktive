package io.github.jmgloria07.toktive.api.business.share;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.api.business.call.TwitterCall;
import io.github.jmgloria07.toktive.api.business.util.LogUtil;
import io.github.jmgloria07.toktive.api.objects.CallStatus;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.messages.SocialMessage;
import twitter4j.Status;
import twitter4j.TwitterException;

@Component
public class TwitterShareStrategy implements ShareStrategy {

	private static final Logger LOG = LogManager.getFormatterLogger(TwitterShareStrategy.class);
	
	@Autowired
	private TwitterCall auth;
	
	private static final String URL_TWITTER_PREPEND = "https://twitter.com/i/web/status/";
	
	@Override
	public CallStatus share(SocialMessage message) {
		final String METHOD_NAME = "share";
		LogUtil.logStartMethod(LOG, METHOD_NAME);
		
		Optional<Status> status = Optional.empty();
		String errorMessage = "";
		try {
			status = Optional.of(auth.publish(message.getMessage()));
		} catch (TwitterException e) {
			errorMessage = e.getErrorMessage();
		}
		
		LogUtil.logEndMethod(LOG, METHOD_NAME);
		return buildSocialStatus(status, errorMessage);
	}

	@Override
	public SocialNetwork getStrategyName() {
		return SocialNetwork.TW;
	}
	
	private CallStatus buildSocialStatus(Optional<Status> status, String errorMessage) {
		final String METHOD_NAME = "buildSocialStatus";
		LogUtil.logStartMethod(LOG, METHOD_NAME);
		
		String url = "";
		CallStatus.Status socialStatus = CallStatus.Status.FAIL;
		
		if (status.isPresent()) {
			url = URL_TWITTER_PREPEND + status.map(Status::getId).get();
			socialStatus = CallStatus.Status.SUCCESS;
		}
		
		final CallStatus response = new CallStatus(socialStatus, url, errorMessage);
		
		LogUtil.logInfo(LOG, response.toString());
		LogUtil.logValue(LOG, CallStatus.class.getName(), response.toString());
		LogUtil.logEndMethod(LOG, METHOD_NAME);
		
		return response;
	}

}
