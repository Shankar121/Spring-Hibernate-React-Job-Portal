package com.test.reactapp.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.reactapp.beans.JobApplication;
import com.test.reactapp.dao.ApplyJobDAO;

@Repository(value="applyJobDAO")
public class ApplyJobDAOImpl implements ApplyJobDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public Boolean save(JobApplication jobApplication) {
		Session session = this.sessionFactory.openSession();
		Boolean success=true;
		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(jobApplication);
		}catch(Exception ex) {
			success=false;
			ex.printStackTrace();
		}
		
		tx.commit();
		session.close();
		return success;
	}
}
