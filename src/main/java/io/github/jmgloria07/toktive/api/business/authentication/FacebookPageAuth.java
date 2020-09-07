package io.github.jmgloria07.toktive.api.business.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.json.JsonObject;

@Configuration
@PropertySource("classpath:api.tokens.properties")
public class FacebookPageAuth {	
	
	@Value("${fb.oauth.access.token}")
	private String ACCESS_TOKEN;
	
	@Value("${fb.oauth.page.name}")
	private String PAGE_NAME;
	
	private static final String URL_FEED = "/feed";
	private static final String KEY_MESSAGE = "message";
		
	@Autowired
	FacebookClient facebookClient;
	
	public FacebookPageAuth() {
		
	}
	
	public JsonObject publishPost(String message) {		
		return facebookClient.publish(PAGE_NAME + URL_FEED, JsonObject.class, Parameter.with(KEY_MESSAGE, message));
	}
	
	@Bean
	public FacebookClient setFacebookClient() {
		return new DefaultFacebookClient(ACCESS_TOKEN, Version.VERSION_8_0);
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
