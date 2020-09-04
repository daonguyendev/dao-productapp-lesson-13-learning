package com.daonguyen.dao;

import com.daonguyen.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
	
	private List<Category> categories = null;
	
	public CategoryDao() {
		categories = new ArrayList<Category>();
		categories.add(new Category("mobile", "Mobile", "Smart Mobile"));
		categories.add(new Category("laptop", "Laptop", "Powerful Laptop"));
	}
	
	public List<Category> findAllOfCategories() {
		return categories;
	}
	
	public Category findCategoryByCode(String code) {
		for (Category category : categories) {
			if(category.getCode().equals(code)) {
				return category;
			}
		}
		return null;
	}

	public void add(Category category) {
		categories.add(category);
	}

	public void edit(Category category) {
		Category editingCategory = findCategoryByCode(category.getCode());
		if (editingCategory != null) {
			editingCategory.setName(category.getName());
			editingCategory.setDescription(category.getDescription());
		}
	}
	
	public void remove(String code) {
		for (int i = 0; i < categories.size(); i++) {
			if(categories.get(i).getCode().equals(code)) {
				categories.remove(i);
				break;
			}
		}
	}
}
