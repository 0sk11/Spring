package spring.core.quest2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext con= new ClassPathXmlApplicationContext("core2.xml");
		Question q= (Question) con.getBean("question");
		System.out.println(q);
	}

}
