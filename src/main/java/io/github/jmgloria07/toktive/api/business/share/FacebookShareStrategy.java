package io.github.jmgloria07.toktive.api.business.share;

import org.springframework.stereotype.Component;

import com.restfb.Parameter;
import com.restfb.types.FacebookType;

import io.github.jmgloria07.toktive.api.business.call.FacebookCall;
import io.github.jmgloria07.toktive.api.objects.ToktiveCall;
import io.github.jmgloria07.toktive.api.objects.ToktivePost;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;

@Deprecated
@Component
public class FacebookShareStrategy implements ShareStrategy {
		
	@Override
	public ToktiveCall share(ToktivePost message) {
		FacebookCall.getFacebookInstance()
			.publish("me/feed", FacebookType.class, Parameter.with("message", message));
		return new ToktiveCall();
	}

	@Override
	public SocialNetwork getStrategyName() {
		return SocialNetwork.FB;
	}

}
