package io.github.jmgloria07.toktive.api.business.share;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.exceptions.ToktiveServiceParameterException;

/*
 * Strategy context class that maps the request to 
 * which corresponding API call it uses.
 */
@Component
public class ShareStrategyContext {
	
	@Resource
	private Set<ShareStrategy> strategies;
	
	public ShareStrategyContext(Set<ShareStrategy> strategies) {
		this.strategies = strategies;
	}
	
	public ShareStrategy getStrategy(SocialNetwork network) {
		return strategies.stream()
		.filter(strategy -> strategy.getStrategyName().equals(network))
		.findFirst()
		.orElseThrow( () -> 
			new ToktiveServiceParameterException("network", network.toString()));
	}
	
}
