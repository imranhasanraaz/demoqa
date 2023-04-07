package com.framework.utilities;

import java.util.Random;

public class RandomText {
	public String generateRandomText() {
		String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int length = 10;
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
		}

		return sb.toString();
	}

}