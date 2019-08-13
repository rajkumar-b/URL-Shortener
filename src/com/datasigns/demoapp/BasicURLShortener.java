package com.datasigns.demoapp;


public class BasicURLShortener implements URLShortener {

	private URLStorer urlStorage;

	public BasicURLShortener() {
		this.urlStorage = new HashMapURLStorage();
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
		urlStorage.storeTinyUrlMapping(realUrl, tinyUrl);
		return tinyUrl;
	}

	private String returnMyUrl(String tinyUrl) {
		String op = urlStorage.retrieveOriginalUrlFromMapping(tinyUrl);
		return op==null? "URL not in List": op;
	}
	
	public String getHash(String stringToHash) {
		int hash = stringToHash.hashCode();
		return Integer.toString(hash,36);
	}

}
