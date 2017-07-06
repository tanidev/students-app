package com.students.query;

import java.util.List;

import com.students.model.Student;
import static com.students.db.EntityManagerHandler.ENTITY_MANAGER_INSTANCE;

public class MainFrameQuery {

	public List<Student> getStudents() {
		return ENTITY_MANAGER_INSTANCE.getEntityManager().createQuery("FROM Student s", Student.class)
				.getResultList();
	}

}
