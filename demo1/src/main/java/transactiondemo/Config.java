package transactiondemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * TODO
 *
 * @author : jun
 * @date : 2021年05月23日
 */

@EnableTransactionManagement
@Configuration
@ComponentScan("transactiondemo")
public class Config {

	@Bean
	public DataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();

		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws PropertyVetoException {
		return new DataSourceTransactionManager(dataSource());
	}
}
