package com.students.service.impl;

import java.util.List;

import com.students.model.Student;
import com.students.query.RemoveStudentFormQuery;
import com.students.service.RemoveStudentFormService;

public class RemoveStudentFormServiceImpl implements RemoveStudentFormService {
	
	private RemoveStudentFormQuery removeStudentFormQuery;
	
	public RemoveStudentFormServiceImpl() {
		this.removeStudentFormQuery = new RemoveStudentFormQuery();
	}

	@Override
	public List<Student> getAllStudents() {
		return removeStudentFormQuery.getAllStudents();
	}

	@Override
	public void deleteStudent(Student student) {
		removeStudentFormQuery.deleteStudent(student);
	}

}
