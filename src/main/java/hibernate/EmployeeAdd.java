package hibernate;


import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernateTables.Employee;
import HibernateTables.EmployeePay;

public class EmployeeAdd {
	
	
	/**
	 * 
	 */
	
	public static void main(String[] args) {

		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.addAnnotatedClass(EmployeePay.class)
								.buildSessionFactory();
		
		Session session= factory.getCurrentSession();

		session.beginTransaction();
		
		Employee employee= new Employee();
		employee.setFirstName("Nisarg");
		employee.setLastName("patel");
		employee.setManagerId(4);
		employee.setJoinInDate(LocalDate.now());
		employee.setAddressId(3);
		
		
		EmployeePay emppay= new EmployeePay();
		emppay.setPay(18.0);
		emppay.setPayMethod(2);
		emppay.setEmployee(employee);
		
		
		
		session.save(emppay);
		session.getTransaction().commit();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
