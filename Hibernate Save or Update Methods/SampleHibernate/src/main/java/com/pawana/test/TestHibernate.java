package com.pawana.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class TestHibernate {

	public static void main(String[] args) {
		//insert();
		//get();
		saveorupdate();
	}

	private static void insert() {
		final SessionFactory sessionFactory = new AnnotationConfiguration().configure().addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Employee em1 = new Employee("Ma Smith", 20);
		session.save(em1);
		tx.commit();
		session.close();
	}
	private static void get() {
		final SessionFactory sessionFactory;
		sessionFactory = new AnnotationConfiguration().configure().addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Employee e1=(Employee)session.get(Employee.class,2);
		System.out.println(">>>>>>>>>>>>> "+e1.getId());
		System.out.println(">>>>>>>>>>>>> "+e1.getName());
		session.delete(e1);
		tx.commit();
		session.close();
		
	}
	
	private static void saveorupdate() {
		final SessionFactory sessionFactory;
		sessionFactory = new AnnotationConfiguration().configure().addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//Stock s1=(Stock)session.get(Stock.class,2);
		//System.out.println(">>>>>>>>>>>>> "+s1.getStockCode());
		//System.out.println(">>>>>>>>>>>>> "+s1.getStockName());
		
		
		//Stock s2 = (Stock)session.get(Stock.class,1);
		Stock s2= new Stock();
		s2.setStockName("tessst");
		s2.setStockCode("11");
		session.saveOrUpdate(s2);
		tx.commit();
		session.close();
	}

}
