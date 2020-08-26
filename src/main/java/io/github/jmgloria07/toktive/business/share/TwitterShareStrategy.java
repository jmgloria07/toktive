package io.github.jmgloria07.toktive.business.share;

import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.model.SocialMessage;
import io.github.jmgloria07.toktive.model.SocialNetwork;

@Component
public class TwitterShareStrategy implements ShareStrategy {

	@Override
	public String share(SocialMessage message) {
		// TODO Auto-generated method stub
		System.out.println("sharing via Twitter: " + message.getMessage());
		return null;
	}

	@Override
	public SocialNetwork getStrategyName() {
		// TODO Auto-generated method stub
		return SocialNetwork.TW;
	}

}
