package spring.core.quest5;

public class CustomerContact {
	
	String name;
	long contact;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "CustomerContact [name=" + name + ", contact=" + contact + "]";
	}
	
	
}
