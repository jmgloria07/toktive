package io.github.jmgloria07.toktive.business.delegate;

import java.util.Set;

import io.github.jmgloria07.toktive.model.SocialMessage;

public interface SocialDelegate {
	public void shareToAllNetworks(Set<SocialMessage> socialMessages);
}
