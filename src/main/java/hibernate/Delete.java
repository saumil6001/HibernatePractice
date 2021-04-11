package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernateTables.Customer;

public class Delete {

		public static void main(String[] args) {
			
			SessionFactory factory= new Configuration()
									.configure()
									.addAnnotatedClass(Customer.class)
									.buildSessionFactory();
			
			Session session= factory.getCurrentSession();
			
			session.beginTransaction();
			Customer customer=session.get(Customer.class, 202104090);
			session.delete(customer.getOccupation(), customer);
		
			
			
		//	session.createQuery("delete from Customer where customerId=202104092").executeUpdate(); 
			session.getTransaction().commit();	
		
		
		
		
		
		
		
		
		
		
		}
	
	
	
	
	
	
	
	
	
	
}
