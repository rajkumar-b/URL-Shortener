package com.datasigns.demoapp;

public class BasicStringHasher implements StringHasher {

	@Override
	public String getHash(String stringToHash) {
		int hash = stringToHash.hashCode();
		return Integer.toString(hash,36);
	}

}
