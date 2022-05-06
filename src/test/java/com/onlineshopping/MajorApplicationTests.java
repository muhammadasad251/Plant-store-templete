package com.onlineshopping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.onlineshopping.model.Category;
import com.onlineshopping.repository.CategoryRepository;
import com.onlineshopping.service.CategoryService;

@SpringBootTest
class MajorApplicationTests {

	@Autowired
	private CategoryService categoryService;
	
	@MockBean
	private CategoryRepository categoryRepository;
	
	@Test
	public void createCategoryTest() {
		Category category = new Category("New Category");
		Category categor2 = new Category("New");
		when(categoryRepository.save(category)).thenReturn(category);
		assertNotEquals(category, categoryService.addCategory(categor2));
	}
}
