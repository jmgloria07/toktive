package io.github.jmgloria07.toktive.api.business.delegate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.github.jmgloria07.toktive.api.business.share.ShareStrategy;
import io.github.jmgloria07.toktive.api.business.share.ShareStrategyContext;
import io.github.jmgloria07.toktive.api.objects.ToktiveCall;
import io.github.jmgloria07.toktive.api.objects.ToktivePost;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;

public class ToktiveShareDelegateImplTest {
	private static ToktiveShareDelegateImpl unit;
	
	private static final ToktiveCall MOCK_CALL_STATUS = new ToktiveCall(ToktiveCall.Status.FAIL, "", "");
	private static final String MOCK_MESSAGE = "Test tweet";
	private static final SocialNetwork MOCK_SOCIAL_NETWORK = SocialNetwork.TW;	

	@BeforeAll
	public static void init() {
		unit = new ToktiveShareDelegateImpl();
		
		unit.shareStrategyContext = mock(ShareStrategyContext.class);
		ShareStrategy mockStrategy = mock(ShareStrategy.class);
				
		doReturn(MOCK_CALL_STATUS).when(mockStrategy).share(any(ToktivePost.class));
		doReturn(mockStrategy).when(unit.shareStrategyContext).getStrategy(any(SocialNetwork.class));
	}

	/*
	 * Tests the share method. Returned value doesn't really matter (for now) as
	 * long as it doesn't throw an uncaught exception.
	 */
	@Test
	public void testShare() {
		ToktivePost mockSocialMessage = new ToktivePost();
		mockSocialMessage.setPost(MOCK_MESSAGE);
		mockSocialMessage.setSocialNetwork(MOCK_SOCIAL_NETWORK);
		
		Set<ToktivePost> mockSetMessages = new HashSet<>();
		mockSetMessages.add(mockSocialMessage);
		
		assertNotNull(unit.shareToAllNetworks(mockSetMessages));
	}

	@AfterAll
	public static void destroy() {
		unit = null;
	}
}
