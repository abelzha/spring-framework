package transactiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * TODO
 *
 * @author : jun
 * @date : 2021年05月23日
 */
@Repository
public class UserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void insertUser(){
		String sql = "INSERT INTO abel_demo.test11 (username,password,phone,email) VALUES \n" +
				"('client','$2a$10$5PEF2ekqYq0iu7VBYiH8BON434.nTe9doHD/O1lebhyhG8ywLyE9W','15888888888','lee@gmail.com')";
		jdbcTemplate.update(sql);
	}

}
