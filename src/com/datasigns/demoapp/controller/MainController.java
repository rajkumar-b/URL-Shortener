package com.datasigns.demoapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.datasigns.demoapp.interfaces.URLShortener;

@Controller
public class MainController {
	
	@Autowired
	@Qualifier("randomHashURLShortener")
	URLShortener urlShortener;

	@RequestMapping("/")
	public String getIndex(Model model) {
		return "index";
	}
	
	@RequestMapping("/shortenURL")
	public String shortenURL(HttpServletRequest request, Model model) {
		String inputUrlReal = request.getParameter("inputUrlReal");
		String shortenedUrl = urlShortener.getShortenedURL(inputUrlReal);
		if(inputUrlReal.isEmpty()) {
			shortenedUrl = "Enter a Valid URL";
		}
		
		model.addAttribute("inputUrlReal", inputUrlReal);
		model.addAttribute("shortenedUrl", shortenedUrl);
		model.addAttribute("expandedUrl", "");
		return "index";
	}
	
	@RequestMapping("/expandURL")
	public String expandURL(HttpServletRequest request, Model model) {
		String inputUrlShort = request.getParameter("inputUrlShort");
		String expandedUrl = urlShortener.getActualURL(inputUrlShort);
		if(inputUrlShort.isEmpty()) {
			expandedUrl = "Enter a Valid URL";
		}

		model.addAttribute("inputUrlShort", inputUrlShort);
		model.addAttribute("shortenedUrl", "");
		model.addAttribute("expandedUrl", expandedUrl);
		return "index";
	}
}
