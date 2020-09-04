package io.github.jmgloria07.toktive.business.share;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restfb.Parameter;
import com.restfb.types.FacebookType;

import io.github.jmgloria07.toktive.authentication.FacebookAuth;
import io.github.jmgloria07.toktive.model.SocialMessage;
import io.github.jmgloria07.toktive.model.SocialNetwork;

@Component
public class FacebookShareStrategy implements ShareStrategy {
	
	@Autowired
	private FacebookAuth auth;
	
	@Override
	public void share(SocialMessage message) {
		auth.getFacebookInstance().publish("me/feed", FacebookType.class, Parameter.with("message", message));
	}

	@Override
	public SocialNetwork getStrategyName() {
		return SocialNetwork.FB;
	}

}
