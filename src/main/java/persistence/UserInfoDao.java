package persistence;

import java.util.List;

import model.UserInfo;

public interface UserInfoDao {

	
	public List<UserInfo> getAllUsers();
	public void addUser(UserInfo user);
	
}