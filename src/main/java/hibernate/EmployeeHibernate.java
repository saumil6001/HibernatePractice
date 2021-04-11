package hibernate;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernateTables.Employee;

public class EmployeeHibernate {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();

		/*
		 * Read Employee
		 * 
		 * Query q = session.createQuery("from Employee order by employeeId desc");
		 * q.setMaxResults(1); List<Employee> employee = q.getResultList();
		 * employee.forEach(System.out::println);
		 */

		// Create Emp

		Employee emp = new Employee("Ronak","Patel",2,1);

		
		/*
		 * emp.setFirstName("sam"); emp.setLastName("Patel");
		 * 
		 * emp.setAddressId(2); emp.setManagerId(1);
		 */
		
		
		session.save(emp);

		session.getTransaction().commit();

		factory.close();

	}

}
