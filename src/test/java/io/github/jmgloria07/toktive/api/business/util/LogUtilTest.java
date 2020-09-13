package io.github.jmgloria07.toktive.api.business.util;

import static org.mockito.Mockito.*;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class LogUtilTest {
	
	private static final Logger MOCK_LOGGER = mock(Logger.class);
	
	private static final String MOCK_METHOD_NAME = "doMethod";
	private static final String MOCK_INFO = "This is an info";
	private static final String MOCK_FIELD = "field";
	private static final String MOCK_VALUE = "value";
	
	@Test
	public void testLogException() {
		LogUtil.logException(MOCK_LOGGER, mock(Exception.class));
	}
	
	@Test
	public void testLogStartMethod() {
		LogUtil.logStartMethod(MOCK_LOGGER, MOCK_METHOD_NAME);
	}
	
	@Test
	public void testLogEndMethod() {
		LogUtil.logEndMethod(MOCK_LOGGER, MOCK_METHOD_NAME);
	}
	
	@Test
	public void testLogInfo() {
		LogUtil.logInfo(MOCK_LOGGER, MOCK_INFO);
	}
	
	@Test
	public void testLogValue() {
		LogUtil.logValue(MOCK_LOGGER, MOCK_FIELD, MOCK_VALUE);
	}
	
}
