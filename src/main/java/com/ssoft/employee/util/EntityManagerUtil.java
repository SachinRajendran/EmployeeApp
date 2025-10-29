package com.ssoft.employee.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
	private static EntityManager entityManager;

	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeUnit");

			entityManager = emf.createEntityManager();

			return entityManager;
		}
		return entityManager;
	}
}
