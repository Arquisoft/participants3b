package controller;



import service.*;
import model.UserInfo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

 
@Controller
@RequestMapping("/log")
public class UserController {
 
	protected static Logger logger = Logger.getLogger("GreetingController");
//	@Autowired
//	private UserService userService;
// 
	@Autowired 
	public UserController() {
	}
	

//	@Autowired()
//	@Qualifier ("userService")
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
	
//	@RequestMapping(value = "/citizen", 
//			method = RequestMethod.POST)
//	public String getParticipantInfo(Model modelo,@RequestBody String nombre, @RequestBody String password) {
//	
//		UserInfo user = null;
//		user= userService.findLoggableUser(nombre, password);
//		if(user==null) return "login";
//		modelo.addAttribute("nombre", nombre);
//		
//		return "saludo";
//	}

 

}
