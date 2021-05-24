package transactiondemo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
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
		// 替换成自己的数据配置
		dataSource.setUser("**");
		dataSource.setPassword("**");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://*****:3306/abel_demo?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull");
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}
}
