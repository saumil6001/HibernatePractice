package HibernateTables;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="employee_pay_detail")
public class EmployeePay  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="employee_id")
	private int employeeId;
	
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@MapsId
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	@Column(name="pay")
	private Double pay;
	
	@Column(name="pay_method_id")
	private Integer payMethod;

	
	public EmployeePay() {
		
	}

	
	public EmployeePay(Double pay, Integer payMethod) {
		this.pay = pay;
		this.payMethod = payMethod;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Double getPay() {
		return pay;
	}


	public void setPay(Double pay) {
		this.pay = pay;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Integer getPayMethod() {
		return payMethod;
	}


	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}
	
	
	
	
}
