package controller;

import java.sql.Date;

import model.UserInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.UserService;
import service.UserServiceImpl;
import util.Encriptador;
import util.ParticipantsException;
import util.VerificadorEmail;

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
		model.addAttribute("user", new UserInfo("testUser", Encriptador.encriptar("ss"), "email@test.com", "123T", 
				"TestName", "TestApp",fecha , "C/test", "España"));
	
		return "infoUsuario";
	}

	
	@RequestMapping(value = "/login", 
			method = RequestMethod.POST)
	public String getParticipantInfo(Model modelo,@RequestParam String nombre, @RequestParam String password) {
	
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
	
	@RequestMapping(value = "/volverAinfo", 
			method = RequestMethod.GET)
	public String getParticipantInfo(Model modelo,@ModelAttribute("user") UserInfo usuario) {
		modelo.addAttribute("user", usuario);
		return "infoUsuario";
	}
	
	@RequestMapping(value = "/cambiarE")
	public String navegarCambiarEmail(Model modelo)
	{
		modelo.addAttribute("err", " ");
		return "cambiarEmail";
	}


	
	@RequestMapping(value = "/cambioEmail", 
			method = RequestMethod.POST)
	public String changeEmail(Model modelo,@ModelAttribute("user") UserInfo usuario, @RequestParam String password,
			@RequestParam String newEmail){
		userService = new UserServiceImpl();
		try {
			
			if(!password.equals(Encriptador.Desencriptar(usuario.getPassword()))){
				modelo.addAttribute("err", "Contraseña incorrecta");
				return "cambiarEmail";
			}
			if(!VerificadorEmail.validateEmail(newEmail)) {
				modelo.addAttribute("err", "Email incorrecto");
				return "cambiarEmail";
			}
			
			modelo.addAttribute("err", "");
			userService.changeEmail(usuario, newEmail);
			modelo.addAttribute("err","");
			modelo.addAttribute("user", usuario);
			modelo.addAttribute("success","Se ha actualizado la contraseña correctamente");
			return "exito";
	
		} catch (Exception e) {
			e.printStackTrace();
			modelo.addAttribute("err",e.getMessage());
			return "error";
		}
	}
	
	@RequestMapping(value = "/cambiar")
	public String navegarCambiarContrasena(Model modelo, @ModelAttribute("user") UserInfo usuario)
	{
		modelo.addAttribute("user",usuario);
		modelo.addAttribute("err", " ");
		return "cambiarPass";
	}

	
	@RequestMapping(value = "/cambio", 
			method = RequestMethod.POST)
	public String changePassword(Model modelo,@ModelAttribute("user") UserInfo usuario, @RequestParam String password,
			@RequestParam String newPassword1,@RequestParam String newPassword2){
		userService = new UserServiceImpl();
		try {
			
			if(!password.equals(Encriptador.Desencriptar(usuario.getPassword()))){
				modelo.addAttribute("err", "Contraseña incorrecta");
				return "cambiarPass";
			}
			if(newPassword1.length()<=0) {
				modelo.addAttribute("err", "Escriba la nueva contraseña");
				return "cambiarPass";
			}
			if(!newPassword1.equals(newPassword2)){
				modelo.addAttribute("err", "Las contraseñas deben coincidir");
				return "cambiarPass";
			}
			
			modelo.addAttribute("err", "");
			userService.changePassword(usuario, newPassword1);
			modelo.addAttribute("err","");
			modelo.addAttribute("user", usuario);
			modelo.addAttribute("success","Se ha actualizado la contraseña correctamente");
			return "exito";
	
		} catch (Exception e) {
			e.printStackTrace();
			modelo.addAttribute("err",e.getMessage());
			return "error";
		}
	}
	

	


}