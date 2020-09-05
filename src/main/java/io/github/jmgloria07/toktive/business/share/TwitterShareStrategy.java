package io.github.jmgloria07.toktive.business.share;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.authentication.TwitterAuth;
import io.github.jmgloria07.toktive.model.SocialMessage;
import io.github.jmgloria07.toktive.model.SocialNetwork;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@Component
public class TwitterShareStrategy implements ShareStrategy {

	@Autowired
	private TwitterAuth auth;
	
	@Override
	public void share(SocialMessage message) {
		//TODO: create proper logging
		System.out.println("sharing via Twitter: " + message);
		Twitter twitter = auth.getTwitterInstance();
		try {
			twitter.updateStatus(message.getMessage());
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

	@Override
	public SocialNetwork getStrategyName() {
		// TODO Auto-generated method stub
		return SocialNetwork.TW;
	}

}
