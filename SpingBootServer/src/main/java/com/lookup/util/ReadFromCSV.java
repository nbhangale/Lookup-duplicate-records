package com.lookup.util;

import java.io.FileReader;
import java.util.List;
import com.lookup.model.Employee;
import com.lookup.model.EmployeeList;
import com.opencsv.CSVReader;

/**
 * Added to read data from csv file from local path
 * @throws Exception 
 */

public class ReadFromCSV {
	
	/**
	 * Description : 
	 * @param file
	 * @return
	 */
	public static EmployeeList loadCSVData(String file)
    {
        EmployeeList employeeList = new EmployeeList();
        
        // try-catch reading csv file
        try 
        {
            @SuppressWarnings("resource")
			CSVReader employeeData = new CSVReader(new FileReader(file));
            // boolean variable to skip the header of csv file
            boolean readHeader = false;
            List<Employee> employees = employeeList.getEmployeeList();
            String[] nextLine;
            nextLine = employeeData.readNext();
            
            while(nextLine != null)
            {
            	if(!readHeader)
                {
                    // skipping the first row
                    readHeader = true;   
                }
            	else
            	{
            	//Read the employee data from the csv file and save it in the employee object
                Employee employee = new Employee(nextLine[1],nextLine[2],nextLine[3],nextLine[4],nextLine[5],nextLine[6],
                		nextLine[7],nextLine[8],nextLine[9],nextLine[10],nextLine[11]);
                // append to employee
                employees.add(employee);   
            	}

                nextLine = employeeData.readNext();
            }
         } 
         catch (Exception ex) 
         {
            System.out.println("Exception while loading Employee Data");
         }
        
        return employeeList;        
    }

}
