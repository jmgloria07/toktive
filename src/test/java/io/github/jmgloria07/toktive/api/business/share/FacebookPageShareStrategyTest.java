package io.github.jmgloria07.toktive.api.business.share;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.restfb.json.JsonObject;

import io.github.jmgloria07.toktive.api.business.call.FacebookPageCall;
import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.exceptions.ToktiveServiceParameterException;
import io.github.jmgloria07.toktive.api.objects.messages.SocialMessage;
import twitter4j.TwitterException;

public class FacebookPageShareStrategyTest {
	
	private static FacebookPageShareStrategy unit;
	
	@BeforeAll
	public static void init() throws TwitterException {
		unit = new FacebookPageShareStrategy();
		unit.auth = mock(FacebookPageCall.class);
		doReturn(mock(JsonObject.class)).when(unit.auth).publishPost(anyString());
	}
	
	@Test
	public void testShareWithNullParameter() {
		assertThrows(ToktiveServiceParameterException.class, () -> unit.share(null));
	}
	
	@Test
	public void testShareWithValidParameter() {
		SocialMessage validParam = new SocialMessage();
		validParam.setMessage("");
		validParam.setSocialNetwork(SocialNetwork.FB_PAGES);
		
		assertNotNull(unit.share(validParam));
	}
	
	@Test
	public void testGetStrategyName() {
		assertEquals(SocialNetwork.FB_PAGES, unit.getStrategyName());
	}
	
	@AfterAll
	public static void destroy() {
		unit = null;
	}
}
