package transactiondemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * TODO
 *
 * @author : jun
 * @date : 2021年05月23日
 */
public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		UserService userService = context.getBean(UserService.class);
		userService.insertUser();
		context.close();
	}
}
