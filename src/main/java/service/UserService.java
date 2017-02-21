package service;
import java.util.List;

import model.UserInfo;

import org.springframework.stereotype.Repository;

import util.ParticipantsException;



@Repository 
public interface UserService {


	public List<UserInfo> getAllUsers();
	public UserInfo findLoggableUser(String user, String password) throws ParticipantsException;
	public void addUser(UserInfo user) throws ParticipantsException;

	public void changePassword(UserInfo user, String newPassword);

}
