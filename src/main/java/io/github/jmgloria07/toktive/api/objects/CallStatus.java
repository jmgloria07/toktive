package io.github.jmgloria07.toktive.api.objects;

public class CallStatus {
	public enum Status {
		SUCCESS,
		FAIL,
		PARTIAL
	}
	
	private Status status;
	
	private String link;
	
	private String errorMessage;

	public CallStatus() {
		
	}
	
	public CallStatus(Status status, String link, String errorMessage) {
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
	
	public boolean isCallSuccessful() {
		return getStatus() == Status.SUCCESS;
	}
	
	@Override
	public String toString() {
		return "CallStatus [status=" + status + ", link=" + link + ", errorMessage=" + errorMessage + "]";
	}
}
