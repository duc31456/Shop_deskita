package com.deskita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.deskita.common.entity.Category;
import com.deskita.repository.CategoryRepository;

@Service
public class CategoryService {
public static int PAGE_SIZE=10;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> listAll(){
		return (List<Category>) categoryRepository.findAll();
	}
	
	public List<Category> pagingCategory(int currentPage){
		
		Pageable pageable=PageRequest.of(currentPage-1, PAGE_SIZE);
		Page<Category> page=categoryRepository.findAll(pageable);
		List<Category> listCategories=page.getContent();
		return listCategories;	
	}
	
	public Category getCategoryById(int id) {
		return categoryRepository.findById(id).get();
	}
	
	public void saveCategory(Category category) {
		categoryRepository.save(category);
	}
	
	
}
