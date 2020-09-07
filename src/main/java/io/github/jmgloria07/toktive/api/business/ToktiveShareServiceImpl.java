package io.github.jmgloria07.toktive.api.business;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jmgloria07.toktive.api.business.delegate.ToktiveShareDelegate;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;
import io.github.jmgloria07.toktive.api.objects.messages.SocialMessage;

@Service
public class ToktiveShareServiceImpl implements ToktiveShareService {
	
	@Autowired
	final ToktiveShareDelegate socialDelegate;
	
	public ToktiveShareServiceImpl(ToktiveShareDelegate socialDelegate) {
		this.socialDelegate = socialDelegate;
	}
	
	@Override
	public List<ToktiveResponse> share(String message, Set<String> networks) {

		Set<SocialMessage> socialMessages = networks.stream()
		.map(network -> {
			SocialMessage socialMessage = new SocialMessage();
			socialMessage.setMessage(message);
			socialMessage.setSocialNetwork(SocialNetwork.valueOf(network));
			return socialMessage;
		}).collect(Collectors.toSet());
		
		return socialDelegate.shareToAllNetworks(socialMessages);
	}

}
