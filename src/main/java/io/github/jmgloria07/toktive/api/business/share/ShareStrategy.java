package io.github.jmgloria07.toktive.api.business.share;

import io.github.jmgloria07.toktive.api.objects.ToktiveCall;
import io.github.jmgloria07.toktive.api.objects.ToktivePost;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;

/*
 * strategy to define the API call the request shares to
 */
public interface ShareStrategy {
	public ToktiveCall share(ToktivePost post);
	public SocialNetwork getStrategyName();
}


