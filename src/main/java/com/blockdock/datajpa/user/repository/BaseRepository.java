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
	
//	@Autowired
//	SessionFactory sessionFactory;
	
	private static String fileName;
	private static String success= "File deleted successfully";
	private static String failure= "No such file exists";
	
//	protected Session currentSession() {
//		return sessionFactory.getCurrentSession();
//	}
	
	@Transactional
	public Object add(Object obj) {
		return entityManager.merge(obj);
	}
	
	
//	@Transactional
//	public void delete(Long id) {
//		
//		currentSession().delete(id);
//		/*//File file = entityManager.find(File.class, id);
//		
//		//Call remove method to remove the entity
//	      //if(file != null){
//	    	 // entityManager.delete(file);
//	    	  return success;
//	      
//	      }
//	      
//	      else {
//	    	  return failure;
//	      }*/
//	      
//	      
//	}
			
      
      

}
