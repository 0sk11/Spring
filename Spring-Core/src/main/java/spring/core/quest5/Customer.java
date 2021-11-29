package spring.core.quest5;
import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Required;

public class Customer {
	int id;
	
	@Resource(name="samee")
	CustomerContact cc;
	
	@Inject
	Address address;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Address getAddress() {
		return address;
	}
	public CustomerContact getCc() {
		return cc;
	}
	@Required
	public void setCc(CustomerContact cc) {
		this.cc = cc;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", cc=" + cc + ", address=" + address + "]";
	}
	
	
	
	
}
