package io.github.jmgloria07.toktive.api.objects;

public class ToktivePost {
	protected String post;
	
	protected SocialNetwork socialNetwork;

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}
	
	public SocialNetwork getSocialNetwork() {
		return socialNetwork;
	}

	public void setSocialNetwork(SocialNetwork socialNetwork) {
		this.socialNetwork = socialNetwork;
	}

	@Override
	public String toString() {
		return "ToktivePost [post=" + post + ", socialNetwork=" + socialNetwork + "]";
	}
}
