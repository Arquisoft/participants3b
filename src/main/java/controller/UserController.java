package controller;



import service.*;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

 
@Controller
@RequestMapping("/log")
public class UserController {
 
	protected static Logger logger = Logger.getLogger("GreetingController");
 
	private UserService userService;
 
	@Autowired 
	public UserController(UserService userService) {
		this.userService = userService;
	}
 
 

}
