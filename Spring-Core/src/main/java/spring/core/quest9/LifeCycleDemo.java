package spring.core.quest9;

public class LifeCycleDemo {
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	void init() {
		System.out.println("Bean initialized");
	}
	void destory() {
		System.out.println("Bean destroyed");
	}
}
