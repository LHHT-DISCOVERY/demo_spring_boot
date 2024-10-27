package com.example.demomybatics.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demomybatics.mapper.studentMapper;
import com.example.demomybatics.model.student;
import com.example.demomybatics.model.studentExample;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Controller
@RequestMapping
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomePageControlelr {
	@Autowired
	studentMapper studentMapper;

	@GetMapping("/{nameValue}/{ageValue}")
	public ModelAndView index(@PathVariable String nameValue, @PathVariable String ageValue) {
		ModelAndView andView = new ModelAndView("index");
		studentExample example = new studentExample();
//		example.createCriteria().andAgeEqualTo(22);
		List<student> list = studentMapper.getAllStudentByName(nameValue);
		System.out.println(list.size());

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", nameValue); // cần phải giống với param trong studentMapper.xml
		param.put("age", ageValue);

		List<student> list1 = studentMapper.getAllStudentByNameAndAge(param);
		System.out.println(list1.size());

		List<Map<String, Object>> list2 = studentMapper.getAllStudentByNameIsMap(nameValue);
		for (Map<String, Object> check : list2) {
			System.out.println("Kiem tra " + check.get("name"));
		}
		return andView;
	}

	@GetMapping("/logincustom")
	public ModelAndView login() {
		ModelAndView andView = new ModelAndView("login/login");
		return andView;
	}

	@PostMapping("/logincustom")
	public ModelAndView doLogin() {
		ModelAndView andView = new ModelAndView("login/login");
		return andView;
	}

	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView andView = new ModelAndView("index");
		return andView;
	}

}
