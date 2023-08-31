package com.csm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * By Nandlal git(nandlal8949)
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	private Integer stId;
	private String stName;
	private String mobNo;
	private Integer age;
	private String classs; 
}
