package com.datasigns.demoapp;

import java.util.HashMap;
import java.util.Map;

public class BasicURLShortener implements URLShortener {

	private Map<String, String> urlStorage;

	public BasicURLShortener() {
		urlStorage = new HashMap<>();
	}

	@Override
	public String getShortenedURL(String s) {
		return shortenMyUrl(s);
	}

	@Override
	public String getActualURL(String s) {
		return returnMyUrl(s);
	}

	private String shortenMyUrl(String realUrl) {
		String tinyUrl = getHash(realUrl);
		urlStorage.put(tinyUrl, realUrl);
		return tinyUrl;
	}

	private String returnMyUrl(String tinyUrl) {
		String op = urlStorage.get(tinyUrl);
		return op==null? "URL not in List": op;
	}
	
	public String getHash(String stringToHash) {
		int hash = stringToHash.hashCode();
		return Integer.toString(hash,36);
	}

}
