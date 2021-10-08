package co.edu.unbosque.ciclo3back.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.ciclo3back.Controller.LoginController;
import co.edu.unbosque.ciclo3back.model.Login;

@RestController
@RequestMapping("/")
public class LoginAPI {
	
	@Autowired
	private LoginController loginController;
	
	@PostMapping("/login")
	public String login(@RequestBody Login usuarios) {
		return loginController.verificarCredenciales(usuarios);
	}
}