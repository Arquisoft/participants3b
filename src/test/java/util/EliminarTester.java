package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.UserInfo;
import persistence.util.Jpa;
import persistence.util.UserInfoFinder;

public  class EliminarTester {

	public static void borrarTester(String user){
		try{
			EntityManager mapper = Jpa.createEntityManager();
			EntityTransaction trx = mapper.getTransaction();
			trx.begin();
			UserInfo userInfo= UserInfoFinder.findByUser(user);
			Jpa.getManager().remove(userInfo);
			
			trx.commit();
			
		}catch(Exception e){
			
		}
	}
	
}
