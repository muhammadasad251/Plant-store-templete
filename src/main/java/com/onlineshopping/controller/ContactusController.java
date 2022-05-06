package com.onlineshopping.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ContactusController {

    @GetMapping({"/contactus"})
	public String contactus(Model model) {
		return "contactus";
	}
    
}
