package com.lookup.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lookup.model.NonDuplicateStatus;
import com.lookup.constants.CommonConstants;
import com.lookup.model.Employee;
import com.lookup.model.EmployeeList;
import com.lookup.model.Status;
import com.lookup.service.DistanceCalculator;
import com.lookup.service.LocalClient;
import com.lookup.util.ReadFromCSV;
import com.lookup.util.Utils;


/**
 *  Rest controller to upload the csv and get the data 
 */

@RestController
public class LookupController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LocalClient localClient;
	
	/**
	 * Added to load a csv & get duplicate and non-duplicate employee data
	 * @param file
	 * @return
	 */
	
	@RequestMapping(value = "/lookup", method = RequestMethod.POST)
	public Status loadCSV(@RequestPart(value = "file") MultipartFile file) 
	{
		log.info("loadCSV - Start");
		Status status = new Status();
		try 
		{
			if (Utils.isValidExt(file)) 
			{				
				// stored csv to local
				String uri = localClient.uploadFile(file);
				
				//Read employee data from the csv file, saved at local path
				EmployeeList employeeList = employeeCSVdata(".//normal.csv");
		 		        
		        //find duplicates in employee list
		        HashMap<Integer, List<Employee>> separetedEmployeeList = DistanceCalculator.findDifference(employeeList);

			    // set the status to success
				status.setMessage(uri);
				status.setStatusCode("Success");
				status.setEmployeeList(separetedEmployeeList);
				
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
			status.setStatusCode("Exception");
			status.setMessage(e.getMessage());
			log.error(e.getMessage());
		}

		log.info("loadCSV - End");
		return status;
	}
	
	/**
	 * Description: Get duplicate eployee data
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/nonduplicate", method = RequestMethod.POST)
	public NonDuplicateStatus getNonDuplicates(@RequestPart(value = "file") MultipartFile file) 
	{
		log.info("getNonDuplicates - Start");
		NonDuplicateStatus nonDuplicateStatus = new NonDuplicateStatus();
		try 
		{
			if (Utils.isValidExt(file)) 
			{				
				// stored csv to local
				String uri = localClient.uploadFile(file);
				
				//Read employee data from the csv file, saved at local path
				EmployeeList employeeList = employeeCSVdata(CommonConstants.FILE_PATH);
				
				  //find duplicates in employee list
		        HashMap<Integer, List<Employee>> separetedEmployeeList = DistanceCalculator.findDifference(employeeList);
		        
			    // set the status to success
		        nonDuplicateStatus.setMessage(uri);
		        nonDuplicateStatus.setStatusCode(CommonConstants.StatusCodes.SUCCESS);
		        System.out.println(separetedEmployeeList.get(0));
		        nonDuplicateStatus.setEmployeeList(separetedEmployeeList.get(0));
				
			} 
			else 
			{
				// set the status to invalid attachment
				nonDuplicateStatus.setStatusCode(CommonConstants.StatusCodes.INVALID);
				nonDuplicateStatus.setMessage(CommonConstants.INVALID_ATTACHMENT);;
			}
		}
		catch (Exception e) 
		{
			// set the status to invalid attachment with message
			nonDuplicateStatus.setStatusCode(CommonConstants.StatusCodes.EXCEPTION);
			nonDuplicateStatus.setMessage(e.getMessage());
			log.error(e.getMessage());
		}

		log.info("getDuplicates - End");
		return nonDuplicateStatus;
	}
	
	public EmployeeList employeeCSVdata(String file_path)
	{
		// Read from CSV method
	    EmployeeList employeeList = ReadFromCSV.loadCSVData(file_path);
	    return employeeList;
	
	}

}
