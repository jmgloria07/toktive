package io.github.jmgloria07.toktive.api.business.share;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.github.jmgloria07.toktive.api.business.call.TwitterCall;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.ToktivePost;
import io.github.jmgloria07.toktive.api.objects.exceptions.ToktiveServiceParameterException;
import twitter4j.Status;
import twitter4j.TwitterException;

public class TwitterShareStrategyTest {
	
	private static TwitterShareStrategy unit;
	
	@BeforeAll
	public static void init() throws TwitterException {
		unit = new TwitterShareStrategy();
		unit.auth = mock(TwitterCall.class);
		doReturn(mock(Status.class)).when(unit.auth).publish(anyString());
	}
	
	@Test
	public void testShareWithNullParameter() {
		assertThrows(ToktiveServiceParameterException.class, () -> unit.share(null));
	}
	
	@Test
	public void testShareWithValidParameter() {
		ToktivePost validParam = new ToktivePost();
		validParam.setPost("");
		validParam.setSocialNetwork(SocialNetwork.TW);
		
		assertNotNull(unit.share(validParam));
	}
	
	@Test
	public void testGetStrategyName() {
		assertEquals(SocialNetwork.TW, unit.getStrategyName());
	}
	
	@AfterAll
	public static void destroy() {
		unit = null;
	}
}
