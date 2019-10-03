package com.blockdock.datajpa.user.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blockdock.datajpa.user.model.FileDetails;

@Repository
public class BaseRepository {

	@PersistenceContext
	private EntityManager entityManager;
	private static String fileName;
	private static String success= "File deleted successfully";
	private static String failure= "No such file exists";
	
	
	@Transactional
	public Object add(Object obj) {
		return entityManager.merge(obj);
	}
}
