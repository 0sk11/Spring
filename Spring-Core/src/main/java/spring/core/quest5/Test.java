package spring.core.quest5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext con= new ClassPathXmlApplicationContext("core5.xml");
		Customer cus= (Customer) con.getBean("customer");
		System.out.println(cus);
	}

}
