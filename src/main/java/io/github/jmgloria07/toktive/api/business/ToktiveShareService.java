package io.github.jmgloria07.toktive.api.business;

import java.util.List;
import java.util.Set;

import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;

/*
 * service/facade class to be implemented that focuses on the sharing behaviors
 */
public interface ToktiveShareService {
	
	public List<ToktiveResponse> share(String message, Set<String> networks);
}
