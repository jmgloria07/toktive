package io.github.jmgloria07.toktive.api.business.call;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.json.JsonObject;

import io.github.jmgloria07.toktive.api.business.util.LogUtil;

@Configuration
@PropertySource("classpath:api.tokens.properties")
public class FacebookPageCall {	
	
	private static final Logger LOG = LogManager.getLogger(FacebookPageCall.class);

	@Value("${fb.oauth.access.token}")
	private String ACCESS_TOKEN;
	
	@Value("${fb.oauth.page.name}")
	private String PAGE_NAME;
	
	private static final String URL_FEED = "/feed";
	private static final String KEY_MESSAGE = "message";
		
	@Autowired
	FacebookClient facebookClient;
	
	public JsonObject publishPost(String message) {		
		final String METHOD_NAME = "publishPost";
		LogUtil.logStartMethod(LOG, METHOD_NAME);
		
		JsonObject response = facebookClient.publish(PAGE_NAME + URL_FEED, JsonObject.class, Parameter.with(KEY_MESSAGE, message));
		
		LogUtil.logEndMethod(LOG, METHOD_NAME);
		return response;
	}
	
	@Bean
	public FacebookClient facebookClient() {
		return new DefaultFacebookClient(ACCESS_TOKEN, Version.VERSION_8_0);
	}
	
}
