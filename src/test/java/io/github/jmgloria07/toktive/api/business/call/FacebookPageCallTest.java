package io.github.jmgloria07.toktive.api.business.call;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FacebookPageCallTest {
	private static FacebookPageCall unit;
	
	@BeforeAll
	public static void init() {
		unit = mock(FacebookPageCall.class);
	}
	
	@Test
	public void testGetTwitterInstance() {
		unit.publishPost("");
	}
	
	@AfterAll
	public static void destroy() {
		unit = null;
	}
}
