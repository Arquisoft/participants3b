package service;
import java.util.List;

import model.UserInfo;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import persistence.UserInfoDao;

@Service
@Transactional
public class UserService {

	protected static Logger logger = Logger.getLogger("GreetingService");

	@Autowired
	private UserInfoDao userDao;

	public List<UserInfo> getAllGreetings() {		
		return userDao.getAllUsers();		
	}

	public void addGreeting(UserInfo user) {		
		userDao.addUser(user);
	}


}
