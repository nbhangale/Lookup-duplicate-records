package com.example.demo;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lookup.model.Employee;
import com.lookup.model.EmployeeList;
import com.lookup.service.DistanceCalculator;

import junit.framework.Assert;

public class FindDuplicatesApplicationTests {

	@Mock
	DistanceCalculator distanceCalculator;
	
	@Before
	public void setup() {
		
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Description: Checks duplicate records with missing data in email id
	 */
	@Test
	public void lookupDuplicateEmail()
	{
		try {
			EmployeeList employeeList = new EmployeeList();
			Employee e1 = new Employee("Betsy", "Crehan", "Koch Group", "bcrehanh@skyrock.com", "09311 Dawn Place", " ", "49544", "Grand Rapids", "Michigan", "MI", "616-150-4905");
			Employee e2 = new Employee("Betsy", "Crehan", "Koch Group", "bcrhan@skyrock.com", "09311 Dawn Place", " ", "49544", "Grand Rapids", "Michigan", "MI", "616-150-4905");

			employeeList.getEmployeeList().add(e1);
			employeeList.getEmployeeList().add(e2);
			
			Map<Integer, List<Employee>> result = DistanceCalculator.findDifference(employeeList);

			// Checks if non-duplicate record has any entry or not and maps to true
			Assert.assertEquals(result.get(0).isEmpty(), true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Description: Checks non-duplicate records with missing data in email id
	 */
	@Test
	public void lookupNonDuplicateEmail()
	{
		try {
			EmployeeList employeeList = new EmployeeList();
			Employee e1 = new Employee("Betsy", "Crehan", "Koch Group", "bcrehanh@skyrock.com", "09311 Dawn Place", " ", "49544", "Grand Rapids", "Michigan", "MI", "616-150-4905");
			Employee e2 = new Employee("Betsy", "Crehan", "Koch Group", "brhah@.com", "09311 Dawn Place", " ", "49544", "Grand Rapids", "Michigan", "MI", "616-150-4905");

			
			employeeList.getEmployeeList().add(e1);
			employeeList.getEmployeeList().add(e2);

			Map<Integer, List<Employee>> result = DistanceCalculator.findDifference(employeeList);

			// Checks if non-duplicate record has any entry or not and maps to false
			Assert.assertEquals(result.get(0).isEmpty(), false);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Description: Checks duplicate records with missing data in address
	 */
	@Test
	public void lookupDuplicateAddress1()
	{
		try {
			EmployeeList employeeList = new EmployeeList();
			Employee e1 = new Employee("Betsy", "Crehan", "Koch Group", "bcrehanh@skyrock.com", "09311 Dawn Place", " ", "49544", "Grand Rapids", "Michigan", "MI", "616-150-4905");
			Employee e2 = new Employee("Betsy", "Crehan", "Koch Group", "bcrhan@skyrock.com", "09311 Place", " ", "49544", "Grand Rapids", "Michigan", "MI", "616-150-4905");

			employeeList.getEmployeeList().add(e1);
			employeeList.getEmployeeList().add(e2);
			
			Map<Integer, List<Employee>> result = DistanceCalculator.findDifference(employeeList);

			// Checks if non-duplicate record has any entry or not and maps to true
			Assert.assertEquals(result.get(0).isEmpty(), true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Description: Checks non-duplicate records with missing data in address
	 */
	@Test
	public void lookupNonDuplicateAddress1()
	{
		try {
			EmployeeList employeeList = new EmployeeList();
			Employee e1 = new Employee("Betsy", "Crehan", "Koch Group", "bcrehanh@skyrock.com", "09311 Dawn Place", " ", "49544", "Grand Rapids", "Michigan", "MI", "616-150-4905");
			Employee e2 = new Employee("Betsy", "Crehan", "Koch Group", "brhah@.com", "211 Darth Street", " ", "49544", "Grand Rapids", "Michigan", "MI", "616-150-4905");

			
			employeeList.getEmployeeList().add(e1);
			employeeList.getEmployeeList().add(e2);

			Map<Integer, List<Employee>> result = DistanceCalculator.findDifference(employeeList);

			// Checks if non-duplicate record has any entry or not and maps to false
			Assert.assertEquals(result.get(0).isEmpty(), false);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
