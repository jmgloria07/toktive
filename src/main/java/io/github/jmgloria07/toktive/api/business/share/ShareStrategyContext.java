package io.github.jmgloria07.toktive.api.business.share;

import java.util.Optional;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.api.objects.SocialNetwork;

@Component
public class ShareStrategyContext {
	
	@Resource
	private Set<ShareStrategy> strategies;
	
	public ShareStrategyContext(Set<ShareStrategy> strategies) {
		this.strategies = strategies;
	}
	
	public ShareStrategy getStrategy(SocialNetwork network) {
		Optional<ShareStrategy> optStrategy =  strategies.stream()
		.filter(strategy -> strategy.getStrategyName().equals(network)).findFirst();
		
		return optStrategy.get();
		
	}
	
}
