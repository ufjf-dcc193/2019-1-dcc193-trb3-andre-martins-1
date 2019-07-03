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
		EtiquetaRepository etiquetaRepo = ctx.getBean(EtiquetaRepository.class);
		ItemRepository itemRepo = ctx.getBean(ItemRepository.class);

		Usuario usuario = new Usuario("Nome", "Descrição", "a", "a@a");
		usuarioRepo.save(usuario);

		Etiqueta etiqueta1 = new Etiqueta("Nome", "Descrição", "https://regrasdeetiqueta.com");
		etiquetaRepo.save(etiqueta1);
		Etiqueta etiqueta2 = new Etiqueta("Label", "Description", "https://labelrules.com");
		etiquetaRepo.save(etiqueta2);
		Etiqueta etiqueta3 = new Etiqueta("Et.", "Desc.", "https://re.et.com");
		etiquetaRepo.save(etiqueta3);

		Item item = new Item("Título");
		itemRepo.save(item);

		item.addEtiqueta(etiqueta1);
		itemRepo.save(item);
	}
}
