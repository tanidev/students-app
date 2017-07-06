package com.students.service.impl;

import com.students.model.Student;
import com.students.query.AddStudentFormQuery;
import com.students.service.AddStudentFormService;

public class AddStudentFormServiceImpl implements AddStudentFormService {
	
	private AddStudentFormQuery addStudentFormQuery;
	
	public AddStudentFormServiceImpl() {
		addStudentFormQuery = new AddStudentFormQuery();
	}
	
	@Override
	public void insertStudent(Student student) {
		this.addStudentFormQuery.insertStudent(student);
	}
	
}
