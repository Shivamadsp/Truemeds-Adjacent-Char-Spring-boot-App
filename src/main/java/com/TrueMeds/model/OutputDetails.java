package com.TrueMeds.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "firstname_lastname_java_output")
public class OutputDetails {
	
	@Id
	String outputString;
	int countToFinalString;
	String timeStamp;
	
	public OutputDetails() {}
	
	public OutputDetails(String outputString, int countToFinalString, String timeStamp) {
		this.outputString = outputString;
		this.countToFinalString = countToFinalString;
		this.timeStamp = timeStamp;
	}
	
	public String getOutputString() {
		return outputString;
	}
	public void setOutputString(String outputString) {
		this.outputString = outputString;
	}
	public int getCountToFinalString() {
		return countToFinalString;
	}
	public void setCountToFinalString(int countToFinalString) {
		this.countToFinalString = countToFinalString;
	}
	public String getDate() {
		return timeStamp;
	}
	public void setDate(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	@Override
	public String toString() {
		return "OutputDetails [outputString=" + outputString + ", countToFinalString=" + countToFinalString + ", date="
				+ timeStamp + "]";
	}
	
	
	
}
