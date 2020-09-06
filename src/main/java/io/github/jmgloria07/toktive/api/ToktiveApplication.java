package io.github.jmgloria07.toktive.api;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import io.github.jmgloria07.toktive.api.objects.ToktiveResponse;

public class ToktiveApplication {

	public static void main(String[] args) {
		Toktive toktive = Toktive.getInstance();
		List<ToktiveResponse> response = toktive
				.share("Last test before I eat.", 
						new HashSet<>(Arrays.asList("TW")));
		System.out.println(response);
		toktive.close();
	}

}
