package io.github.jmgloria07.toktive.api.business.util.builder;

import java.util.Arrays;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.api.business.util.LogUtil;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.ToktivePost;
import io.github.jmgloria07.toktive.api.objects.exceptions.ToktiveServiceParameterException;

/*
 * class to build the parameter object and validate the individual properties.
 */
@Component
public class ToktivePostBuilder {
	
	private static final Logger LOG = LogManager.getLogger(ToktivePostBuilder.class);
	
	String message;
	
	SocialNetwork socialNetwork;
	
	public ToktivePostBuilder withSocialNetwork(String socialNetwork) {
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
	
	public ToktivePostBuilder withMessage(String message) {
		this.message = Optional.ofNullable(message)
				.filter(str -> !str.isEmpty())
				.orElseThrow(() -> {
					ToktiveServiceParameterException parameterException = new ToktiveServiceParameterException("message",  message);
					LogUtil.logException(LOG, parameterException);
					return parameterException;
				});		
		return this;
	}
	
	public ToktivePost build() {
		ToktivePost result = new ToktivePost();
		result.setPost(message);
		result.setSocialNetwork(socialNetwork);
		return result;
	}
}
