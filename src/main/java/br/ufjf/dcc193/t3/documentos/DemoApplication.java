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
		AnotacaoRepository anotacaoRepo = ctx.getBean(AnotacaoRepository.class);

		Usuario usuario1 = new Usuario("André", "Eu", "a", "a@a");
		usuarioRepo.save(usuario1);

		Usuario usuario2 = new Usuario("Nome", "Descrição", "b", "b@b");
		usuarioRepo.save(usuario2);

		Etiqueta etiqueta1 = new Etiqueta("Nome", "Descrição", "https://regrasdeetiqueta.com");
		etiquetaRepo.save(etiqueta1);
		Etiqueta etiqueta2 = new Etiqueta("Label", "Description", "https://labelrules.com");
		etiquetaRepo.save(etiqueta2);
		Etiqueta etiqueta3 = new Etiqueta("Et.", "Desc.", "https://re.et.com");
		etiquetaRepo.save(etiqueta3);

		Item item1 = new Item("Título");
		itemRepo.save(item1);
		item1.addEtiqueta(etiqueta1);
		itemRepo.save(item1);

		Item item2 = new Item("Título");
		itemRepo.save(item2);
		item2.addEtiqueta(etiqueta1);
		itemRepo.save(item2);

		Anotacao anotacao = new Anotacao("Título", "Descrição", "https://anotacao.com");
		anotacao.setCriador(usuario1);
		anotacao.setItem(item1);
		anotacaoRepo.save(anotacao);
	}
}
