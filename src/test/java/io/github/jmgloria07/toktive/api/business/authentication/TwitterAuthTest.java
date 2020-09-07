package io.github.jmgloria07.toktive.api.business.authentication;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import twitter4j.TwitterException;

public class TwitterAuthTest {
	
	private static TwitterAuth unit;
	
	@BeforeAll
	public static void init() {
		unit = mock(TwitterAuth.class);
	}
	
	@Test
	public void testGetTwitterInstance() throws TwitterException {
		unit.publish("");
	}
	
	@AfterAll
	public static void destroy() {
		unit = null;
	}
	
}
