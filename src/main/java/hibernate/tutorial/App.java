package hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	
	public static void main(String[] args)   {
		// Ctrl + Shift + R

		// Configuration

		// 1. Create SessionFactory to get Session object

		// DataSource - how you are connecting with Database
		// provides utility method for persistence

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
    configuration.addAnnotatedClass(Person.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Person p = new Person();
		p.setId(1);
		p.setName("Aman");
		p.setLastName("Tomar");
		
		session.beginTransaction();
		session.save(p);
	//	session.persist(p);
		session.getTransaction().commit();	
		session.close();
		
	System.out.println("Data is Saved");

	}
}
