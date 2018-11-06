package com.lookup.service;

import java.util.HashSet;

import org.springframework.web.multipart.MultipartFile;

import com.lookup.model.Employee;
import com.lookup.model.EmployeeList;

/**
 * Look up service class
 * Functions: class to get the duplicate entries
 */

public class DistanceCalculator {
	
	public static void findDifference(EmployeeList employeeList) throws Exception
	{
		HashSet<String> set = new HashSet<String>();
		 
	    for (Employee employee : employeeList.getEmployeeList())
	    {
	    	if(!set.add(employee.getEmail()))
	    	{
	    		System.out.println("Duplicate email is : "+employee.getEmail());
	    	}
	    }  
	}

}
