package com.ability.emp.base;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	
	
    int insert(T t);  
   
    int delete(T t);  
    
    int update(T t);  
    
    Integer count(Map<String,Object> map);
   
    List<T> queryById(Long id);  
    
    List<T> queryAll();  
    
    

}
