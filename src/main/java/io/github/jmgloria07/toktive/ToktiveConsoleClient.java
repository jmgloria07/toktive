package io.github.jmgloria07.toktive;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import io.github.jmgloria07.toktive.business.ToktiveService;

@Component
public class ToktiveConsoleClient implements CommandLineRunner {

	@Autowired
	private ToktiveService toktiveService;
	
	@Override
	public void run(String... args) throws Exception {
		toktiveService.share("\"Mr. Watson come over here.\"", new HashSet<>(Arrays.asList("TW","FB")));
	}

}
