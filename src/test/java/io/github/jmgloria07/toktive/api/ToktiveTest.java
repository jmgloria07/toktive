package io.github.jmgloria07.toktive.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import io.github.jmgloria07.toktive.api.business.ToktiveService;

public class ToktiveTest {
	
	private static final String TEST_MESSAGE = "This is a test message";
	
	private static final Set<String> MOCK_NETWORKS = new HashSet<>(Arrays.asList("FB", "TW"));
	
	@Test
	public void testGetAndDestroy() {
		Toktive unit = Toktive.getInstance();
		assertNotNull(unit);
		unit.close();
		assertFalse(Toktive.isInstantiated());
	}
	
	@Test
	public void testShare() {
		Toktive unit = Toktive.getInstance();
		Toktive.toktiveService = mock(ToktiveService.class);
		doNothing().when(Toktive.toktiveService).share(anyString(), anySet());
		unit.share(TEST_MESSAGE, MOCK_NETWORKS);
		unit.close();
	}
	
	@Test
	public void testShareThrowException() {
		Toktive unit = Toktive.getInstance();
		Toktive.toktiveService = mock(ToktiveService.class);
		doThrow(RuntimeException.class).when(Toktive.toktiveService).share(anyString(), anySet());
		assertThrows(RuntimeException.class, 
				() -> unit.share(TEST_MESSAGE, MOCK_NETWORKS));
		unit.close();
	}
}
