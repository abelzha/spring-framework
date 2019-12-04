package springextends_applicationListener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ListenerMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationListenerAppConfig.class);
		System.out.println(Arrays.asList(context.getBeanFactory().getBeanDefinitionNames()).toString().replaceAll(",", "\n"));
		context.close();
	}
}
