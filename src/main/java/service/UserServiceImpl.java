package service;



import java.util.List;

import model.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import persistence.UserInfoDao;


@Service
@Transactional
@Component("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserInfoDao userDao;

	public UserServiceImpl(){
		
	}
	public List<UserInfo> getAllGreetings() {		
		return userDao.getAllUsers();		
	}

	public void addGreeting(UserInfo user) {		
		userDao.addUser(user);
	}

	/**
	 * Metodo que obtiene todos los usuarios de la base de datos
	 */
	@Override
	public List<UserInfo> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Metodo que busca el usuario y compara la contraseña para inciar sesion 
	 * De lograr el inicio de sesion retorna la informacion del usuario
	 */
	@Override
	public UserInfo findLoggableUser(String user, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Añade un usuario a la base de datos
	 */
	@Override
	public void addUser(UserInfo user) {
		// TODO Auto-generated method stub
		
	}

}
