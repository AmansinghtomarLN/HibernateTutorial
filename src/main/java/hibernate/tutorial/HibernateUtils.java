package hibernate.tutorial;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	// Single design pattern for Session factory

	private static  SessionFactory session = null;

	public static SessionFactory getSessionFactory() {

		if(session==null) {
			
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			configuration.addAnnotatedClass(Person.class);

			session = configuration.buildSessionFactory();
		}
		
		return session;
	}

}
