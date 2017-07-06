package com.students.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public enum EntityManagerHandler {
	
	ENTITY_MANAGER_INSTANCE;
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	public void openTransaction() {
		if(!this.entityManager.getTransaction().isActive())
			this.entityManager.getTransaction().begin();
	}
	
	public void commitTransaction() {
		this.entityManager.getTransaction().commit();
	}
	
	public void rollbackTransaction() {
		this.entityManager.getTransaction().rollback();
	}
	
	public void shutdown() {
		this.entityManager.close();
	}

}
