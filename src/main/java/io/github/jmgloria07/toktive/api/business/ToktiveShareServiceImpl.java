package io.github.jmgloria07.toktive.api.business;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jmgloria07.toktive.api.business.delegate.ToktiveShareDelegate;
import io.github.jmgloria07.toktive.api.business.util.builder.SocialMessageBuilder;
import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;
import io.github.jmgloria07.toktive.api.objects.messages.SocialMessage;

/*
 * Default share service implementation
 */
@Service
public class ToktiveShareServiceImpl implements ToktiveShareService {
	
	@Autowired
	final ToktiveShareDelegate toktiveShareDelegate;
	
	public ToktiveShareServiceImpl(ToktiveShareDelegate toktiveShareDelegate) {
		this.toktiveShareDelegate = toktiveShareDelegate;
	}
	
	@Override
	public List<ToktiveResponse> share(String message, Set<String> networks) {

		Set<SocialMessage> socialMessages = networks.stream()
		.map(network -> {
			SocialMessageBuilder soci = new SocialMessageBuilder();
			return soci.withMessage(message)
					.withSocialNetwork(network)
					.build();
		}).collect(Collectors.toSet());
		
		return toktiveShareDelegate.shareToAllNetworks(socialMessages);
	}

}
