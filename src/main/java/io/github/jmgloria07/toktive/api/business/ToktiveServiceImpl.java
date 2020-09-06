package io.github.jmgloria07.toktive.api.business;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.jmgloria07.toktive.api.business.delegate.SocialDelegate;
import io.github.jmgloria07.toktive.api.objects.SocialMessage;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;

@Service
public class ToktiveServiceImpl implements ToktiveService {
	
	@Autowired
	final SocialDelegate socialDelegate;
	
	public ToktiveServiceImpl(SocialDelegate socialDelegate) {
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
