package service;
import java.util.List;

import model.UserInfo;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import persistence.UserInfoDao;


@Service("userService") 
@Transactional
public interface UserService {

	

	public List<UserInfo> getAllUsers();
	public UserInfo findLoggableUser(String user, String password);
	public void addUser(UserInfo user);


}
