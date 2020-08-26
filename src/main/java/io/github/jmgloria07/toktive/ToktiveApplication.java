package io.github.jmgloria07.toktive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import io.github.jmgloria07.toktive.business.ToktiveService;
import io.github.jmgloria07.toktive.business.ToktiveServiceImpl;

@SpringBootApplication
public class ToktiveApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(ToktiveApplication.class, args);
		ToktiveService service = appContext.getBean(ToktiveServiceImpl.class);
		
		System.out.println(service.share(null, null));
	}

}
