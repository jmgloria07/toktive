package io.github.jmgloria07.toktive.api.business.util.builder;

import java.util.Arrays;
import java.util.Optional;

import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.exceptions.ToktiveServiceParameterException;
import io.github.jmgloria07.toktive.api.objects.messages.SocialMessage;

/*
 * class to build the parameter object and validate the individual properties.
 */
public class SocialMessageBuilder {
	String message;
	SocialNetwork socialNetwork;
	
	public SocialMessageBuilder withSocialNetwork(String socialNetwork) {
		this.socialNetwork = Arrays.asList(SocialNetwork.values()).stream()
			.filter(enumValue -> enumValue.toString().equals(socialNetwork))
			.findFirst()
			.orElseThrow(() -> new ToktiveServiceParameterException("socialNetwork",  socialNetwork));	
		return this;
	}
	
	public SocialMessageBuilder withMessage(String message) {
		this.message = Optional.ofNullable(message)
				.filter(str -> !str.isEmpty())
				.orElseThrow(() -> new ToktiveServiceParameterException("message",  "null"));		
		return this;
	}
	
	public SocialMessage build() {
		SocialMessage socialMessage = new SocialMessage();
		socialMessage.setMessage(message);
		socialMessage.setSocialNetwork(socialNetwork);
		return socialMessage;
	}
}
