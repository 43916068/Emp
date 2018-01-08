package com.example.springbootdemo.base;

import java.util.List;

public interface BaseDao<T> {
	
	
    int insert(T t);  
   
    int delete(T t);  
    
    int update(T t);  
   
    List<T> queryById(Long id);  
    
    List<T> queryAll();  

}
