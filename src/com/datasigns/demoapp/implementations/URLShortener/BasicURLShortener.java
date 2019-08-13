package com.datasigns.demoapp.implementations.URLShortener;

import org.springframework.stereotype.Component;

import com.datasigns.demoapp.implementations.StringHasher.BasicStringHasher;
import com.datasigns.demoapp.implementations.URLStorer.HashMapURLStorage;
import com.datasigns.demoapp.interfaces.StringHasher;
import com.datasigns.demoapp.interfaces.URLShortener;
import com.datasigns.demoapp.interfaces.URLStorer;

// Disadvantage: Same hash for same url. Possibility for duplicate hash.
@Component
public class BasicURLShortener implements URLShortener {

	private URLStorer urlStorage;
	private StringHasher stringHasher;

	public BasicURLShortener() {
		this.urlStorage = new HashMapURLStorage();
		this.stringHasher = new BasicStringHasher();
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
		String tinyUrl = stringHasher.getHash(realUrl);
		urlStorage.storeTinyUrlMapping(realUrl, tinyUrl);
		return tinyUrl;
	}

	private String returnMyUrl(String tinyUrl) {
		String op = urlStorage.retrieveOriginalUrlFromMapping(tinyUrl);
		return op==null? "URL not in List": op;
	}

}
