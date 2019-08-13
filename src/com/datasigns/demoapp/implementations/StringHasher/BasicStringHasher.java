package com.datasigns.demoapp.implementations.StringHasher;

import org.springframework.stereotype.Component;

import com.datasigns.demoapp.interfaces.StringHasher;

@Component
public class BasicStringHasher implements StringHasher {

	@Override
	public String getHash(String stringToHash) {
		int hash = stringToHash.hashCode();
		return Integer.toString(hash,36);
	}

}
