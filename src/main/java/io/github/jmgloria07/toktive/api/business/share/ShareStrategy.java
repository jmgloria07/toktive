package io.github.jmgloria07.toktive.api.business.share;

import io.github.jmgloria07.toktive.api.objects.CallStatus;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.messages.SocialMessage;

/*
 * strategy to define the API call the request shares to
 */
public interface ShareStrategy {
	public CallStatus share(SocialMessage message);
	public SocialNetwork getStrategyName();
}


