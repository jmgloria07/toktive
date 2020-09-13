package io.github.jmgloria07.toktive.api.business.share;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restfb.exception.FacebookException;
import com.restfb.json.JsonObject;

import io.github.jmgloria07.toktive.api.business.call.FacebookPageCall;
import io.github.jmgloria07.toktive.api.business.util.LogUtil;
import io.github.jmgloria07.toktive.api.objects.CallStatus;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.exceptions.ToktiveServiceParameterException;
import io.github.jmgloria07.toktive.api.objects.messages.SocialMessage;

@Component
public class FacebookPageShareStrategy implements ShareStrategy {
	
	private static final Logger LOG = LogManager.getLogger(FacebookPageShareStrategy.class);
	
	@Autowired
	FacebookPageCall auth;
	
	private static final String URL_FB_PREPEND = "https://facebook.com/";

	private static final String KEY_ID = "id";

	@Override
	public CallStatus share(SocialMessage message) {
		final String METHOD_NAME = "share";
		LogUtil.logStartMethod(LOG, METHOD_NAME);
		
		Optional.ofNullable(message)
		.orElseThrow(
				() -> new ToktiveServiceParameterException(SocialMessage.class.toString()));
		
		Optional<JsonObject> result = Optional.empty();
		String errorMessage = null;
		
		try {
			result = Optional.of(auth.publishPost(message.getMessage()));
		} catch (FacebookException e) {
			LogUtil.logException(LOG, e);
			errorMessage = e.getMessage();
		}
		
		CallStatus returnVal = buildSocialStatus(result, errorMessage);
		
		LogUtil.logEndMethod(LOG, METHOD_NAME);
		return returnVal;
	}

	private CallStatus buildSocialStatus(Optional<JsonObject> result, String errorMessage) {
		final String METHOD_NAME = "buildSocialStatus";
		LogUtil.logStartMethod(LOG, METHOD_NAME);
		
		CallStatus.Status status = CallStatus.Status.FAIL;
		String link = null;
		
		if (result.isPresent()) {
			link = URL_FB_PREPEND + result.get().getString(KEY_ID, "");
			status = CallStatus.Status.SUCCESS;
		} 
		
		final CallStatus response = new CallStatus(status, link, errorMessage);
		
		LogUtil.logInfo(LOG, response.toString());
		LogUtil.logValue(LOG, CallStatus.class.getName(), response.toString());
		LogUtil.logEndMethod(LOG, METHOD_NAME);
		return new CallStatus(status, link, errorMessage);
	}

	@Override
	public SocialNetwork getStrategyName() {
		return SocialNetwork.FB_PAGES;
	}

}
