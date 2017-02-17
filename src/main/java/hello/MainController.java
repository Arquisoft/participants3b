package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

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

	@RequestMapping("/log")
	public String log() {
		return "login";
	}

	@RequestMapping(value = "/citizen", 
			method = RequestMethod.POST)
	public String getParticipantInfo(Model modelo,@RequestBody String nombre, @RequestBody String password) {
		modelo.addAttribute("nombre", nombre);
		return "saludo";
	}
}