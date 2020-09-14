package io.github.jmgloria07.toktive.api.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.github.jmgloria07.toktive.api.business.delegate.ToktiveShareDelegate;
import io.github.jmgloria07.toktive.api.business.util.builder.ToktivePostBuilder;
import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;

public class ToktiveServiceImplTest {
	
	private static ToktiveShareServiceImpl unit;
	
	private static Set<String> MOCK_SET_SNS;
	private static final String MOCK_MESSAGE = "This is a mock message.";
	private static final String MOCK_SNS = "FB,TW";
	
	
	@BeforeAll
	public static void init() {
		unit = new ToktiveShareServiceImpl();
		
		unit.toktiveShareDelegate = mock(ToktiveShareDelegate.class);
		unit.socialMessageBuilder = mock(ToktivePostBuilder.class);
		
		doReturn(unit.socialMessageBuilder).when(unit.socialMessageBuilder).withMessage(anyString());
		doReturn(unit.socialMessageBuilder).when(unit.socialMessageBuilder).withSocialNetwork(anyString());
		doReturn(new ArrayList<ToktiveResponse>()).when(unit.toktiveShareDelegate).shareToAllNetworks(anySet());
		
		MOCK_SET_SNS = new HashSet<>(
				Arrays.asList(MOCK_SNS.split(",")));
	}
	
	/* 
	 * Tests the share method. Returned value doesn't really matter 
	 * (for now) as long as it doesn't throw an uncaught exception.
	 */
	@Test
	public void testShare() {
		assertNotNull(unit.share(MOCK_MESSAGE, MOCK_SET_SNS));
	}
	
	@AfterAll
	public static void destroy() {
		unit = null;
		MOCK_SET_SNS = null;
	}
}
