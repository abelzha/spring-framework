package springextends_PostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// obtain the the beanFactory, you can do something that beanFactory allowed
		Person person = (Person) beanFactory.getBean("person");
		System.out.println("====before======="+ person.getName());
		person.setName("kebo");
		System.out.println("=====after======"+ person.getName());
	}
}
