package com.capi.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerLoader {
	public static EntityManager loader()
	{
	EntityManagerFactory factory= Persistence.createEntityManagerFactory("Jyoti");
	EntityManager entityManager = factory.createEntityManager();
	return entityManager;
	}

}
