package br.com.cadastros.cadastrausuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class CadastraUsuarioApplication {
	@GetMapping
	public String getHomeTeste(){
		return "Cadastra Usuário - API Home";
	}
	public static void main(String[] args) {
		SpringApplication.run(CadastraUsuarioApplication.class, args);
	}
}
