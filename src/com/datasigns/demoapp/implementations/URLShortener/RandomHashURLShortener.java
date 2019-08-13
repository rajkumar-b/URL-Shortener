package com.datasigns.demoapp.implementations.URLShortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datasigns.demoapp.implementations.StringHasher.RandomStringHasher;
import com.datasigns.demoapp.interfaces.URLShortener;
import com.datasigns.demoapp.interfaces.URLStorer;

//Disadvantage: Overload for creating hash, as it checks storage for duplicate.
// Too many requests of random hash returning duplicate hash can cause timeout.
// Hence, limitation is set to check only for 100 different entries.
// If still duplicate is on hand, replace current value.

@Component
public class RandomHashURLShortener implements URLShortener {

	@Autowired
	private URLStorer urlStorage;
	@Autowired
	private RandomStringHasher stringHasher;
	int TINY_URL_LENGTH = 6, NO_OF_RETRIES = 100;

	@Override
	public String getShortenedURL(String s) {
		return shortenMyUrl(s);
	}

	@Override
	public String getActualURL(String s) {
		return returnMyUrl(s);
	}

	private String shortenMyUrl(String realUrl) {
		String hash = stringHasher.getHash();
		String tinyUrl = urlStorage.retrieveOriginalUrlFromMapping(hash);
		
		int i=0;
		while( (i<NO_OF_RETRIES) && (tinyUrl != null)) {
			hash = stringHasher.getHash();
			tinyUrl = urlStorage.retrieveOriginalUrlFromMapping(hash);
			i++;
		}
		tinyUrl = hash;
		urlStorage.storeTinyUrlMapping(realUrl, tinyUrl);
		return tinyUrl;
	}

	private String returnMyUrl(String tinyUrl) {
		String op = urlStorage.retrieveOriginalUrlFromMapping(tinyUrl);
		return op==null? "URL not in List": op;
	}


}
