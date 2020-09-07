package io.github.jmgloria07.toktive.api.business.call;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import twitter4j.TwitterException;

public class TwitterAuthTest {
	
	private static TwitterCall unit;
	
	@BeforeAll
	public static void init() {
		unit = mock(TwitterCall.class);
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
