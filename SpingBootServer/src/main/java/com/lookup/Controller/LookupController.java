package com.lookup.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lookup.model.Employee;
import com.lookup.model.EmployeeList;
import com.lookup.model.Status;
import com.lookup.service.LocalClient;
import com.lookup.util.ReadFromCSV;
import com.lookup.util.Utils;


/**
 *  Rest controller to upload the csv and get the data 
 */

@RestController
public class LookupController {	
	
	@Autowired
	private LocalClient localClient;
	
	/**
	 * Added to load a csv 
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/lookup", method = RequestMethod.POST)
	public Status loadCSV(@RequestPart(value = "file") MultipartFile file) 
	{
		Status status = new Status();
		try 
		{
			if (Utils.isValidExt(file)) 
			{				
				// stored csv to local
				String uri = localClient.uploadFile(file);
				
				//Read employee data from the csv file, saved at local path
				String file_path = ".//normal.csv";
				// Read from CSV method
		        EmployeeList employeeList = ReadFromCSV.loadCSVData(file_path);
		        
		        for(Employee em: employeeList.getEmployeeList())
		        {
		        	System.out.println(em.getEmail());
		        }

			    // set the status to success
				status.setMessage(uri);
				status.setStatusCode("Success");
				
			} 
			else 
			{
				// set the status to invalid attachment
				status.setStatusCode("INVALID_ATTACHMENT");
				status.setMessage("INVALID_ATTACHMENT");;
			}

		} 
		catch (Exception e) 
		{
			// set the status to invalid attachment with message
			status.setStatusCode("INVALID_ATTACHMENT exception");
			status.setMessage("INVALID_ATTACHMENT" + e.getMessage());
		}

		return status;
	}

}
