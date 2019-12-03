package aspectdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class AspectMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfigAspect.class);
		System.out.println(Arrays.asList(context.getBeanFactory().getBeanDefinitionNames()).toString().replaceAll(",", "\n"));
		Person person = context.getBean(Person.class);
		person.setPersonName("KAKA");
		context.close();
	}
}
