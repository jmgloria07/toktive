package io.github.jmgloria07.toktive.api.objects.exceptions;

/**
 * Root service exception
 */
public abstract class ToktiveServiceException extends RuntimeException {
	
	private static final long serialVersionUID = -2002933252596216528L;
	
	public ToktiveServiceException () {
		super();
	}
	
	public ToktiveServiceException (String errorMessage) {
		super(errorMessage);
	}
	
	public ToktiveServiceException(Throwable e) {
		super(e);
	}

}
