package test;

import static org.junit.Assert.*;

import java.sql.Date;

import model.UserInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import controller.Application;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class UserInfoTest {

	
	private UserInfo testUser;
	private UserInfo testUser2;
	
	
	@Before
	public void setUserInfo(){

		
		@SuppressWarnings("deprecation")
		Date fecha = new Date(0, 0, 0);
		testUser= new UserInfo("testUser1", "ss", "email@test2.com", "123", 
				"TestName", "TestApp",fecha , "C/test1", "España");
		testUser2= new UserInfo("testUser2", "ee", "email@test2.es", "456", 
				"TestName2", "TestApp2",fecha , "C/test2", "Francia");
	}
	@Test
	public void testAll() {
		
	}
	
	@Test
	public void testUser(){
		String test1 = "testUser1";
		assertEquals(test1, testUser.getUsuario());
		String test2 = "testUser2";
		assertEquals(test2, testUser2.getUsuario());
	}
	
	@Test 
	public void testEmail(){
		String email1="email@test2.com";
		String email2= "email@test2.es";
		assertEquals(testUser.getEmail(),email1);
		assertEquals(testUser2.getEmail(),email2);
	}
	
	@Test 
	public void testPassword(){
		String pass="ss";
		String pass2= "ee";
		assertEquals(testUser.getPassword(),pass);
		assertEquals(testUser2.getPassword(),pass2);
	}
	@Test 
	public void testDNI(){
		String DNI1="123";
		String DNI2= "456";
		assertEquals(testUser.getDni(),DNI1);
		assertEquals(testUser2.getDni(),DNI2);
	}
	@Test 
	public void testNameAndLastName(){
		String name="TestName";
		String name2= "TestName2";
		String lastName= "TestApp";
		String lastName2 = "TestApp2";
		
		assertEquals(testUser.getNombre(),name);
		assertEquals(testUser2.getNombre(),name2);
		
		assertEquals(testUser.getApellidos(),lastName);
		assertEquals(testUser2.getApellidos(),lastName2);
	}
	
}
