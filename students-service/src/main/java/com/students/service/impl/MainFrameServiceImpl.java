package com.students.service.impl;

import java.util.List;

import com.students.model.Student;
import com.students.query.MainFrameQuery;
import com.students.service.MainFrameService;

public class MainFrameServiceImpl implements MainFrameService {
	
	private MainFrameQuery mainFrameQuery;
	
	public MainFrameServiceImpl() {
		this.mainFrameQuery = new MainFrameQuery();
	}
	
	@Override
	public List<Student> getAllStudents() {
		return mainFrameQuery.getStudents();
	}

}
