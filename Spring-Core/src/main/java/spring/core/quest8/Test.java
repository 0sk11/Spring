package spring.core.quest8;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext con= new ClassPathXmlApplicationContext("core8.xml");
		con.registerShutdownHook();
		Customer cus= (Customer) con.getBean("customer");
		System.out.println(cus);
	}

}
