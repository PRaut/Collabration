package com.chatter.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chatter.DAO.JobDAO;
import com.chatter.model.ApplyJob;
import com.chatter.model.Job;

@Repository("JobDAO")
public class JobDAOImpl implements JobDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	@Override
	public boolean addJob(Job job) {
		try {
			sessionFactory.getCurrentSession().save(job);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteJob(Job job) {
		try {
			sessionFactory.getCurrentSession().delete(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean updateJob(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Job> listJob() {
		List<Job> listJob = null;
		try {
			listJob = sessionFactory.openSession().createQuery("FROM Job").list();

		} catch (Exception e) {
			System.err.println(e);
		}
		return listJob;
	}

	@Transactional
	@Override
	public boolean applyJob(Job job) {
		try {
			// job.setApplyStatus("NA");
			sessionFactory.getCurrentSession().update(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean applyJob(ApplyJob app) {
		try {
			sessionFactory.getCurrentSession().save(app);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<ApplyJob> getAllApplicationJobDetails() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(" from  ApplyJob");
		query.list();
		List<ApplyJob> applyjoblist = query.list();
		return applyjoblist;
	}

}
