package com.study.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import com.study.springboot.domain.User;
import com.study.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ModelAndView list(Model model) {

		List<User> list = new ArrayList<>();	// 当前所在页面数据列表
		list = userService.listUsers();
		model.addAttribute("title", "用户管理");
		model.addAttribute("userList", list);
		return new ModelAndView("users/list", "userModel", model);
	}
 
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")  // 指定角色权限才能操作方法
	@GetMapping(value = "delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, Model model) {
		userService.removeUser(id);
		model.addAttribute("userList", userService.listUsers());
		model.addAttribute("title", "删除用户");
		return new ModelAndView("users/list", "userModel", model);
	}

}
