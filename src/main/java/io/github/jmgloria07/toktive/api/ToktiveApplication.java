package io.github.jmgloria07.toktive.api;

import java.util.Arrays;
import java.util.HashSet;

public class ToktiveApplication {

	public static void main(String[] args) {
		Toktive toktive = Toktive.getInstance();
		toktive
			.share("Test Message~", 
					new HashSet<>(Arrays.asList("TW")));
		toktive.close();
	}

}
