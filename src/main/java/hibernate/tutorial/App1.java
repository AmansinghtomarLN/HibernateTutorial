package hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App1 {

	public static void main(String[] args) {
		
		// Object of Session Factory by Singleton Design Pattern
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		Person p = session.get(Person.class,1);
		System.out.println(p);
		
	}
	
}
