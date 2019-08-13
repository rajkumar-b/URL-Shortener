package com.datasigns.demoapp.implementations.StringHasher;

import com.datasigns.demoapp.interfaces.StringHasher;

public class BasicStringHasher implements StringHasher {

	@Override
	public String getHash(String stringToHash) {
		int hash = stringToHash.hashCode();
		return Integer.toString(hash,36);
	}

}
