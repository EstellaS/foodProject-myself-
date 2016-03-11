package com.food.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.model.Food;


@Service @Transactional
public class FoodDao {
	@Resource SessionFactory factory;
	
	/*增*/
	public void addFood(Food food) throws Exception{
		Session s = factory.getCurrentSession();
		s.save(food);
	}
	
	/*删*/
	public void deleteFood(Integer foodid)throws Exception{
//	public void deleteFood(Food food)throws Exception{	
	    Session s = factory.getCurrentSession();
		Object food = s.load(Food.class, foodid);
		s.delete(food);
	}
	
	/*改*/
	public void updateFood(Food food)throws Exception{
		Session s = factory.getCurrentSession();
		s.update(food);
	}
	
	/*查所有的food*/
	public ArrayList<Food> QueryAllFoodInfo() {
        Session s = factory.getCurrentSession();
        String hql = "From Food";   
        Query q = s.createQuery(hql);
        List foodList = q.list();
        return (ArrayList<Food>) foodList;
    }
	
	/*根据主键查*/
	public Food GetFoodById(Integer foodid) {
        Session s = factory.getCurrentSession();
        Food food = (Food)s.get(Food.class, foodid);
        return food;
    }
	
	/*根据查询条件查*/
	public ArrayList<Food> QueryFoodInfo(String foodname) { 
    	Session s = factory.getCurrentSession();
    	String hql = "From Food food where 1=1";
    	if(!foodname.equals("")) hql = hql + " and food.foodname like '%" + foodname + "%'";
    	Query q = s.createQuery(hql);
    	List foodList = q.list();
    	return (ArrayList<Food>) foodList;
    }
	
	
	
	
}
