package persistence.util;

import java.util.List;

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
		return Jpa.getManager().createNamedQuery("Citizen.findByUser", UserInfo.class).setParameter(1,user).getSingleResult();
	}
}
