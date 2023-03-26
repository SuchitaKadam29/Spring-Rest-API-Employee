package com.rest.webservice.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Employee {


	//@Min(100) @Max(999)
	private int eid;
	
	//@NotNull
	//@NotEmpty
	//@Pattern(regexp = "[A-Z][a-z]{3}",message = "Invalid Ename pattern")
	private String ename;
	
	//@Min(value = 5000)
	//@Max(value = 99000)
	private double salary;
	
}
