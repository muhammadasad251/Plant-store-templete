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
			model.addAttribute("total", sum);
			model.addAttribute("cart", GlobalData.cart);
			return "cart";
		} else {
			for (int i = 0; i < cart.size(); i++) {
				sum = sum + cart.get(i).getPrice();
			}
		}
		
		if (sum > 60) {
			sum = sum - (sum * 30 / 100);
			model.addAttribute("discount", "20% discount is applied");
		}


		model.addAttribute("total", sum);
		model.addAttribute("cart", GlobalData.cart);
		return "cart";

	}

	@GetMapping("/cart/removeItem/{index}")
	public String cartItemRemove(@PathVariable int index) {
		GlobalData.cart.remove(index);
		return "redirect:/cart";

	}

	@GetMapping("/checkout")
	public String checkout(Model model) {
		List<Product> cart = GlobalData.cart;
		Double sum = 0.00;
		
		if (cart.size() > 0) {
			for (int i = 0; i < cart.size(); i++) {
				sum = sum + cart.get(i).getPrice();
			}
		}
		
		if (sum > 50) {
			sum = sum - (sum * 20 / 100);
			model.addAttribute("discount", "20% discount is applied");
		}
		
		model.addAttribute("total", sum);
		model.addAttribute("cart", GlobalData.cart);
		return "checkout";
	}

}


