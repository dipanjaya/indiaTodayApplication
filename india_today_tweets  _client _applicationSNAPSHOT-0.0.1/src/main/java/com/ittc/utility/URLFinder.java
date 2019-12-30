package com.ittc.utility;

import org.springframework.stereotype.Component;

@Component
public class URLFinder {

	public static int count = 0;

	public String extractURL(String literal) {

		String[] in = literal.split(" ");

		for (int i = 0; i < in.length; i++) {
			if (in[i].startsWith("https://")) {
				return in[i];
			} else {
				count++;
			}
		}

		return "https://twitter.com/home";
	}

}
