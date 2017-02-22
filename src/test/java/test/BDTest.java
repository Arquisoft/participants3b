package test;

import static org.junit.Assert.*;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import controller.Application;
import persistence.UserInfoDao;
import persistence.impl.UserInfoDaoImpl;
import persistence.util.Jpa;
import persistence.util.UserInfoFinder;

import model.UserInfo;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class BDTest {

	UserInfo testUser;
	UserInfo testUser2;
	
	@Before
	public void setUp() {
		
		Date fecha = new Date(0, 0, 0);
		testUser= new UserInfo("Ivan2", "iv", "email@test2.com", "123", 
				"TestName", "TestApp",fecha , "C/test1", "España");
		testUser2= new UserInfo("Iris", "ir", "email@test2.es", "456", 
				"TestName2", "TestApp2",fecha, "C/test2", "Francia");
		
		
		
	}
	
	@Test
	public void testFinder(){
		borrarTester(testUser.getUsuario());
		borrarTester(testUser2.getUsuario());
		UserInfoDao uDao = new UserInfoDaoImpl();
		uDao.addUser(testUser);
		uDao.addUser(testUser2);

		UserInfo encontrado1=UserInfoFinder.findByDNI(testUser.getDni());
		UserInfo encontrado2= UserInfoFinder.findByUser(testUser2.getUsuario());
		assertNotNull(encontrado1);
		assertNotNull(encontrado2);
		
		assertEquals(encontrado1.getNombre(),testUser.getNombre());
		assertEquals(encontrado2.getNombre(),testUser2.getNombre());
	
		borrarTester(testUser.getUsuario());
		borrarTester(testUser2.getUsuario());
		
		assertNull(UserInfoFinder.findByDNI(testUser.getDni()));
		
	
	}
	



	private void borrarTester(String user){
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
