package controller;

import java.sql.Date;

import model.UserInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.UserService;
import service.UserServiceImpl;
import util.ParticipantsException;

@Controller
public class MainController {


	private UserService userService;
 
	@RequestMapping("/")
	public String landing(Model model) {
		model.addAttribute("nombre", "Amigo");
		return "saludo";
	}

	@RequestMapping("/hola")
	public String hola(Model model) {
		model.addAttribute("nombre", "Luis");
		return "saludo";
	}

	@RequestMapping("/inicio")
	public String log() {
		return "login";
	}

	@RequestMapping("/testUsuario")
	public String testUsuario(Model model) {
		@SuppressWarnings("deprecation")
		Date fecha = new Date(0, 0, 0);
		model.addAttribute("user", new UserInfo("testUser", "ss", "email@tes.com", "123T", 
				"TestName", "TestApp",fecha , "C/test", "España"));
		return "infoUsuario";
	}

	
	@RequestMapping(value = "/login", 
			method = RequestMethod.POST)
	public String getParticipantInfo(Model modelo,@RequestBody String nombre, @RequestBody String password) {
	
		userService= new UserServiceImpl();
		UserInfo user;
		try {
			user = userService.findLoggableUser(nombre, password);
			
		} catch (ParticipantsException e) {
			modelo.addAttribute("err", e.getMessage());
			return "error";
		}

		//retornara la "web" con info del usuario
		modelo.addAttribute("user", user);
		return "infoUsuario";
	}
	

	


}