package io.github.jmgloria07.toktive.api.business.delegate;

import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.github.jmgloria07.toktive.api.business.share.ShareStrategyContext;
import io.github.jmgloria07.toktive.api.objects.SocialMessage;

public class SocialDelegateImplTest {
	private static SocialDelegateImpl unit;
	
	@BeforeAll
	public static void init() {
		unit = new SocialDelegateImpl(mock(ShareStrategyContext.class));	
	}
	
	/* 
	 * Tests the share method. Returned value doesn't really matter 
	 * (for now) as long as it doesn't throw an uncaught exception.
	 */
	@Test
	public void testShare() {
		Set<SocialMessage> MOCK_SET_MSGS = new HashSet<>();	
		unit.shareToAllNetworks(MOCK_SET_MSGS);
	}
	
	@AfterAll
	public static void destroy() {
		unit = null;
	}
}
