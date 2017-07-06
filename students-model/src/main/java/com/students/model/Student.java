package com.students.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private Integer age;
	private String country;
	
	@Column(name="zip_code")
	private Integer zipCode;
	
	//For JPA Necessary
	Student() {
		
	}
	
	public Student(String name, Integer age, String country, Integer zipCode) {
		this.name = name;
		this.age = age;
		this.country = country;
		this.zipCode = zipCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String county) {
		this.country = county;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	
	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		
		result = prime * result + name.hashCode();
		result = prime * result + zipCode.hashCode();
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == this) {
			return true;
		}
		
		if(!(obj instanceof Student)) {
			return false;
		}
		
		Student student = (Student) obj;
		
		return student.getName().equals(this.name) && student.getZipCode().equals(this.zipCode);
		
	}


	@Override
	public String toString() {
		return name + " - " + age;
	}	
	
}
