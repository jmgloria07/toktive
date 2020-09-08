package io.github.jmgloria07.toktive.api.business.delegate;

import java.util.List;
import java.util.Set;

import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;
import io.github.jmgloria07.toktive.api.objects.messages.SocialMessage;

/*
 * Delegates the request to which call implementation it falls to
 */
public interface ToktiveShareDelegate {
	public List<ToktiveResponse> shareToAllNetworks(Set<SocialMessage> socialMessages);
}
