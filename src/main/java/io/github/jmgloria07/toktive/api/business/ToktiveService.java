package io.github.jmgloria07.toktive.api.business;

import java.util.Set;

public interface ToktiveService {
	
	public void share(String message, Set<String> networks);
}
