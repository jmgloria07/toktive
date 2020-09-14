package io.github.jmgloria07.toktive.api.business;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jmgloria07.toktive.api.business.delegate.ToktiveShareDelegate;
import io.github.jmgloria07.toktive.api.business.util.builder.ToktivePostBuilder;
import io.github.jmgloria07.toktive.api.objects.ToktivePost;
import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;

/*
 * Default share service implementation
 */
@Service
public class ToktiveShareServiceImpl implements ToktiveShareService {
	
	@Autowired
	ToktiveShareDelegate toktiveShareDelegate;
	
	@Autowired
	ToktivePostBuilder socialMessageBuilder;
	
	@Override
	public List<ToktiveResponse> share(String message, Set<String> networks) {
		Set<ToktivePost> posts = networks.stream()
			.map(network -> {
				return socialMessageBuilder.withMessage(message)
						.withSocialNetwork(network)
						.build();
			}).collect(Collectors.toSet());
		
		return toktiveShareDelegate.shareToAllNetworks(posts);
	}

}
