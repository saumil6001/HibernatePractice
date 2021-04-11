package Database;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernateTables.Customer;

public class HibernateDao {
	public static void main(String[] args) {
		addCustomer("Saumil","Patel",2,"Surveyor","nom-Smoker");
	}

	
	public static boolean addCustomer(String firstName,String lastName,int addressId,String occupation,String smoker) {
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Customer.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(new Customer(firstName,lastName,addressId,occupation,smoker));
		session.getTransaction().commit();
		return true ;
	}
}
