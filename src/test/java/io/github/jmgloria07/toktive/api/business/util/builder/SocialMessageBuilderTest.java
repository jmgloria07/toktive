package io.github.jmgloria07.toktive.api.business.util.builder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.github.jmgloria07.toktive.api.objects.SocialNetwork;
import io.github.jmgloria07.toktive.api.objects.exceptions.ToktiveServiceParameterException;
import io.github.jmgloria07.toktive.api.objects.messages.SocialMessage;

public class SocialMessageBuilderTest {
	
	SocialMessageBuilder unit;
	
	private static final String MOCK_VALID_MESSAGE = "VALID MESSAGE";
	
	private static final SocialNetwork MOCK_VALID_SOCIAL_NETWORK_RESULT 
								= SocialNetwork.TW;//get actual social network from SN enum
	private static final String MOCK_VALID_SOCIAL_NETWORK_PARAM 
								= MOCK_VALID_SOCIAL_NETWORK_RESULT.toString();
	private static final String MOCK_INVALID_SOCIAL_NETWORK_PARAM 
								= "NON_EXISTING_SOCIAL_NETWORK";
	
	@BeforeEach
	public void init() {
		unit = new SocialMessageBuilder();
	}
	
	@AfterEach
	public void destroy() {
		unit = null;
	}
	
	//Test methods
	@Test
	public void testValidMessageParam() {
		SocialMessage result = unit
				.withMessage(MOCK_VALID_MESSAGE)
				.build();
		assertEquals(MOCK_VALID_MESSAGE, result.getMessage());
	}
	
	@Test
	public void testValidSocialNetworkParam() {
		SocialMessage result = unit
				.withSocialNetwork(MOCK_VALID_SOCIAL_NETWORK_PARAM)
				.build();
		assertEquals(MOCK_VALID_SOCIAL_NETWORK_RESULT, result.getSocialNetwork());
	}
	
	@Test
	public void testNullMessageParam() {
		assertThrows(ToktiveServiceParameterException.class, () -> unit
				.withMessage(null)
				.build());
	}
	
	@Test
	public void testEmptyMessageParam() {
		assertThrows(ToktiveServiceParameterException.class, () -> unit
				.withMessage("")
				.build());
	}
	
	@Test
	public void testInvalidSocialNetworkParam() {
		assertThrows(ToktiveServiceParameterException.class, () -> unit
				.withSocialNetwork(MOCK_INVALID_SOCIAL_NETWORK_PARAM)
				.build());
	}
}
