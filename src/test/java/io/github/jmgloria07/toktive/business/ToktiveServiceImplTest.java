package io.github.jmgloria07.toktive.business;

import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.github.jmgloria07.toktive.business.delegate.SocialDelegate;

public class ToktiveServiceImplTest {
	
	private static ToktiveServiceImpl unit;
	
	private static Set<String> MOCK_SET_SNS;
	private static final String MOCK_MESSAGE = "This is a mock message.";
	private static final String MOCK_SNS = "FB,TW";
	
	
	@BeforeAll
	public static void init() {
		unit = new ToktiveServiceImpl(mock(SocialDelegate.class));
		MOCK_SET_SNS = new HashSet<>(
				Arrays.asList(MOCK_SNS.split(",")));
	}
	
	/* 
	 * Tests the share method. Returned value doesn't really matter 
	 * (for now) as long as it doesn't throw an uncaught exception.
	 */
	@Test
	public void testShare() {
		unit.share(MOCK_MESSAGE, MOCK_SET_SNS);
	}
	
	@AfterAll
	public static void destroy() {
		unit = null;
		MOCK_SET_SNS = null;
	}
}
