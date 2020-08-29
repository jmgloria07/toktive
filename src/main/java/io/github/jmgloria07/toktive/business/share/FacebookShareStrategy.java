package io.github.jmgloria07.toktive.business.share;

import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.model.SocialMessage;
import io.github.jmgloria07.toktive.model.SocialNetwork;

@Component
public class FacebookShareStrategy implements ShareStrategy {

	@Override
	public void share(SocialMessage message) {
		// TODO Auto-generated method stub
		System.out.println("sharing via FB: " + message.getMessage());
	}

	@Override
	public SocialNetwork getStrategyName() {
		// TODO Auto-generated method stub
		return SocialNetwork.FB;
	}

}
