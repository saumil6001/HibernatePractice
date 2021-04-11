package Idgenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomerIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		String id = LocalDate.now().toString();
		id = id.substring(0, 4) + id.substring(5, 7) + id.substring(8, 10);
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;

		ReentrantLock lock = new ReentrantLock();

		try {
			lock.tryLock(2000, TimeUnit.SECONDS);
			connection = session.connection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("select customer_id from Customer order by customer_id Desc limit 1;");
			if (resultset.next()) {
				String LastCustomerId = Integer.toString(resultset.getInt("customer_id"));
				if (id.equals(LastCustomerId.substring(0, 8))) {
					int suffix = Integer.parseInt(LastCustomerId.substring(8)) + 1;
					id = id.concat(Integer.toString(suffix));
				} else {
					id = id.concat("1");
				}
			}
		} catch (InterruptedException | SQLException e1) {
			e1.printStackTrace();
		} finally {
			lock.unlock();
		}

		System.out.println("Generated Id= " + id);
		return Integer.parseInt(id);
	}

}
