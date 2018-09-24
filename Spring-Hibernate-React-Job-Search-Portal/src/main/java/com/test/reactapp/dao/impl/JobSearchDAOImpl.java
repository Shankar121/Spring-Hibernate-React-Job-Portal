package com.test.reactapp.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.reactapp.beans.JobDetails;
import com.test.reactapp.dao.JobSearchDAO;

@Repository(value="jobSearchDAO")
public class JobSearchDAOImpl implements JobSearchDAO{

	@Autowired
	SessionFactory sessionFactory;


	public List<JobDetails> fetchAllJobDetails() {
		Session session = this.sessionFactory.openSession();
		Criteria criteria=session.createCriteria(JobDetails.class);
		criteria.addOrder(Order.desc("createdOn"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<JobDetails> list = criteria.list();
		session.close();
		return list;
	}


	public List<JobDetails> searchByKeyword(String searchText) {
		Session session = this.sessionFactory.openSession();
		Criteria criteria=session.createCriteria(JobDetails.class);
		criteria.add(Restrictions.like("technology", "%"+searchText+"%"));
		criteria.addOrder(Order.desc("createdOn"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<JobDetails> list = criteria.list();
		session.close();
		return list;
	}


	public List<JobDetails> searchByType(String type) {
		Session session = this.sessionFactory.openSession();
		Criteria criteria=session.createCriteria(JobDetails.class);
		List<String> typeList=new ArrayList<String>();
		typeList.addAll(Arrays.asList(type.split(",")));
		if(!(typeList.contains("-1"))) {
			criteria.add(Restrictions.in("type", typeList));
		}
		criteria.addOrder(Order.desc("createdOn"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<JobDetails> list = criteria.list();
		session.close();
		return list;
	}


	public List<JobDetails> searchByExp(Float yoeLower, Float yoeUpper) {
		Session session = this.sessionFactory.openSession();
		Criteria criteria=session.createCriteria(JobDetails.class);
		criteria.add(Restrictions.ge("yoeLower", yoeLower));
		criteria.add(Restrictions.le("yoeUpper", yoeUpper));
		criteria.addOrder(Order.desc("createdOn"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<JobDetails> list = criteria.list();
		session.close();
		return list;
	}


	public List<JobDetails> searchByLoc(String location) {
		Session session = this.sessionFactory.openSession();
		Criteria criteria=session.createCriteria(JobDetails.class);
		if(!"-1".equalsIgnoreCase(location)) {
			criteria.add(Restrictions.like("jobLocation", "%"+location+"%"));
		}
		criteria.addOrder(Order.desc("createdOn"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<JobDetails> list = criteria.list();
		session.close();
		return list;
	}

	
}
