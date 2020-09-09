package io.github.jmgloria07.toktive.api.objects;

public enum SocialNetwork {
	
	FB(true),
	TW(false),
	FB_PAGES(false);
	
	private boolean deprecated;
	
	public boolean isDeprecated() {
		return deprecated;
	}
	
	private SocialNetwork(boolean deprecated) {
		this.deprecated = deprecated;
	}
}
