package io.github.jmgloria07.toktive;

import java.util.Arrays;
import java.util.HashSet;

public class ToktiveApplication {

	public static void main(String[] args) {
		Toktive.getInstance()
			.share("\"Mr. Watson come over here.\"", 
					new HashSet<>(Arrays.asList("TW", "FB")));
		Toktive.close();
	}

}
