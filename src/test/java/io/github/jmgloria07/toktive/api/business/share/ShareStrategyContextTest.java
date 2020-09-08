package io.github.jmgloria07.toktive.api.business.share;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.exceptions.ToktiveServiceParameterException;

public class ShareStrategyContextTest {
	private static ShareStrategyContext unit;	
	
	@BeforeAll
	public static void init() {		
		Set<ShareStrategy> mockSetStrats = new HashSet<>();
		mockSetStrats.add(new FacebookPageShareStrategy());
		mockSetStrats.add(new TwitterShareStrategy());
		unit = new ShareStrategyContext(mockSetStrats);
	}
	
	/* 
	 * Test enum params if they get the actual strategy instance
	 */
	@Test
	public void testFbStrategy() {
		ShareStrategy shareStrategy = unit.getStrategy(SocialNetwork.FB_PAGES);
		assertTrue(shareStrategy instanceof FacebookPageShareStrategy);
	}
	
	@Test
	public void testTwStrategy() {
		ShareStrategy shareStrategy = unit.getStrategy(SocialNetwork.TW);
		assertTrue(shareStrategy instanceof TwitterShareStrategy);
	}
	
	/*
	 * Test the unit's behavior if it wasn't included in the strategy set.
	 * FB wasn't included at the mocked strategy set
	 */
	@Test
	public void testStrategyNotFound() {
		assertThrows(ToktiveServiceParameterException.class, 
				() -> unit.getStrategy(SocialNetwork.FB));
	}
	
	@AfterAll
	public static void destroy() {
		unit = null;
	}
}
