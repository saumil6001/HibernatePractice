package Idgenerator;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import HibernateTables.Employee;

public class EmployeeIdGenerator implements IdentifierGenerator {

	
	@Override
	public Serializable generate(SharedSessionContractImplementor sharedsession, Object object) throws HibernateException {

		Session session=sharedsession.getFactory().getCurrentSession();
		
	
		
		ReentrantLock lock =new ReentrantLock();
		int id=0;
		try {
			if(lock.tryLock(2000,TimeUnit.SECONDS)){
	
		
				Query q = session.createQuery("from Employee order by employeeId desc");
				q.setMaxResults(1);
				List<Employee> employee = q.getResultList();	
				id=employee.get(0).getEmployeeId();
				id=id+1;
				return id;		
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
		return id;
	}

	
	
	
	
}
