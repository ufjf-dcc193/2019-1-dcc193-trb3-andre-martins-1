package br.ufjf.dcc193.t3.documentos;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/itens/{id}/anotacoes")
public class AnotacaoItemController
{
    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    AnotacaoRepository anotacaoRepo;

    @Autowired
    ItemRepository itemRepo;

    public Usuario getUsuario(HttpSession session)
    {
        Object id = session.getAttribute("userId");

        if (id != null)
        {
            return usuarioRepo.findById((Long)id).get();
        }
        else
        {
            return null;
        }
    }

    @RequestMapping({"", "/", "/index"})
    public ModelAndView list(@PathVariable Long id, HttpSession session)
    {
        Usuario usuario = getUsuario(session);
        if (usuario == null)
            return new ModelAndView("redirect:/usuarios/login");

        Item item = itemRepo.findById(id).get();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("anotacao-item-list");
        mv.addObject("anotacoes", item.getAnotacoes());
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView create(@PathVariable Long id, HttpSession session)
    {
        Usuario usuario = getUsuario(session);
        if (usuario == null)
            return new ModelAndView("redirect:/usuarios/login");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("anotacao-item-create");
        mv.addObject("anotacao", new Anotacao());
        return mv;
    }

    @PostMapping("/create")
    public String create(@PathVariable Long id, Anotacao anotacao, HttpSession session)
    {
        Usuario usuario = getUsuario(session);
        if (usuario == null)
            return "redirect:/usuarios/login";

        Item item = itemRepo.findById(id).get();
        anotacao.setItem(item);
        anotacao.setCriador(usuario);
        anotacaoRepo.save(anotacao);

        return "redirect:/itens/{id}/anotacoes";
    }

    @RequestMapping("/{aid}")
    public ModelAndView read(@PathVariable Long id, @PathVariable Long aid, HttpSession session)
    {
        Usuario usuario = getUsuario(session);
        if (usuario == null)
            return new ModelAndView("redirect:/usuarios/login");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("anotacao-item-read");
        mv.addObject("anotacao", anotacaoRepo.findById(aid).get());

        return mv;
    }

    // @GetMapping("/{id}/update")
    // public ModelAndView update(@PathVariable Long id, HttpSession session)
    // {
    //     Usuario usuario = getUsuario(session);
    //     if (usuario == null)
    //         return new ModelAndView("redirect:/usuarios/login");

    //     ModelAndView mv = new ModelAndView();
    //     mv.setViewName("anotacao-update");
    //     Anotacao anotacao = anotacaoRepo.findById(id).get();
    //     mv.addObject("anotacao", anotacao);

    //     return mv;
    // }

    // @PostMapping("/{id}/update")
    // public String update(Anotacao anotacao, HttpSession session)
    // {
    //     Usuario usuario = getUsuario(session);
    //     if (usuario == null)
    //         return "redirect:/usuarios/login";

    //     Anotacao oldAnotacao = anotacaoRepo.findById(anotacao.getId()).get();
    //     oldAnotacao.setTitulo(anotacao.getTitulo());

    //     anotacaoRepo.save(oldAnotacao);

    //     return "redirect:/anotacoes/{id}";
    // }

    // @RequestMapping("/{id}/delete")
    // public String delete(@PathVariable Long id, HttpSession session)
    // {
    //     Usuario usuario = getUsuario(session);
    //     if (usuario == null)
    //         return "redirect:/usuarios/login";

	// 	anotacaoRepo.deleteById(id);

    //     return "redirect:/anotacoes";
    // }
}