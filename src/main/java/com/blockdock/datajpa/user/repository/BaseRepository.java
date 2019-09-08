package com.blockdock.datajpa.user.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BaseRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Object add(Object obj) {
		return entityManager.merge(obj);
	}

}
