package com.onlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshopping.model.Category;
import com.onlineshopping.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
		
	}
	
	public Category addCategory(Category category) {
		categoryRepository.save(category);
		return category;
	}
	
	public void removeCategoryById(int id) {
		categoryRepository.deleteById(id);
	}
	
	public Optional<Category> getCategoryById(int id){
		return categoryRepository.findById(id);
	}

}
