package HibernateTables;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="employee")
public class Employee {
	
	
	@Id
	@GenericGenerator(name = "employeeIdGenerator", strategy = "Idgenerator.EmployeeIdGenerator")
	@GeneratedValue(generator = "employeeIdGenerator")
	@Column(name="employee_id")
	private int employeeId;
	
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="address_id")
	private Integer addressId;
	
	@Column(name="manager_id")
	private Integer managerId;
	
	@Column(name="joining_date")
	private LocalDate joinInDate;
	
	@OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
	private EmployeePay employeePay;
	
	
	public Employee() {
		
	}

	public Employee(String firstName, String lastName, Integer addressId, Integer managerId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressId = addressId;
		this.managerId = managerId;
		this.joinInDate = LocalDate.now();
	}
	

	public Employee(String firstName, String lastName, Integer addressId, Integer managerId,LocalDate joinInDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressId = addressId;
		this.managerId = managerId;
		this.joinInDate = joinInDate;
	}

	
	
	
	public EmployeePay getEmployeePay() {
		return employeePay;
	}

	public void setEmployeePay(EmployeePay employeePay) {
		this.employeePay = employeePay;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public LocalDate getJoinInDate() {
		return joinInDate;
	}

	public void setJoinInDate(LocalDate joinInDate) {
		this.joinInDate = joinInDate;
	}

	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", addressId=" + addressId + ", managerId=" + managerId + ", joinInDate=" + joinInDate + "]";
	}
	
	
}
