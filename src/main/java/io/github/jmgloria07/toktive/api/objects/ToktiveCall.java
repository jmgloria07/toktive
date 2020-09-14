package io.github.jmgloria07.toktive.api.objects;

import java.util.Optional;

import io.github.jmgloria07.toktive.api.objects.exceptions.ToktiveServiceParameterException;

/*
 * Response object of each call to a specific third-party service
 */
public class ToktiveCall {
	public enum Status {
		SUCCESS,
		FAIL,
		PARTIAL
	}
	
	private Status status;
	
	private String link;
	
	private String errorMessage;

	public ToktiveCall() {
		
	}
	
	public ToktiveCall(Status status, String link, String errorMessage) {
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
		return Optional.ofNullable(getStatus())
				.map(status -> status == Status.SUCCESS)
				.orElseThrow(() -> new ToktiveServiceParameterException("status"));
	}
	
	@Override
	public String toString() {
		return "ToktiveCall [status=" + status + ", link=" + link + ", errorMessage=" + errorMessage + "]";
	}
}
