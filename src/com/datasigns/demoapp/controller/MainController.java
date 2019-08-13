package com.datasigns.demoapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String getIndex(Model model) {
		model.addAttribute("shortenedUrl", "");
		model.addAttribute("expandedUrl", "");
		return "index";
	}
	
	@RequestMapping("/shortenURL")
	public String shortenURL(HttpServletRequest request, Model model) {
		String shortenedUrl = "dummyValue";
		model.addAttribute("shortenedUrl", shortenedUrl);
		model.addAttribute("expandedUrl", "");
		return "index";
	}
	
	@RequestMapping("/expandURL")
	public String expandURL(HttpServletRequest request, Model model) {
		String expandedUrl = "dummyValue";
		model.addAttribute("shortenedUrl", "");
		model.addAttribute("expandedUrl", expandedUrl);
		return "index";
	}
}
