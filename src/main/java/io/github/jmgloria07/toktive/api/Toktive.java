package io.github.jmgloria07.toktive.api;

import java.io.Serializable;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.github.jmgloria07.toktive.api.business.ToktiveService;
import io.github.jmgloria07.toktive.api.config.ToktiveConfig;

public class Toktive implements AutoCloseable, Serializable {

	private static final long serialVersionUID = -4693339882081114184L;

	static AnnotationConfigApplicationContext appContext;
	
	volatile static Toktive toktive;
	
	static ToktiveService toktiveService;
	
	//restrict instantiation outside the class
	private Toktive() {
		//restrict use of reflections
		if (toktive != null) {
			throw new RuntimeException("Please use getInstance() to get the single instance of the class.");
		}
	}
	
	//singleton methods
	public static Toktive getInstance() {
		if (!isInstantiated()) {
			synchronized (Toktive.class) {
				appContext = new AnnotationConfigApplicationContext(ToktiveConfig.class);
				toktiveService = appContext.getBean(ToktiveService.class);
				toktive = new Toktive();
			}
		}
		return toktive;
	}

	@Override
	public void close() {
		if (isInstantiated()) {
			synchronized (Toktive.class) {
				appContext.close();
				appContext = null;
				toktive = null;
			}
		}
	}
	
	//make sure that getInstance is used when resolving from serialization
	protected Toktive readResolve() {
		return getInstance();
	}
	
	public static boolean isInstantiated() {
		return toktive != null || appContext != null; 
	}
	
	//functional methods
	public void share(String message, Set<String> networks) {
		toktiveService.share(message, networks);
	}
	
}
