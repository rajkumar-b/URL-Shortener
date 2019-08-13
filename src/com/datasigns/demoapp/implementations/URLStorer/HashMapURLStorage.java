package com.datasigns.demoapp.implementations.URLStorer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.datasigns.demoapp.interfaces.URLStorer;

@Component
public class HashMapURLStorage implements URLStorer {

private Map<String, String> urlStorage;
	
	public HashMapURLStorage() {
		urlStorage = new HashMap<>();
	}

	@Override
	public void storeTinyUrlMapping(String originalURL, String tinyURL) {
		urlStorage.put(tinyURL, originalURL);
	}

	@Override
	public String retrieveOriginalUrlFromMapping(String tinyURL) {
		return urlStorage.get(tinyURL);
	}

}
