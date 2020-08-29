package io.github.jmgloria07.toktive.authentication;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TwitterAuthTest {
	
	private static TwitterAuth unit;
	
	@BeforeAll
	public static void init() {
		unit = mock(TwitterAuth.class);
	}
	
	@Test
	public void testGetTwitterInstance() {
		unit.getTwitterInstance();
	}
	
	@AfterAll
	public static void destroy() {
		unit = null;
	}
	
}
