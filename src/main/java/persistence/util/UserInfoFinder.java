package persistence.util;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import model.UserInfo;

public class UserInfoFinder {

	public static UserInfo findByDNI(String dni) {
		return (UserInfo) Jpa.getManager().createNamedQuery("Citizen.findByDNI", UserInfo.class).setParameter(1, dni)
				.getResultList().stream().findFirst().orElse(null);
	}

	public static List<UserInfo> findAll() {
		return Jpa.getManager().createNamedQuery("Citizen.findAll", UserInfo.class).getResultList();
	}
	
	public static UserInfo findByUser(String user){
		List<UserInfo>r = Jpa.getManager().createNamedQuery("Citizen.findByUser", UserInfo.class).setParameter(1,user).getResultList();
		if(r.isEmpty())return null;
		
		return r.get(0);
	}
}
