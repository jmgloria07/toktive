package io.github.jmgloria07.toktive.api.objects.exceptions;

/*
 * exception that deals with parameters
 */
public class ToktiveServiceParameterException extends ToktiveServiceException {

	private static final long serialVersionUID = -4576377816817238150L;
	
	public static final String ERROR_UNABLE_TO_FIND_STRATEGY="Parameter is invalid. ";
	
	public ToktiveServiceParameterException () {
		super();
	}
	
	public ToktiveServiceParameterException(String param) {
		super(ERROR_UNABLE_TO_FIND_STRATEGY
				+ param);
	}
	
	public ToktiveServiceParameterException(String param, String value) {
		super(ERROR_UNABLE_TO_FIND_STRATEGY
				+ "param: " + param
				+ "value: " + value);
	}

}
