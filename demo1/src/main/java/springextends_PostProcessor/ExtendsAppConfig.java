package springextends_PostProcessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("springextends_PostProcessor")
public class ExtendsAppConfig {

	@Bean(value = "person")
	public Person person(){
		return new Person("abel");
	}
}
