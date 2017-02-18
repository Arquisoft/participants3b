package controller;

import model.UserInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserService;
import service.UserServiceImpl;

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

	@RequestMapping(value = "/login", 
			method = RequestMethod.POST)
	public String getParticipantInfo(Model modelo,@RequestBody String nombre, @RequestBody String password) {
	
		userService= new UserServiceImpl();
		UserInfo user = null;
		user= userService.findLoggableUser(nombre, password);
		// si no se encuentra usuario con esas credenciales
		if(user==null){
			
			modelo.addAttribute("err", "Usuario no encontrado");
			return "error";
		}
	
		//retornara la "web" con info del usuario
		return "saludo";
	}
	

	


}