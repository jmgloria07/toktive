package io.github.jmgloria07.toktive;

import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.github.jmgloria07.toktive.business.ToktiveService;

public class Toktive implements AutoCloseable {
	
	static ClassPathXmlApplicationContext appContext;
	
	static Toktive toktive;
	
	static ToktiveService toktiveService;
	
	//restrict instantiation outside the class
	private Toktive() {
		
	}
	
	//singleton methods
	public static Toktive getInstance() {
		if (!isInstantiated()) {
			appContext = new ClassPathXmlApplicationContext("toktive-application-context.xml");
			toktiveService = appContext.getBean(ToktiveService.class);
			toktive = new Toktive();
		}
		return toktive;
	}

	@Override
	public void close() {
		if (isInstantiated()) {
			appContext.close();
			appContext = null;
			toktive = null;
		}
	}
	
	public static boolean isInstantiated() {
		return toktive != null || appContext != null; 
	}
	
	//functional methods
	public void share(String message, Set<String> networks) {
		toktiveService.share(message, networks);
	}
	
}
