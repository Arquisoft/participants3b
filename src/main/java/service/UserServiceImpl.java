package service;



import java.util.List;

import model.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import persistence.UserInfoDao;
import persistence.impl.UserInfoDaoImpl;
import util.Encriptador;
import util.ParticipantsException;


@Service
@Transactional
@Component("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserInfoDao userDao = new UserInfoDaoImpl();




	public void addGreeting(UserInfo user) {		
		userDao.addUser(user);
	}

	/**
	 * Metodo que obtiene todos los usuarios de la base de datos
	 */
	@Override
	public List<UserInfo> getAllUsers() {
		return userDao.getAllUsers();
	}

	/**
	 * Metodo que busca el usuario y compara la contraseña para inciar sesion 
	 * De lograrlo retorna el usuario 
	 * @throws ParticipantsException 
	 */
	@Override
	public UserInfo findLoggableUser(String user, String password) throws ParticipantsException {
		UserInfo userInfo = userDao.findByUser(user);
		if(userInfo==null) throw new ParticipantsException("Usuario no encontrado.");
		try {
			if(Encriptador.desencriptar(userInfo.getPassword()).equals(password))
				return userInfo;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ParticipantsException(e.getMessage());
		}
		
		return null;
		
		
	}

	/**
	 * Añade un usuario a la base de datos
	 * @throws ParticipantsException 
	 */
	@Override
	public void addUser(UserInfo user) throws ParticipantsException {
		if(userDao.findByUser(user.getUsuario())==null){
			user.setPassword(Encriptador.encriptar(user.getPassword()));
			userDao.addUser(user);
		}else throw new ParticipantsException("El usuario ya existe");
	}
	
	
	@Override
	public void changePassword(UserInfo user, String newPassword) {
		
		if(userDao.findByUser(user.getUsuario())!=null){
			user.setPassword(Encriptador.encriptar(newPassword));
			userDao.updateUser(user);
		}
	}

	@Override
	public void changeEmail(UserInfo user, String email) {
		if(userDao.findByUser(user.getUsuario())!=null){
			user.setEmail(email);
			userDao.updateUser(user);
		}
	}
	
}
