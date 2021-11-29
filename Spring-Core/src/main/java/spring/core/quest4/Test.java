package spring.core.quest4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext con= new ClassPathXmlApplicationContext("core4.xml");
		BankAccountController contr= (BankAccountController) con.getBean("bankAccountController");
		System.out.println(contr.getBalance(12));
		System.out.println(contr.withdraw(450, 500000));
		System.out.println(contr.deposit(450, 500000));
		System.out.println(contr.fundTransfer(125, 965, 2000));
		System.out.println(contr.getBalance(125));
		
	}
}
