package test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import controller.Application;
import model.UserInfo;
import persistence.UserInfoDao;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration


public class DBTest {
	
	@Autowired
	private UserInfoDao ueDao;
	

	@Test
	public void test() {
		
		UserInfo ue = ueDao.find("miguel","miguel");
		
		assertEquals("miguel", ue.getUsuario());
		assertEquals("miguel", ue.getPassword());
		
		
		
	}

}
