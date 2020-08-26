package io.github.jmgloria07.toktive;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import io.github.jmgloria07.toktive.business.ToktiveService;
import io.github.jmgloria07.toktive.business.ToktiveServiceImpl;

@SpringBootApplication
public class ToktiveApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(ToktiveApplication.class, args);
		
		//if (startInConsole)
		ToktiveService service = appContext.getBean(ToktiveServiceImpl.class);
		
		service.share("test share post", new HashSet<>(Arrays.asList("TW","FB")));
	}

}
