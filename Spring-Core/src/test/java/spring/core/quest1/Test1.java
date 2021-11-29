package spring.core.quest1;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
	@Test
	public void test() {
		ApplicationContext con= new ClassPathXmlApplicationContext("beans1.xml");
		Customer cus= (Customer) con.getBean("customer");
		assertEquals(cus, new Customer(534, "Samee", 9963868725L, new Address("Masab Tank", "Hyderabad", "Telangana", 500028, "India")));
	}

}
