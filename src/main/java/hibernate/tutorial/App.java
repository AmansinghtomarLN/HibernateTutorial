package hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		// Ctrl + Shift + R

		/*
		 * 1. Configuration - to configure configuration file and mapping file
		 * 
		 * 2. Create SessionFactory to get Session object // DataSource - how you are
		 * connecting with Database // provides utility method for persistence
		 * 
		 * 3. Create Session 4. Transaction 5. Also configure Entity including required
		 * attributes or annotation
		 * 
		 */

		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		configuration.addAnnotatedClass(Person.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory(); // singleton
		Session session = sessionFactory.openSession();

		Person p = new Person();
		p.setId(3);
		p.setName("Amisha");
		p.setLastName("Tomar");

		session.beginTransaction();

	//	session.save(p);
		// session.persist(p);
		session.getTransaction().commit();

		session.close();

		System.out.println("Data is Saved");

		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		Person p1 = session2.get(Person.class, 1);
	//	Person p2 = session2.load(Person.class, 3);
		
		p1.setLastName("TOMAR");
		
		session2.update(p1); // transaction commit is needed
		session2.getTransaction().commit();
		session2.close();
		System.out.println(p1.toString());
	//	System.out.println(p2.toString());
		
		
	}

}
