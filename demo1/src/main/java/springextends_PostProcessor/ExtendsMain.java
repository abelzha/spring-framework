package springextends_PostProcessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class ExtendsMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtendsAppConfig.class);
		System.out.println(Arrays.asList(context.getBeanFactory().getBeanDefinitionNames()).toString().replaceAll(",", "\n"));
		Person person = context.getBean(Person.class);
		person.setName("KAKA");
		context.close();
	}
}
