package service;
import java.util.List;

import model.UserInfo;

import org.springframework.stereotype.Repository;



@Repository 
public interface UserService {

	

	public List<UserInfo> getAllUsers();
	public UserInfo findLoggableUser(String user, String password);
	public void addUser(UserInfo user);


}
