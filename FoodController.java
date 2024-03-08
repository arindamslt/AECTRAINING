package com.arindam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arindam.model.Food;
import com.arindam.service.FoodService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/foodapp")
public class FoodController {
	@Autowired
private FoodService fservice;
	@PostMapping("/add")
	public ResponseEntity<String> addData(@RequestBody Food food)
	{
		String msg="FOOD ADDED SUCCESSFULLY";
		fservice.addData(food);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}
	@GetMapping("/fetch")
	public ResponseEntity<List<Food>> getData()
	{
		List<Food> flist=fservice.getData();
		return new ResponseEntity<List<Food>>(flist,HttpStatus.OK);
				
	}
	@DeleteMapping("/del/{foodid}")
	public ResponseEntity<String> deleteData(@PathVariable Integer foodid)
	{
		String msg="FOOD ITEM DELETED SUCCESSFULLY";
		fservice.deleteData(foodid);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	@PutMapping("/upd/{foodid}")
	public ResponseEntity<String> updateData(@PathVariable Integer foodid,@RequestBody Food food)
	{
		String msg="FOOD ITEM UPDATED SUCCESSFULLY";
		fservice.updateData(foodid, food);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	@GetMapping("/fetch/{foodid}")
	public ResponseEntity<Food> searchByFoodId(@PathVariable Integer foodid)
	{
		Food fd=fservice.searchByFoodId(foodid);
		return new ResponseEntity<Food>(fd,HttpStatus.OK);
	}
}
