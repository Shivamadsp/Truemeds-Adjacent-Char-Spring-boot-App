package com.TrueMeds.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TrueMeds.model.InputDetails;
import com.TrueMeds.model.OutputDetails;
import com.TrueMeds.repo.OutputDetailsRepository;
import com.TrueMeds.repo.inputDetailsRepository;

@Service
public class OutputDetailsService {

	@Autowired
	private inputDetailsRepository inputRepo;

	@Autowired
	private OutputDetailsRepository outputRepo;


	/**
	 * 
	 * Method to return list of strings from inputDetails model class 
	 * which is fetching details from the input_details table
	 * 
	 * @see getAllString
	 * @return List of Strings
	 * @author Shivam
	 */
	public List<String> getAllStringInputTable(){
		List<InputDetails> inputStrings = new ArrayList<InputDetails>();
		inputStrings = inputRepo.findAll();

		List<String> listofStrings = new ArrayList<String>();

		for(InputDetails input:inputStrings) {
			listofStrings.add(input.getInputString());
		}

		return listofStrings;
	}

	/**
	 * 
	 * Method to remove adjacent duplicates from string
	 * 
	 * @see adjacentRemoval
	 * @author Shivam
	 */
	public void adjacentRemoval() 
	{

		List<OutputDetails> outputDetailsLists = new ArrayList<OutputDetails>();
		List<String> duplicateAdjacent = new ArrayList<String>();
		duplicateAdjacent = getAllStringInputTable();

		for(String listString: duplicateAdjacent) 
		{
			OutputDetails outputDetails = new OutputDetails();
			String removeSpaces = listString;
			removeSpaces = removeSpaces.replaceAll("\\s", "");
			String removedDuplicate = new String();
			Stack<Character> stack1 = new Stack<>();
			StringBuilder b1 = new StringBuilder();
			int count = 0;
			for(int i=0;i<removeSpaces.length()-1;)
			{
				if((removeSpaces.charAt(i)!='\0' || removeSpaces.charAt(i+1)!='\0') && (removeSpaces.charAt(i)==removeSpaces.charAt(i+1)))
				{
					while(removeSpaces.charAt(i)==removeSpaces.charAt(i+1))
					{
						if(i+1==removeSpaces.length()-1)
						{
							break;
						}
						i++;
					}
					count++;
				}else{
					removedDuplicate = removedDuplicate + removeSpaces.charAt(i);
				}
				i++;
			} 

			if(removeSpaces.charAt(removeSpaces.length()-1)!=removeSpaces.charAt(removeSpaces.length()-2))
			{
				removedDuplicate = removedDuplicate + removeSpaces.charAt(removeSpaces.length()-1);
			}

			for(int i=0;i<removedDuplicate.length();i++)
			{
				if(!stack1.isEmpty() && stack1.peek()==removedDuplicate.charAt(i))
				{
					stack1.pop();
					count++;
				}else{
					stack1.add(removedDuplicate.charAt(i));
				}
			}

			while(!stack1.isEmpty())
			{
				b1.append(stack1.pop());
			}

			Date date = new Date();
			long time = date.getTime();
			Timestamp ts = new Timestamp(time);

			outputDetails.setOutputString(b1.reverse().toString());
			outputDetails.setCountToFinalString(count);
			outputDetails.setDate("Shivam and timestamp is: " + ts.toString());

			outputDetailsLists.add(outputDetails);
		}

		outputRepo.saveAll(outputDetailsLists);
	}

	/**
	 * 
	 * Method to find all records from the firstname_lastname_java_output table
	 * 
	 * @see getOutputTableDetails
	 * @return List of OutputDetails pojo class
	 * @author Shivam
	 */
	public List<OutputDetails> getOutputTableDetails()
	{
		return outputRepo.findAll();	
	}

	/**
	 * 
	 * Method to find all records from the input_details table
	 * 
	 * @see getInputTableDetails
	 * @return List of InputDetails pojo class
	 * @author Shivam
	 */
	public List<InputDetails> getInputTableDetails()
	{
		return inputRepo.findAll();	
	}

	/**
	 * 
	 * Method to save all records into the input_details table
	 * 
	 * @see saveInputDetails
	 * @return List of InputDetails pojo class
	 * @author Shivam
	 */
	public List<InputDetails> saveInputDetails(List<InputDetails> inputDetails)
	{
		return inputRepo.saveAll(inputDetails);
	}

}

