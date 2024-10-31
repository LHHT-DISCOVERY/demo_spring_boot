package com.example.demomybatics.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Controller
@RequestMapping
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomePageControlelr {

	@GetMapping("/{nameValue}/{ageValue}")
	public ModelAndView index(@PathVariable String nameValue, @PathVariable String ageValue) {
		ModelAndView andView = new ModelAndView("index");

		return andView;
	}

	@GetMapping("/logincustom")
	public ModelAndView login() {
		ModelAndView andView = new ModelAndView("login/login");
		return andView;
	}



	@GetMapping("/public")
	public ModelAndView home() {
		ModelAndView andView = new ModelAndView("index");
		return andView;
	}

	@GetMapping("/user/list")
	public ModelAndView home1() {
		ModelAndView andView = new ModelAndView("index");
		return andView;
	}

	@GetMapping("/admin/list")
	public ModelAndView home3() {
		ModelAndView andView = new ModelAndView("index");
		return andView;
	}

}
