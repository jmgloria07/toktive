package io.github.jmgloria07.toktive.api.business.delegate;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.api.business.share.ShareStrategy;
import io.github.jmgloria07.toktive.api.business.share.ShareStrategyContext;
import io.github.jmgloria07.toktive.api.objects.CallStatus;
import io.github.jmgloria07.toktive.api.objects.ToktiveError;
import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;
import io.github.jmgloria07.toktive.api.objects.messages.SocialMessage;

/*
 * Default implementation of the share delegate
 */
@Component
public class ToktiveShareDelegateImpl implements ToktiveShareDelegate {

	@Autowired
	private ShareStrategyContext shareStrategyContext;
	
	public ToktiveShareDelegateImpl(ShareStrategyContext shareStrategyContext) {
		this.shareStrategyContext = shareStrategyContext;
	}
	
	@Override
	public List<ToktiveResponse> shareToAllNetworks(Set<SocialMessage> socialMessages) {
		
		//do each strategy
		Set<CallStatus> socialStatuses = socialMessages.stream()
			.map(socialMessage -> {
				ShareStrategy strategy = shareStrategyContext.getStrategy(socialMessage.getSocialNetwork());
				return strategy.share(socialMessage);
			}).collect(Collectors.toSet());
		
		//create list of response objects
		List<ToktiveResponse> response = socialStatuses.parallelStream()
				.map(ToktiveShareDelegateImpl::buildResponse)
				.collect(Collectors.toList());
		
		return response;
	}
	
	private static ToktiveResponse buildResponse(CallStatus socialStatus) {
		ToktiveResponse result = new ToktiveResponse(); 
		result.setUrl(socialStatus.getLink());
		result.setStatus(socialStatus.getStatus().toString());
		result.setError(
			Optional.ofNullable(socialStatus.getErrorMessage())
			.filter(str -> !str.isEmpty())
			.map(errorMessage -> new ToktiveError(errorMessage))
			.orElseGet(() -> null)
		);
		return result;
	}

}
