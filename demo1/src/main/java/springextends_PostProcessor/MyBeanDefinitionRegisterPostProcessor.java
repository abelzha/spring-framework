package springextends_PostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegisterPostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("before postProcessBeanDefinitionRegistry===All bean definition count is " + registry.getBeanDefinitionCount());
		registry.registerBeanDefinition("car", new RootBeanDefinition(Car.class));
		System.out.println("after postProcessBeanDefinitionRegistry===All bean definition count is " + registry.getBeanDefinitionCount());
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// do someting you want
	}
}
