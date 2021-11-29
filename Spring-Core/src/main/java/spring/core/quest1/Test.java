package spring.core.quest1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext con= new ClassPathXmlApplicationContext("core1.xml");
		Customer cus= (Customer) con.getBean("customer");
		System.out.println(cus);
	}

}
