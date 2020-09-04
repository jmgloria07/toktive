package io.github.jmgloria07.toktive.authentication;

import org.springframework.stereotype.Component;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;

@Component
public class FacebookAuth {
	
	//include in property file
	private String accessToken = "XXXXXXXXXXXX";
	
	public FacebookClient getFacebookInstance() {
		return new DefaultFacebookClient(accessToken, Version.VERSION_8_0);
	}
}
