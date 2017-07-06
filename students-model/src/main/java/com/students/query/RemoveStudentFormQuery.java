package com.students.query;

import java.util.List;

import javax.persistence.PersistenceException;

import static com.students.db.EntityManagerHandler.ENTITY_MANAGER_INSTANCE;

import com.students.model.Student;

public class RemoveStudentFormQuery {

	public List<Student> getAllStudents() {
		return ENTITY_MANAGER_INSTANCE.getEntityManager().createQuery("FROM Student s", Student.class)
			.getResultList();
	}
	
	public void deleteStudent(Student student) {
		
		try {
			ENTITY_MANAGER_INSTANCE.openTransaction();
			ENTITY_MANAGER_INSTANCE.getEntityManager().remove(student);
			ENTITY_MANAGER_INSTANCE.commitTransaction();
		} catch (PersistenceException e) {
			e.printStackTrace();
			ENTITY_MANAGER_INSTANCE.rollbackTransaction();
		}
	}

}
