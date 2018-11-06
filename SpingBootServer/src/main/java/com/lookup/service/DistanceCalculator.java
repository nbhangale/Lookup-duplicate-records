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

	
	/**
	 * Description : Calculate the differences between two records 
	 * @param employeeList
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static HashMap<Integer, List<Employee>> findDifference(EmployeeList employeeList) throws Exception
	{
		
		List<Employee> empList 							 = employeeList.getEmployeeList();
		List<Employee> duplicateEmpList 				 = new ArrayList<Employee>();
		List<Employee> nonDuplicateEmpList 				 = new ArrayList<Employee>();
		Integer counterKey 					    		 = 0;
		Iterator<Employee> empIterator 		         	 = empList.iterator();
		List<Employee> tempDuplicateList 				 = new ArrayList<Employee>(); 
		HashMap<Integer, List<Employee>> duplicateEmpMap = new HashMap<Integer, List<Employee>>();
		
		while(empIterator.hasNext())
		{
			Employee emp 				= empIterator.next();
			Integer emailDistance     	= 0;
			Integer firstNameDistance 	= 0;
			Integer lastNameDistance 	= 0;
			Integer companyDistance 	= 0;
			Integer address1Distance 	= 0;
			Integer address2Distance 	= 0;
			Integer zipDistance 		= 0;
			Integer cityDistance 		= 0;
			Integer stateLongDistance 	= 0;
			Integer stateDistance 		= 0;
			Integer phoneDistance 		= 0;			
			int index 					= empList.indexOf(emp); 
			Iterator<Employee> empIterator2 = empList.subList(index+1, empList.size()).iterator();
			
		    while (empIterator2.hasNext())
		    {
		    	emailDistance     	= 0;
				firstNameDistance 	= 0;
				lastNameDistance 	= 0;
				companyDistance 	= 0;
				address1Distance 	= 0;
				address2Distance 	= 0;
				zipDistance 		= 0;
				cityDistance 		= 0;
				stateLongDistance 	= 0;
				stateDistance 		= 0;
				phoneDistance 		= 0;
				
				Employee emp2 = empIterator2.next();
		    	
				try
				{
	    		emailDistance 		= StringUtils.getLevenshteinDistance(emp.getEmail(), emp2.getEmail(), 2);
	    		firstNameDistance 	= StringUtils.getLevenshteinDistance(emp.getFirstName(), emp2.getFirstName(), 5);
	    		lastNameDistance 	= StringUtils.getLevenshteinDistance(emp.getLastName(), emp2.getLastName(), 5);
	    		companyDistance		= StringUtils.getLevenshteinDistance(emp.getCompany(), emp2.getCompany(), 5);
	    		address1Distance 	= StringUtils.getLevenshteinDistance(emp.getAddress1(), emp2.getAddress1(), 10);
	    		address2Distance  	= StringUtils.getLevenshteinDistance(emp.getAddress2(), emp2.getAddress2(), 7);
	    		zipDistance 		= StringUtils.getLevenshteinDistance(emp.getZip(), emp2.getZip(), 5);
	    		cityDistance 		= StringUtils.getLevenshteinDistance(emp.getCity(), emp2.getCity(), 10);
	    		stateLongDistance 	= StringUtils.getLevenshteinDistance(emp.getState_long(), emp2.getState_long(), 10);
	    		stateDistance 		= StringUtils.getLevenshteinDistance(emp.getState(), emp2.getState(), 2);
	    		phoneDistance 		= StringUtils.getLevenshteinDistance(emp.getPhone(), emp2.getPhone(), 5);
				}
				catch(Exception e) 
				{
					System.out.println("employee data can not be null");
				}
	    		
	    		if(emailDistance != -1 &&
	    				firstNameDistance != -1 &&
	    				lastNameDistance  != -1 &&
	    				companyDistance   != -1 &&
	    				address1Distance  != -1 &&
	    				address2Distance  != -1 &&
						zipDistance       != -1 &&
						cityDistance      != -1 &&
						stateLongDistance != -1 &&
						stateDistance     != -1 &&
						phoneDistance     != -1)
	    		{
	    			duplicateEmpList.add(emp);
	    			duplicateEmpList.add(emp2);
	    			tempDuplicateList.add(emp2);
	    		}
		    }
		    
		    if(!(duplicateEmpList.isEmpty()))
		    {		    	
		    	duplicateEmpMap.put(++counterKey, new ArrayList<Employee>(duplicateEmpList));
		    	duplicateEmpList.clear();
		    } 
		    else
		    {
		    	//Check if this record was not marked as deleted
		    	if(!tempDuplicateList.contains(emp))
		    		nonDuplicateEmpList.add(emp);
		    }
		    
		    empIterator.remove();
		}
		duplicateEmpMap.put(0, new ArrayList<Employee>(nonDuplicateEmpList));
		
		return duplicateEmpMap;
		  
	}

}
