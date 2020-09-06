package io.github.jmgloria07.toktive.api.business.authentication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
@PropertySource("classpath:api.tokens.properties")
public class TwitterAuth {
	
	@Value("${twitter.oauth.consumerKey}")
	private String CONSUMER_KEY;
	
	@Value("${twitter.oauth.consumerSecret}")
	private String CONSUMER_SECRET;
	
	@Value("${twitter.oauth.accessToken}")
	private String ACCESS_TOKEN;
	
	@Value("${twitter.oauth.accessTokenSecret}")
	private String ACCESS_TOKEN_SECRET;

	@Bean
	public Twitter getTwitterInstance() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
	    cb.setDebugEnabled(true)
	    .setOAuthConsumerKey(CONSUMER_KEY)
	    .setOAuthConsumerSecret(CONSUMER_SECRET)
	    .setOAuthAccessToken(ACCESS_TOKEN)
	    .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

	    TwitterFactory tf = new TwitterFactory(cb.build());
	    return tf.getInstance();
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
