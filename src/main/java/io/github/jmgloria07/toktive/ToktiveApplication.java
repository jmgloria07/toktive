package io.github.jmgloria07.toktive;

import java.util.Arrays;
import java.util.HashSet;

public class ToktiveApplication {

	public static void main(String[] args) {
		Toktive toktive = Toktive.getInstance();
		toktive
			.share("\"Mr. Watson come over here.\"", 
					new HashSet<>(Arrays.asList("TW")));
		toktive.close();
	}

}
