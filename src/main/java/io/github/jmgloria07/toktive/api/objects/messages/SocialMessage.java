package io.github.jmgloria07.toktive.api.objects.messages;

import io.github.jmgloria07.toktive.api.objects.SocialNetwork;

public class SocialMessage {
	protected String message;
	
	protected SocialNetwork socialNetwork;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public SocialNetwork getSocialNetwork() {
		return socialNetwork;
	}

	public void setSocialNetwork(SocialNetwork socialNetwork) {
		this.socialNetwork = socialNetwork;
	}

	@Override
	public String toString() {
		return "SocialMessage [message=" + message + ", socialNetwork=" + socialNetwork + "]";
	}
}
