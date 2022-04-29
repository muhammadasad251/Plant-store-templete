
package com.onlineshopping.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.onlineshopping.model.Role;
import com.onlineshopping.model.User;
import com.onlineshopping.repository.RoleRepository;
import com.onlineshopping.repository.UserRepository;


@Controller
public class LoginController {


	//private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String registerGet() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerPost(@ModelAttribute("user") User user) {
		String password = user.getPassword();
		user.setPassword(password);
		Set<Role> roles = new HashSet<>();
		Role role = roleRepository.findById(1).get();
		System.out.println(role.getName());
		roles.add(role);
		user.setRole(roles) ;
		User newUser = new User(user.getFirstName(), user.getLastName(), user.getEmail(), password);
		newUser.setRole(roles);
		userRepository.save(newUser);
		//request.login(user.getEmail(), password);
		return "redirect:/";
		
	}


}
