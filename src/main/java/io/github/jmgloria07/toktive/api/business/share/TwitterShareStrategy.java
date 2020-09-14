package io.github.jmgloria07.toktive.api.business.share;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.api.business.call.TwitterCall;
import io.github.jmgloria07.toktive.api.business.util.LogUtil;
import io.github.jmgloria07.toktive.api.objects.ToktiveCall;
import io.github.jmgloria07.toktive.api.objects.ToktivePost;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.exceptions.ToktiveServiceParameterException;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.User;

@Component
public class TwitterShareStrategy implements ShareStrategy {

	private static final Logger LOG = LogManager.getFormatterLogger(TwitterShareStrategy.class);
	
	@Autowired
	TwitterCall auth;
	
	private static final String URL_TWITTER_PREPEND = "https://twitter.com/";
	private static final String URL_TWITTER_STATUS = "/status/";
	
	@Override
	public ToktiveCall share(ToktivePost post) {
		final String METHOD_NAME = "share";
		LogUtil.logStartMethod(LOG, METHOD_NAME);
		
		Optional.ofNullable(post)
			.orElseThrow(
					() -> new ToktiveServiceParameterException(ToktivePost.class.toString()));
		
		Optional<Status> status = Optional.empty();
		String errorMessage = null;
		try {
			status = Optional.of(auth.publish(post.getPost()));
		} catch (TwitterException e) {
			errorMessage = e.getErrorMessage();
		}
		
		LogUtil.logEndMethod(LOG, METHOD_NAME);
		return buildCallResponse(status, errorMessage);
	}

	@Override
	public SocialNetwork getStrategyName() {
		return SocialNetwork.TW;
	}
	
	private ToktiveCall buildCallResponse(Optional<Status> status, String errorMessage) {
		final String METHOD_NAME = "buildCallResponse";
		LogUtil.logStartMethod(LOG, METHOD_NAME);
		
		String url = null;
		ToktiveCall.Status callStatus = ToktiveCall.Status.FAIL;
		
		if (status.isPresent()) {
			StringBuffer urlBuilder = new StringBuffer(URL_TWITTER_PREPEND);
					
			url = urlBuilder
					.append(status.map(Status::getUser).map(User::getId).get())
					.append(URL_TWITTER_STATUS)
					.append(status.map(Status::getId).get())
					.toString();
			
			callStatus = ToktiveCall.Status.SUCCESS;
		}
		
		final ToktiveCall response = new ToktiveCall(callStatus, url, errorMessage);
		
		LogUtil.logInfo(LOG, response.toString());
		LogUtil.logValue(LOG, ToktiveCall.class.getName(), response.toString());
		LogUtil.logEndMethod(LOG, METHOD_NAME);
		
		return response;
	}

}
