package io.github.jmgloria07.toktive.business.delegate;

import java.util.Set;

import io.github.jmgloria07.toktive.model.SocialMessage;

public interface SocialDelegate {
	public String shareToAllNetworks(SocialMessage message, Set<String> networks);
}
