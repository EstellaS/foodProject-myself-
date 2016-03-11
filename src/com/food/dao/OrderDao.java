package com.food.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.model.Customer;
import com.food.model.Food;
import com.food.model.Order;


@Service @Transactional
public class OrderDao {
	@Resource SessionFactory factory;
	
	/*增*/
	public void addOrder(Order order) throws Exception{
		Session s = factory.getCurrentSession();
		s.save(order);
	}
	
	/*删*/
	public void deleteOrder(Integer orderid)throws Exception{
	    Session s = factory.getCurrentSession();
		Object order = s.load(Order.class, orderid);
		s.delete(order);
	}
	
	/*改*/
	public void updateOrder(Order order)throws Exception{
		Session s = factory.getCurrentSession();
		s.update(order);
	}
	
	/*查所有的order*/
	public ArrayList<Order> QueryAllOrderInfo() {
		Session s = factory.getCurrentSession();
		String hql = "From Order";   
        Query q = s.createQuery(hql);
        List orderList = q.list();
        return (ArrayList<Order>) orderList;
    }
	
	/*根据主键查*/
	public Order GetOrderById(Integer orderid) {
        Session s = factory.getCurrentSession();
        Order order = (Order)s.get(Order.class, orderid);
        return order;
    }
	
	/*根据查询条件查*/
	public ArrayList<Order> QueryOrderInfo(Customer customer,Food food) { 
    	Session s = factory.getCurrentSession();
    	String hql = "From Order order where 1=1";
    	if(null!=customer && customer.getCustomerid()!=0) 
    		hql = hql + " and order.customer.customerid like '%" + customer.getCustomerid() + "%'";
    	if(null!=food && null!=food.getFoodname()) 
    		hql = hql + " and order.food.foodname like '%" + food.getFoodname() + "%'";
    	Query q = s.createQuery(hql);
    	List orderList = q.list();
    	return (ArrayList<Order>) orderList;
    }
	
	
	
	
}
