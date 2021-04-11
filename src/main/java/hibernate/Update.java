package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernateTables.Customer;

public class Update {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();
		Customer customer=session.get(Customer.class,202104101);
		customer.setOccupation("Computer Programer");
		session.getTransaction().commit();
		
		
		session=factory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("update Customer set firstName='Sam' where customerId='202104101'").executeUpdate();
		session.getTransaction().commit();
		
		
		factory.close();
	}

}
