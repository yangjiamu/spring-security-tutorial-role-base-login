package com.study.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import com.study.springboot.domain.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/admins")
public class AdminController {

	@GetMapping
	public ModelAndView list(Model model) {

		List<User> list = new ArrayList<>();	// 当前所在页面数据列表
		list.add(new User(1L,"waylau", 30));
		list.add(new User(2L,"老卫", 29));
		model.addAttribute("title", "管理员管理");
		model.addAttribute("userList", list);
		return new ModelAndView("users/list", "userModel", model);
	}
 

}
