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


//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Application.class)
//@WebAppConfiguration
public class BDTest {

	UserInfo testUser;
	UserInfo testUser2;
	
	@Before
	public void setUp() {
		
		Date fecha = new Date(0, 0, 0);
		testUser= new UserInfo("Ivan", "iv", "email@test2.com", "123", 
				"TestName", "TestApp",fecha , "C/test1", "España");
		testUser2= new UserInfo("Iris", "ir", "email@test2.es", "456", 
				"TestName2", "TestApp2",fecha, "C/test2", "Francia");
		
		
		
	}
	
	@Test
	public void testFinder(){
		
		UserInfoDao uDao = new UserInfoDaoImpl();
		uDao.addUser(testUser);
		uDao.addUser(testUser2);
		
		UserInfo encontrado1=UserInfoFinder.findByDNI(testUser.getDni());
		UserInfo encontrado2= UserInfoFinder.findByUser(testUser2.getUsuario());
		assertNotNull(encontrado1);
		assertNotNull(encontrado2);
		
		assertEquals(encontrado1.getNombre(),testUser.getNombre());
		assertEquals(encontrado2.getNombre(),testUser2.getNombre());
		
		borrarTest(testUser);
		borrarTest(testUser);
		
		assertNull(UserInfoFinder.findByDNI(testUser.getDni()));
		
	}

	
//	@Test
//	public void test() {
//		UserInfo seila = new UserInfo("Seila", "Prada", "seila@hotm.com", new Date(), "direccion", "espa", "71735747N",
//				Generator.username("Seila", "seila@hotm.com"), Generator.password(10, 43));
//		Citizen seila2 = new Citizen("Seila2", "Prada", "seila@hotm.com", new Date(), "direccion", "espa", "71735547N",
//				Generator.username("Seila2", "seila@hotm.com"), Generator.password(10, 54));
//		Citizen seila3 = new Citizen("Seila3", "Prada", "seila@hotm.com", new Date(), "direccion", "espa", "71733247N",
//				Generator.username("Seila3", "seila@hotm.com"), Generator.password(10, 34));
//
//		
//		List<Citizen> lista = new ArrayList<Citizen>();
//		lista.add(seila);
//		lista.add(seila2);
//		lista.add(seila3);
//		
//		Insert ins = new InsertP();
//		ins.insert(lista);
//		
//		assertEquals(3, CitizenFinder.findAll().size());
//		assertNotNull(CitizenFinder.findByDNI(seila.getDNI()));
//		assertNotNull(CitizenFinder.findByDNI(seila2.getDNI()));
//		assertNotNull(CitizenFinder.findByDNI(seila3.getDNI()));
//
//		
//		ins.insert(lista);
//		assertEquals(3, CitizenFinder.findAll().size());
//		
//		Citizen dnirepetido = new Citizen("SDASA", "SAASD", "WQEQE@hotm.com", new Date(), "direccion", "espa", "71735747N",
//				Generator.username("SDASA", "WQEQE@hotm.com"), Generator.password(10, 45354));
//		
//		lista.add(dnirepetido);
//		ins.insert(lista);
//		assertEquals(3, CitizenFinder.findAll().size());
//		assertTrue("Seila".equalsIgnoreCase(CitizenFinder.findByDNI("71735747N").getNombre()));
//		
//		
//	}



	private void borrarTest(UserInfo user){
		try{
			EntityManager mapper = Jpa.createEntityManager();
			EntityTransaction trx = mapper.getTransaction();
			trx.begin();
			Jpa.getManager().remove(user);
			trx.commit();
			
		}catch(Exception e){
			
		}
	}
	
}
