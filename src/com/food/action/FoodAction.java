package com.food.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.food.dao.FoodDao;
import com.food.model.Customer;
import com.food.model.Food;
import com.opensymphony.xwork2.ActionSupport;

@Controller	@Scope("prototype")
    public class FoodAction extends ActionSupport {
	  @Resource FoodDao foodDao;
	private Food food;
	
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	
	private List<Food> foodList;

	public List<Food> getFoodList() {
		return foodList;
	}
	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}
	
	public String addFood() throws Exception{
		foodDao.addFood(food);
		return "message";
	}
	
	public String showFood(){
		foodList = foodDao.QueryAllFoodInfo();
		return "show_view";
	}
	
	public String showDetail(){
		food = foodDao.GetFoodById(food.getFoodid());
		return "detail_view";
	}

	public String showEdit() throws Exception{
		food = foodDao.GetFoodById(food.getFoodid());
		return "edit_view";
	}
	
	public String editFood() throws Exception{
		foodDao.updateFood(food);
		return "edit_message";
	}
	
	public String deleteFood() throws Exception{
		foodDao.deleteFood(food.getFoodid());
		return "delete_message";
	}
	
	private String keyWords;
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	
	public String queryFoods() throws Exception{
		foodList = foodDao.QueryFoodInfo(keyWords);
		return "show_view";
	}
	
	private Customer customer;
	public Customer getCustomer(){
		return customer;
	}
	public void setCustomer(Customer customer){
		this.customer = customer;
	}
}
