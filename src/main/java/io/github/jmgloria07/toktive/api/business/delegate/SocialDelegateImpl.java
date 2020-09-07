package io.github.jmgloria07.toktive.api.business.delegate;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.api.business.share.ShareStrategy;
import io.github.jmgloria07.toktive.api.business.share.ShareStrategyContext;
import io.github.jmgloria07.toktive.api.objects.SocialMessage;
import io.github.jmgloria07.toktive.api.objects.SocialStatus;
import io.github.jmgloria07.toktive.api.objects.ToktiveError;
import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;

@Component
public class SocialDelegateImpl implements SocialDelegate {

	@Autowired
	private ShareStrategyContext shareStrategyContext;
	
	public SocialDelegateImpl(ShareStrategyContext shareStrategyContext) {
		this.shareStrategyContext = shareStrategyContext;
	}
	
	@Override
	public List<ToktiveResponse> shareToAllNetworks(Set<SocialMessage> socialMessages) {
		
		//do each strategy
		Set<SocialStatus> socialStatuses = socialMessages.stream()
			.map(socialMessage -> {
				ShareStrategy strategy = shareStrategyContext.getStrategy(socialMessage.getSocialNetwork());
				return strategy.share(socialMessage);
			}).collect(Collectors.toSet());
		
		//create list of response objects
		List<ToktiveResponse> response = socialStatuses.parallelStream()
				.map(SocialDelegateImpl::buildResponse)
				.collect(Collectors.toList());
		
		return response;
	}
	
	private static ToktiveResponse buildResponse(SocialStatus socialStatus) {
		ToktiveResponse result = new ToktiveResponse();
		result.setId(socialStatus.getLink());
		result.setUrl(socialStatus.getLink());
		result.setStatus(socialStatus.getStatus().toString());
		if (StringUtils.isNotEmpty(socialStatus.getErrorMessage())) {
			ToktiveError error = new ToktiveError(socialStatus.getErrorMessage());
			result.setError(error);
		}
		return result;
	}

}
