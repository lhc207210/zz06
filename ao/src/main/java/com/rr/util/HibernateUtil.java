package com.rr.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory = null; 
	
	static{
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	/**
	 * 获取hibernate的session对象
	 * @return
	 */
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
}