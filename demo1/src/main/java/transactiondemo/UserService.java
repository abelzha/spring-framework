package transactiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO
 *
 * @author : jun
 * @date : 2021年05月23日
 */

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	@Transactional
	public void insertUser() {
		userDao.insertUser();
		int j=0;
		int i = 10 / j;
	}


	@Transactional
	public void insertUser2() {
		userDao.insertUser2();
		int j=0;
		int i = 10 / j;
	}
}
