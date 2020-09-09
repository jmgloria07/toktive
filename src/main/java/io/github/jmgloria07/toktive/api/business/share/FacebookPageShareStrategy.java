package io.github.jmgloria07.toktive.api.business.share;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restfb.exception.FacebookException;
import com.restfb.json.JsonObject;

import io.github.jmgloria07.toktive.api.business.call.FacebookPageCall;
import io.github.jmgloria07.toktive.api.objects.CallStatus;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.messages.SocialMessage;

@Component
public class FacebookPageShareStrategy implements ShareStrategy {
	
	@Autowired
	FacebookPageCall auth;
	
	private static final String URL_FB_PREPEND = "https://facebook.com/";

	private static final String KEY_ID = "id";

	@Override
	public CallStatus share(SocialMessage message) {
		
		Optional<JsonObject> result = Optional.empty();
		String errorMessage = "";
		
		try {
			result = Optional.of(auth.publishPost(message.getMessage()));
		} catch (FacebookException e) {
			errorMessage = e.getMessage();
		}
		
		CallStatus returnVal = buildSocialStatus(result, errorMessage);
		
		return returnVal;
	}

	private CallStatus buildSocialStatus(Optional<JsonObject> result, String errorMessage) {
		
		CallStatus.Status status = CallStatus.Status.FAIL;
		String link = "";
		
		if (result.isPresent()) {
			link = URL_FB_PREPEND + result.get().getString(KEY_ID, "");
			status = CallStatus.Status.SUCCESS;
		} 
		
		//TODO: better logging
		System.out.println(status + " " + link + " " + errorMessage);
		return new CallStatus(status, link, errorMessage);
	}

	@Override
	public SocialNetwork getStrategyName() {
		return SocialNetwork.FB_PAGES;
	}

}
