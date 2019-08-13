package com.datasigns.demoapp.implementations.StringHasher;

import org.springframework.stereotype.Component;

import com.datasigns.demoapp.interfaces.StringHasher;

@Component
public class RandomStringHasher implements StringHasher {

	private int noOfCharacters;
	private char[] charSet = (
			"ABCDEFGHIJKLMNOPQRSTUVWXYZ" + 
			"abcdefghijklmnopqrstuvwxyz" +
			"0123456789"
			).toCharArray();
	private int base = charSet.length;
	
	
	public RandomStringHasher() {
		this.noOfCharacters = 6;
	}
	
	public RandomStringHasher(int noOfCharacters) {
		this.noOfCharacters = noOfCharacters;
	}

	@Override
	public String getHash(String stringToHash) {
		return getRandomHash();
	}

	public String getHash() {
		return getRandomHash();
	}

	private String getRandomHash() {
		StringBuilder hashValue = new StringBuilder();
		for(int i=0; i<noOfCharacters; i++) {
			int index = (int) (Math.random()*base);
			hashValue.append(charSet[index]);
		}
		return hashValue.toString();
	}
}
