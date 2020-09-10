package io.github.jmgloria07.toktive.api.business.util;

import org.apache.logging.log4j.Logger;

public class LogUtil {
	
	public static final void logException(Logger logger, Exception e) {
		logger.error(e);
	}
	
	public static final void logStartMethod(Logger logger, String methodName) {
		logger.debug("entering method: " + methodName);
	}
	
	public static final void logEndMethod(Logger logger, String methodName) {
		logger.debug("exiting method: " + methodName);
	}
	
	public static final void logValue(Logger logger, String name, String value) {
		logger.debug("name: " + name + " value: " + value);
	}
	
	public static final void logInfo(Logger logger, String info) {
		logger.info(info);
	}
}
