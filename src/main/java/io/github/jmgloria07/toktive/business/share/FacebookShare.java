package io.github.jmgloria07.toktive.business.share;

import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.model.SocialMessage;

@Component
public class FacebookShare implements ShareStrategy {

	@Override
	public String share(SocialMessage message) {
		// TODO Auto-generated method stub
		System.out.println("sharing via FB: " + message.getMessage());
		return null;
	}

	@Override
	public SocialNetwork getStrategyName() {
		// TODO Auto-generated method stub
		return SocialNetwork.FB;
	}

}
