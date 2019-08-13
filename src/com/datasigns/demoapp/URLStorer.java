package com.datasigns.demoapp;

public interface URLStorer {
	public void storeTinyUrlMapping(String originalURL, String tinyURL);
	public String retrieveOriginalUrlFromMapping(String tinyURL);
}
