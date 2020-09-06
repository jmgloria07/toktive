package io.github.jmgloria07.toktive.api.objects;

public class SocialStatus {
	public enum Status {
		SUCCESS,
		FAIL
	}
	
	private Status status;
	
	private String link;
	
	private String errorMessage;

	public SocialStatus() {
		
	}
	
	public SocialStatus(Status status, String link, String errorMessage) {
		super();
		this.status = status;
		this.link = link;
		this.errorMessage = errorMessage;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String toString() {
		return "SocialStatus [status=" + status + ", link=" + link + "]";
	}
}
