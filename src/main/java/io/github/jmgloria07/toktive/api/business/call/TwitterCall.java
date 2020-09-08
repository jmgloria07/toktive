package io.github.jmgloria07.toktive.api.business.call;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
@PropertySource("classpath:api.tokens.properties")
public class TwitterCall {
	
	@Value("${twitter.oauth.consumerKey}")
	private String CONSUMER_KEY;
	
	@Value("${twitter.oauth.consumerSecret}")
	private String CONSUMER_SECRET;
	
	@Value("${twitter.oauth.accessToken}")
	private String ACCESS_TOKEN;
	
	@Value("${twitter.oauth.accessTokenSecret}")
	private String ACCESS_TOKEN_SECRET;

	@Autowired
	Twitter twitter;
	
	public Status publish(String tweet) throws TwitterException {
		Optional<Status> status = Optional.empty();
		try {
			status = Optional.of(twitter.updateStatus(tweet));
		} catch (TwitterException e) {
			throw e;
		}
		
		return status.get();
	}
	
	@Bean
	public Twitter twitter() {
		ConfigurationBuilder configBuilder = new ConfigurationBuilder();
	    configBuilder.setDebugEnabled(true)
	    .setOAuthConsumerKey(CONSUMER_KEY)
	    .setOAuthConsumerSecret(CONSUMER_SECRET)
	    .setOAuthAccessToken(ACCESS_TOKEN)
	    .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

	    TwitterFactory twitterFactory = new TwitterFactory(configBuilder.build());
	    return twitterFactory.getInstance();
	}
}
