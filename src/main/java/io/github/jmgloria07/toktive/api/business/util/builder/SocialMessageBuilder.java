package io.github.jmgloria07.toktive.api.business.util.builder;

import java.util.Arrays;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.jmgloria07.toktive.api.business.util.LogUtil;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.exceptions.ToktiveServiceParameterException;
import io.github.jmgloria07.toktive.api.objects.messages.SocialMessage;

/*
 * class to build the parameter object and validate the individual properties.
 */
public class SocialMessageBuilder {
	
	private static final Logger LOG = LogManager.getLogger(SocialMessageBuilder.class);
	
	String message;
	SocialNetwork socialNetwork;
	
	public SocialMessageBuilder withSocialNetwork(String socialNetwork) {
		this.socialNetwork = Arrays.asList(SocialNetwork.values()).stream()
			.filter(enumValue -> enumValue.toString().equals(socialNetwork))
			.findFirst()
			.orElseThrow(() -> {
				ToktiveServiceParameterException parameterException = new ToktiveServiceParameterException("socialNetwork",  socialNetwork);
				LogUtil.logException(LOG, parameterException);
				return parameterException;
			});	
		return this;
	}
	
	public SocialMessageBuilder withMessage(String message) {
		this.message = Optional.ofNullable(message)
				.filter(str -> !str.isEmpty())
				.orElseThrow(() -> {
					ToktiveServiceParameterException parameterException = new ToktiveServiceParameterException("message",  message);
					LogUtil.logException(LOG, parameterException);
					return parameterException;
				});		
		return this;
	}
	
	public SocialMessage build() {
		SocialMessage socialMessage = new SocialMessage();
		socialMessage.setMessage(message);
		socialMessage.setSocialNetwork(socialNetwork);
		return socialMessage;
	}
}
