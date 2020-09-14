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

@Component
public class TwitterShareStrategy implements ShareStrategy {

	private static final Logger LOG = LogManager.getFormatterLogger(TwitterShareStrategy.class);
	
	@Autowired
	TwitterCall auth;
	
	private static final String URL_TWITTER_PREPEND = "https://twitter.com/i/web/status/";
	
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
		final String METHOD_NAME = "buildSocialStatus";
		LogUtil.logStartMethod(LOG, METHOD_NAME);
		
		String url = null;
		ToktiveCall.Status socialStatus = ToktiveCall.Status.FAIL;
		
		if (status.isPresent()) {
			url = URL_TWITTER_PREPEND + status.map(Status::getId).get();
			socialStatus = ToktiveCall.Status.SUCCESS;
		}
		
		final ToktiveCall response = new ToktiveCall(socialStatus, url, errorMessage);
		
		LogUtil.logInfo(LOG, response.toString());
		LogUtil.logValue(LOG, ToktiveCall.class.getName(), response.toString());
		LogUtil.logEndMethod(LOG, METHOD_NAME);
		
		return response;
	}

}
