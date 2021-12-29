package com.TrueMeds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TrueMeds.model.InputDetails;
import com.TrueMeds.model.OutputDetails;
import com.TrueMeds.repo.inputDetailsRepository;
import com.TrueMeds.service.OutputDetailsService;

@RestController
@RequestMapping("/truemedsString")
public class InputOutputController {

	@Autowired
	OutputDetailsService outputService;
	
	@Autowired
	inputDetailsRepository inputRepo;
	
	/**
	 * 
	 * Saving the data into firstname_lastname_java_output table
	 * 
	 * @see outputDetailSave
	 * @return String
	 * @author Shivam
	 */
	@PostMapping("/saveOutputDetails")
	public String outputDetailSave()
	{
		
		outputService.adjacentRemoval();
		return "After removal of duplicate data, it got saved into the firstname_lastname_java_output table successfully";
	}
	
	/**
	 * 
	 * Method to add all records into input_details table
	 * 
	 * @see inputStrings
	 * @return List of InputDetails model class
	 * @param request body for InputDetails model class
	 * @author Shivam
	 */
	@PostMapping("/addInputDetails")
	public List<InputDetails> addStrings(@RequestBody List<InputDetails> inputDetails)
	{
		System.out.println("Any kind of Strings got saved into the InputDetails table");
		return outputService.saveInputDetails(inputDetails);
	}
	
	/**
	 * 
	 * Method to find all records from the firstname_lastname_java_output table
	 * 
	 * @see getOutputDetails
	 * @return List of outputDetails model class
	 * @author Shivam
	 */
	@GetMapping("/getOutputDetails")
	public List<OutputDetails> getOutputDetails()
	{
		System.out.println("Fetching the details from firstname_lastname_java_output table");
		return outputService.getOutputTableDetails();
	}
	
	/**
	 * 
	 * Method to find all records from the input_details table
	 * 
	 * @see getInputDetails
	 * @return List of InputDetails model class
	 * @author Shivam
	 */
	@GetMapping("/getInputDetails")
	public List<InputDetails> getInputDetails()
	{
		System.out.println("Fetching the details from input_details table");
		return outputService.getInputTableDetails();
	}
}
