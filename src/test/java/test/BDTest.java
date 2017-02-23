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
import util.Encriptador;
import model.UserInfo;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class BDTest {

	UserInfo testUser;
	UserInfo testUser2;
	
	private UserInfoDao ueDao;
	
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
	
	@Test
	public void existeCiudadanoTest() {
		UserInfo ue1= ueDao.findByUser("Seila_seila");
		UserInfo ue2= ueDao.findByUser("Seila2_seila");
		
	
		assertEquals("Seila", ue1.getNombre());
		assertEquals("Seila2", ue2.getNombre());
	}
	
	@Test
	public void noExisteCiudadanoTest() {
		UserInfo ue1= ueDao.findByUser("Miguel");
		UserInfo ue2= ueDao.findByUser("Ivan");
		
	
		assertNull(ue1);
		assertNull(ue2);
	}
	
	@Test
	public void comprobarDatos() {
		UserInfo ue1 = ueDao.findByUser("Seila_seila");
		assertEquals("Seila", ue1.getNombre());
		assertEquals("Prada", ue1.getApellidos());
		assertEquals("seila@hotm.com", ue1.getEmail());
		assertEquals("BOOZ0BADDB", ue1.getPassword());
		assertEquals("71735747N", ue1.getDni());
		assertEquals("Seila_seila", ue1.getUsuario());
		assertEquals("direccion", ue1.getDireccion());
		assertEquals("2017-02-22", ue1.getFechaNacimiento());
		
		
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
