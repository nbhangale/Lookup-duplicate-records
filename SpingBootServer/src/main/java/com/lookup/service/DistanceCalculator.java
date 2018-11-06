package com.lookup.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.lookup.model.Employee;
import com.lookup.model.EmployeeList;

/**
 * Look up service class
 * Functions: class to get the duplicate entries
 */

public class DistanceCalculator {
	
	@SuppressWarnings("deprecation")
	public static HashMap<Integer, List<Employee>> findDifference(EmployeeList employeeList) throws Exception
	{
		List<Employee> empList = employeeList.getEmployeeList();
		List<Employee> duplicateEmpList = new ArrayList<Employee>();
		List<Employee> nonDuplicateEmpList = new ArrayList<Employee>();
		HashMap<Integer, List<Employee>> duplicateEmpMap = new HashMap<Integer, List<Employee>>();
		Integer counterKey = 0;
		Iterator<Employee> empIterator = empList.iterator();
		
		while(empIterator.hasNext())
		{
			Employee emp = empIterator.next();
			Integer distance = 0;
			int index = empList.indexOf(emp); 
			Iterator<Employee> empIterator2 = empList.subList(index+1, empList.size()).iterator();
		    while (empIterator2.hasNext())
		    {
		    	Employee emp2 = empIterator2.next();
		    	
	    		distance = StringUtils.getLevenshteinDistance(emp.getEmail(), emp2.getEmail(), 2);
	    		
	    		if(distance != -1)
	    		{
	    			duplicateEmpList.add(emp);
	    			duplicateEmpList.add(emp2);
	    		}
		    }
		    
		    if(!(duplicateEmpList.isEmpty()))
		    {
		    	duplicateEmpMap.put(++counterKey, duplicateEmpList);
		    	//duplicateEmpList.clear();
		    }
		    
			
		    
		    //empList.remove(emp);
		}
		
		return duplicateEmpMap;
		  
	}

}
