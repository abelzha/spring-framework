package springextends;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("springextends")
public class ExtendsAppConfig {

	@Bean(value = "person")
	public Person person(){
		return new Person("abel");
	}
}
