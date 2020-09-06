package io.github.jmgloria07.toktive.api.business.delegate;

import java.util.Set;

import io.github.jmgloria07.toktive.api.objects.SocialMessage;

public interface SocialDelegate {
	public void shareToAllNetworks(Set<SocialMessage> socialMessages);
}
