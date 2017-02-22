package persistence.impl;


import java.util.List;

import model.UserInfo;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import persistence.UserInfoDao;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {
	 
		protected static Logger logger = Logger.getLogger("UserInfoDao");
	 
		
		@Autowired
		private SessionFactory sessionFactory;
		
		public List<UserInfo> getAllUsers() {
			Session session = sessionFactory.getCurrentSession();		
			Query q = session.createQuery("select i from UserInfo i order by id desc");
			@SuppressWarnings("unchecked")
			List<UserInfo> userList = q.list(); 
		        return userList;			
		}
	 
		public void addUser(UserInfo user) {
			Session session = sessionFactory.getCurrentSession();	
			session.save(user);
		}
		
		/**
		 * Metodo que actualiza la informacion de un uuario
		 * @param user
		 */
		public void updateUser(UserInfo user){
			Session session = sessionFactory.getCurrentSession();		
			session.update(user);
		}

		/**
		 * Metodo que busca un usuario con una contraseña en la base de datos 
		 */
		@Override
		public UserInfo findByUser(String user) {
			Session session = sessionFactory.getCurrentSession();		
			Query q = session.createQuery("select i from UserInfo i where i.usuario==user");
			UserInfo userInfo = (UserInfo) q.uniqueResult(); 
		    return userInfo;		
		}
	 
	}

