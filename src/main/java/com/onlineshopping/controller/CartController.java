package com.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlineshopping.global.GlobalData;
import com.onlineshopping.model.Product;
import com.onlineshopping.service.ProductService;

@Controller
public class CartController {
	
	@Autowired
	ProductService productService;
	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable int id) {
		GlobalData.cart.add(productService.getProductById(id).get());
		return "redirect:/shop";
	}
	
	@GetMapping("/cart")
		public String cartGet(Model model) {
			model.addAttribute("cartCount", GlobalData.cart.size());
			List<Product> cart = GlobalData.cart;
			Double sum = 0.00;

			if (cart.size() == 0) {
				sum = 0.00;
			} else {
				for (int i=0; i<cart.size(); i++) {
					sum = sum + cart.get(i).getPrice();
				}
			}
			 
			System.out.println(GlobalData.cart.get(0));
			model.addAttribute("total", sum);
			model.addAttribute("cart",GlobalData.cart);
			return "cart";
			
		}
	}


