package com.students.query;

import static com.students.db.EntityManagerHandler.ENTITY_MANAGER_INSTANCE;

import com.students.model.Student;

public class AddStudentFormQuery {
	
	public void insertStudent(Student student) {
		ENTITY_MANAGER_INSTANCE.openTransaction();
		ENTITY_MANAGER_INSTANCE.getEntityManager().persist(student);
		ENTITY_MANAGER_INSTANCE.commitTransaction();
	}

}
