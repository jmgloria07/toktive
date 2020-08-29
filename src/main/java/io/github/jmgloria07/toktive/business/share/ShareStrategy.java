package io.github.jmgloria07.toktive.business.share;

import io.github.jmgloria07.toktive.model.SocialMessage;
import io.github.jmgloria07.toktive.model.SocialNetwork;

public interface ShareStrategy {
	public void share(SocialMessage message);
	public SocialNetwork getStrategyName();
}


