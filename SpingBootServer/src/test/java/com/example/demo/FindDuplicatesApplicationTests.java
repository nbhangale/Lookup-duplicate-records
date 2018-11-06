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
	
	@Test
	public void lookup()
	{
		try {
			EmployeeList employeeList = new EmployeeList();
			Employee e1 = new Employee(null, null, null, null, null, null, null, null, null, null, null);
			Employee e2 = new Employee(null, null, null, null, null, null, null, null, null, null, null);

			employeeList.getEmployeeList().set(0, e1);
			employeeList.getEmployeeList().set(1, e2);

			Map<Integer, List<Employee>> result = distanceCalculator.findDifference(employeeList);
			
			Assert.assertEquals(result.containsKey(0), false);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
