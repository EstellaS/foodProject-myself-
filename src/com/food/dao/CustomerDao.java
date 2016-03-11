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


@Service @Transactional
public class CustomerDao {
	@Resource SessionFactory factory;
	
	/*增*/
	public void addCustomer(Customer customer) throws Exception{
		Session s = factory.getCurrentSession();
		s.save(customer);
	}
	
	/*删*/
	public void deleteCustomer(Integer customerid)throws Exception{
//	public void deleteFood(Food food)throws Exception{	
	    Session s = factory.getCurrentSession();
		Object customer = s.load(Customer.class, customerid);
		s.delete(customer);
	}
	
	/*改*/
	public void updateCustomer(Customer customer)throws Exception{
		Session s = factory.getCurrentSession();
		s.update(customer);
	}
	
	/*查所有的food*/
	public ArrayList<Customer> QueryAllCustomerInfo() {
        Session s = factory.getCurrentSession();
        String hql = "From Customer";   
        Query q = s.createQuery(hql);
        List customerList = q.list();
        return (ArrayList<Customer>) customerList;
    }
	
	/*根据主键查*/
	public Customer GetCustomerById(Integer customerid) {
        Session s = factory.getCurrentSession();
        Customer customer = (Customer)s.get(Customer.class, customerid);
        return customer;
    }
	
	/*根据查询条件查*/
	public ArrayList<Customer> QueryCustomerInfo(String name) { 
    	Session s = factory.getCurrentSession();
    	List customerList;
    	String hql = "From Customer customer where 1=1";
    	if(!name.equals("")){
    		hql = hql + " and customer.name like '%" + name + "%'";
    		Query q = s.createQuery(hql);
        	customerList = q.list();
    	}else{
    		customerList=null;
    	}
    	return (ArrayList<Customer>) customerList;
    }
	
	
	
	
}
