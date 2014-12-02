package com.assign.services;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;
	
	static {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
	    serviceRegistryBuilder.applySettings(configuration.getProperties());

	    serviceRegistry = serviceRegistryBuilder.build();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
