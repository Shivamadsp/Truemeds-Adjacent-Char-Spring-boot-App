package com.TrueMeds.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "input_details")
public class InputDetails {

	@Id
	private String inputString;

	public InputDetails() {}
	
	public InputDetails(String inputString) {
		this.inputString = inputString;
	}

	public String getInputString() {
		return inputString;
	}

	public void setInputString(String inputString) {
		this.inputString = inputString;
	}
	
	@Override
	public String toString() {
		return "inputDetails [inputString=" + inputString + "]";
	}
	
}
