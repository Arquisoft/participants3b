package test;

import static org.junit.Assert.*;

import java.sql.Date;



import model.UserInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;



import service.UserService;
import service.UserServiceImpl;
import util.EliminarTester;
import util.Encriptador;
import util.ParticipantsException;
import controller.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ServicesTest{

	UserService uS = new UserServiceImpl();
	UserInfo testUser;
	
	@Before
	public void setUp(){
		@SuppressWarnings("deprecation")
		Date fecha = new Date(0, 0, 0);
		testUser =new UserInfo("Ivan2", Encriptador.encriptar("passw"), "email@test2.com", "123", 
				"TestName", "TestApp",fecha , "C/test1", "España");
		
		limpiarTest();
	}
	@Test
	public void serviceTest() throws Exception{
		
		uS.addUser(testUser);
		
		UserInfo uI = uS.findLoggableUser(testUser.getUsuario(), Encriptador.desencriptar(testUser.getPassword()));
		assertNotNull(uI);
		
		String nuevoEmail = "nuevoEmail@test3.es";
		uS.changeEmail(uI, nuevoEmail);
		
		String nuevaPassword = "2pass";		
		uS.changePassword(uI, "2pass");
		
		uI = uS.findLoggableUser(testUser.getUsuario(), nuevaPassword);
		assertNotNull(uI);
		
		assertEquals(nuevoEmail, uI.getEmail());
		assertEquals(nuevaPassword, Encriptador.desencriptar(uI.getPassword()));
		
		limpiarTest();
	}
	@Test
	public void participantsException(){
		String err="";
		String errInicial="Test de error";
		try{
			throw new ParticipantsException(errInicial);
		}catch(ParticipantsException e){
			err=e.getMessage();
		}
		assertEquals(err,errInicial);
	}
	
	private void limpiarTest(){
		EliminarTester.borrarTester(testUser.getUsuario());
	}
}
