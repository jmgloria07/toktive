package io.github.jmgloria07.toktive.api.objects;

public class ToktiveError {
	private String errorMessage;

	public ToktiveError(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
	public ToktiveError() {
		super();
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ToktiveError [errorMessage=" + errorMessage + "]";
	}
}
