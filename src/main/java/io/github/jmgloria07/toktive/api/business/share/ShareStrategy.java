package io.github.jmgloria07.toktive.api.business.share;

import io.github.jmgloria07.toktive.api.objects.SocialMessage;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.SocialStatus;

public interface ShareStrategy {
	public SocialStatus share(SocialMessage message);
	public SocialNetwork getStrategyName();
}


