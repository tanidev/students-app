package com.students.service;

import java.util.List;

import com.students.model.Student;

public interface RemoveStudentFormService {
	
	List<Student> getAllStudents();
	void deleteStudent(Student student);
	
}
