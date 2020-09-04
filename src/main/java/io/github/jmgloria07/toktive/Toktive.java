package io.github.jmgloria07.toktive;

import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.github.jmgloria07.toktive.business.ToktiveService;

public class Toktive {
	
	private static ClassPathXmlApplicationContext appContext;
	
	private static Toktive toktive;
	
	private static ToktiveService toktiveService;
	
	public static Toktive getInstance() {
		if (toktive == null) {
			appContext = new ClassPathXmlApplicationContext("toktive-application-context.xml");
			toktiveService = appContext.getBean(ToktiveService.class);
			toktive = new Toktive();
		}
		return toktive;
	}
	
	public void share(String message, Set<String> networks) {
		toktiveService.share(message, networks);
	}
	
	public static void close() {
		appContext.close();
		appContext = null;
		toktive = null;
	}
}
