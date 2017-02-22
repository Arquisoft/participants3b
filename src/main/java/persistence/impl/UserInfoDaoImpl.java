package persistence.impl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.UserInfo;

import org.apache.log4j.Logger;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import persistence.UserInfoDao;
import persistence.util.Jpa;
import persistence.util.UserInfoFinder;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {
	 
		protected static Logger logger = Logger.getLogger("UserInfoDao");
	 
		
		@Autowired
		private SessionFactory sessionFactory;
		
		public List<UserInfo> getAllUsers() {
			EntityManager mapper = Jpa.createEntityManager();
			EntityTransaction trx = mapper.getTransaction();
			trx.begin();
			List<UserInfo> lista = new ArrayList<UserInfo>();
			lista = UserInfoFinder.findAll();
		    return lista;			
		}
	 
		public void addUser(UserInfo user) {
			EntityManager mapper = Jpa.createEntityManager();
			EntityTransaction trx = mapper.getTransaction();
			trx.begin();
			if(UserInfoFinder.findByUser(user.getUsuario())==null){
				Jpa.getManager().persist(user);
				
			}else{
				System.err.println("[BD] Usuario ya existe en la base de datos");
			}
			trx.commit();
		}
		
		/**
		 * Metodo que actualiza la informacion de un uuario
		 * @param user
		 */
		public void updateUser(UserInfo user){
			EntityManager mapper = Jpa.createEntityManager();
			EntityTransaction trx = mapper.getTransaction();
			trx.begin();
			if(user!=null){
				Jpa.getManager().merge(user);
			} else System.err.println("[BD] El usuario que se intenta actualizar es invalido");
			trx.commit();

		}

		/**
		 * Metodo que busca un usuario con una contraseña en la base de datos 
		 */
		@Override
		public UserInfo findByUser(String user) {
			EntityManager mapper = Jpa.createEntityManager();
			EntityTransaction trx = mapper.getTransaction();
			trx.begin();
			UserInfo userInfo= UserInfoFinder.findByUser(user);
			if(userInfo!=null) return userInfo;
			else System.err.println("[BD] Usuario no encontrado");
			return userInfo;
		}
	 
	}

