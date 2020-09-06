package io.github.jmgloria07.toktive.api.business.delegate;

import java.util.List;
import java.util.Set;

import io.github.jmgloria07.toktive.api.objects.SocialMessage;
import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;

public interface SocialDelegate {
	public List<ToktiveResponse> shareToAllNetworks(Set<SocialMessage> socialMessages);
}
