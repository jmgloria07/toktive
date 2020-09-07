package io.github.jmgloria07.toktive.api.business.share;

import org.springframework.stereotype.Component;

import com.restfb.Parameter;
import com.restfb.types.FacebookType;

import io.github.jmgloria07.toktive.api.business.call.FacebookCall;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.SocialStatus;
import io.github.jmgloria07.toktive.api.objects.messages.SocialMessage;

@Deprecated
@Component
public class FacebookShareStrategy implements ShareStrategy {
		
	@Override
	public SocialStatus share(SocialMessage message) {
		FacebookCall.getFacebookInstance()
			.publish("me/feed", FacebookType.class, Parameter.with("message", message));
		return new SocialStatus();
	}

	@Override
	public SocialNetwork getStrategyName() {
		return SocialNetwork.FB;
	}

}
