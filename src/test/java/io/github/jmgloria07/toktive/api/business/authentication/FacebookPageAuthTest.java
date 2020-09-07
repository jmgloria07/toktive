package io.github.jmgloria07.toktive.api.business.authentication;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FacebookPageAuthTest {
	private static FacebookPageAuth unit;
	
	@BeforeAll
	public static void init() {
		unit = mock(FacebookPageAuth.class);
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
