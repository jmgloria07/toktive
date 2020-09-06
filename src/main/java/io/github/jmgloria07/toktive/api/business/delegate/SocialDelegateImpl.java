package io.github.jmgloria07.toktive.api.business.delegate;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.api.business.share.ShareStrategy;
import io.github.jmgloria07.toktive.api.business.share.ShareStrategyContext;
import io.github.jmgloria07.toktive.api.objects.SocialMessage;

@Component
public class SocialDelegateImpl implements SocialDelegate {

	@Autowired
	private ShareStrategyContext shareStrategyContext;
	
	public SocialDelegateImpl(ShareStrategyContext shareStrategyContext) {
		this.shareStrategyContext = shareStrategyContext;
	}
	
	@Override
	public void shareToAllNetworks(Set<SocialMessage> socialMessages) {
		
		socialMessages.stream()
			.forEach(socialMessage -> {
				ShareStrategy strategy = shareStrategyContext.getStrategy(socialMessage.getSocialNetwork());
				strategy.share(socialMessage);
			});
		
	}

}
