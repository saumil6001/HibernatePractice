package HibernateTables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GenericGenerator(name = "sequence_id_generator", strategy = "Idgenerator.CustomerIdGenerator")
    @GeneratedValue(generator = "sequence_id_generator")  
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "address_id")
	private Integer addressId;

	@Column(name = "occupation")
	private String occupation;

	@Column(name = "smoker")
	private String smoker;

	public Customer() {

	}

	public Customer(String firstName, String lastName, int addressId, String occupation, String smoker) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressId = addressId;
		this.occupation = occupation;
		this.smoker = smoker;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSmoker() {
		return smoker;
	}

	public void setSmoker(String smoker) {
		this.smoker = smoker;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", addressId=" + addressId + ", occupation=" + occupation + ", smoker=" + smoker + "]";
	}

	
	
}
