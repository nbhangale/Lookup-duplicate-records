package com.lookup.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to store the employee data
 * parameters: list of employee
 */

public class EmployeeList {

	// list of employee data
	List<Employee> employeeList;
    
    public EmployeeList()
    {
        employeeList = new ArrayList<Employee>();
    }
    
    // getters and setters
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

}
