package io.github.jmgloria07.toktive.business.share;

import io.github.jmgloria07.toktive.model.SocialMessage;

public interface ShareStrategy {
	public String share(SocialMessage message);
	public SocialNetwork getStrategyName();
}


