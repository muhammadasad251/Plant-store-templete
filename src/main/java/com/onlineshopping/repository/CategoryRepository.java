package com.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineshopping.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
