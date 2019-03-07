package com.capgemini.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerLoader {
	public static EntityManager loader()
	{
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("Saurabh");
		EntityManager entityManager = factory.createEntityManager();
		return entityManager;
	}

}
