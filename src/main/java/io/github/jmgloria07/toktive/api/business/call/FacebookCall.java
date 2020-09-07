package io.github.jmgloria07.toktive.api.business.call;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;

@Deprecated
public class FacebookCall {
	
	//include in property file
	private static final String accessToken = "XXXXXXXXXXXX";
	
	private static FacebookClient fbClient;
	
	private FacebookCall() {
		
	}
	
	public static FacebookClient getFacebookInstance() {
		if (fbClient == null) {
			fbClient = new DefaultFacebookClient(accessToken, Version.VERSION_8_0);
		}
		return fbClient;
	}
}
