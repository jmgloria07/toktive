package io.github.jmgloria07.toktive.api.business;

import java.util.List;
import java.util.Set;

import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;

public interface ToktiveService {
	
	public List<ToktiveResponse> share(String message, Set<String> networks);
}
