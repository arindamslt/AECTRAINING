package com.arindam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arindam.model.Food;
import com.arindam.repository.FoodRepo;

@Service
public class FoodService {
	@Autowired
private FoodRepo frepo;
	public void addData(Food food)
	{
		frepo.save(food);
	}
	public List<Food> getData()
	{
		return frepo.findAll();
	}
	public void deleteData(Integer foodid)
	{
		Food food=frepo.findById(foodid).orElse(null);
		if(food!=null)
		{
			frepo.delete(food);
		}
	}
	public void updateData(Integer foodid,Food food)
	{
		Food foods=frepo.findById(foodid).orElse(null);
		if(foods!=null)
		{
			foods.setFoodnm(food.getFoodnm());
			foods.setPrice(food.getPrice());
			frepo.save(foods);
		}
	}
	public Food searchByFoodId(Integer foodid)
	{
		Food food=frepo.findById(foodid).orElse(null);
		return food;
	}
}
