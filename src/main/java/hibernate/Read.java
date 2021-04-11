package hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernateTables.Customer;

public class Read {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Customer.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();
	
		System.out.println("Customer with customer id=102 using primary key");
		Customer customer= session.get(Customer.class,102);
		System.out.println(customer);
	

		System.out.println("\n\n ----------------------------------------------------");
		System.out.println("All Customers");
		List<Customer> customers= session.createQuery("from Customer").getResultList();
		displayCustomer(customers);
		
		System.out.println("\n\n ----------------------------------------------------");
		System.out.println("Customer with first name= parth");
		customers= session.createQuery("from Customer where firstName='Parth'").getResultList();
		displayCustomer(customers);

		System.out.println("\n\n ----------------------------------------------------");
		System.out.println("Customer with last name like %a% ");
		customers= session.createQuery("from Customer where lastName LIKE '%a%'").getResultList();
		customers.forEach(x->System.out.println(x.getLastName()));
		
		
		
		session.getTransaction().commit();
		
				factory.close();
	}

	private static void displayCustomer(List<Customer> customers) {
		customers.forEach(System.out::println);
	}

}
