package io.github.jmgloria07.toktive.api.objects;

public enum SocialNetwork {
	
	FB(true, "Facebook"),
	TW(false, "Twitter"),
	FB_PAGES(false, "Facebook Pages");
	
	private boolean deprecated;
	
	private String displayName;
	
	private SocialNetwork(boolean deprecated, String displayName) {
		this.deprecated = deprecated;
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		return displayName;
	}

	public boolean isDeprecated() {
		return deprecated;
	}
	

}
