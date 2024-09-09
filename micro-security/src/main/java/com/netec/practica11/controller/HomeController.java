package com.netec.practica11.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/")
	public String inicio(Authentication auth, Model model) {

		String username = auth.getName();
		model.addAttribute("username", username);
		LOGGER.debug("Model: {}", model);
		return "inicio";
	}
}
