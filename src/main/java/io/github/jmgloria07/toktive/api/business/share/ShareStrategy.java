package io.github.jmgloria07.toktive.api.business.share;

import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.SocialStatus;
import io.github.jmgloria07.toktive.api.objects.messages.SocialMessage;

public interface ShareStrategy {
	public SocialStatus share(SocialMessage message);
	public SocialNetwork getStrategyName();
}


