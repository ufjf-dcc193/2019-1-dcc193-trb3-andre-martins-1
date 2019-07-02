package br.ufjf.dcc193.t3.documentos;

import org.springframework.boot.SpringApplication;
// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication
{
	public static void main(String[] args)
	{
		// SpringApplication.run(DemoApplication.class, args);

		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		UsuarioRepository usuarioRepo = ctx.getBean(UsuarioRepository.class);

		Usuario usuario = new Usuario("Nome", "Descrição", "a", "a@a");
		usuarioRepo.save(usuario);
	}
}
