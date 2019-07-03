package br.ufjf.dcc193.t3.documentos;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/itens")
public class ItemController
{
    @Autowired
    UsuarioRepository usuarioRepo;

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
    public ModelAndView list(HttpSession session)
    {
        Usuario usuario = getUsuario(session);
        if (usuario == null)
            return new ModelAndView("redirect:/usuarios/login");

        List<Item> itens = itemRepo.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("item-list");
        mv.addObject("itens", itens);
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView create(HttpSession session)
    {
        Usuario usuario = getUsuario(session);
        if (usuario == null)
            return new ModelAndView("redirect:/usuarios/login");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("item-create");
        mv.addObject("item", new Item());
        return mv;
    }

    @PostMapping("/create")
    public String create(Item item, HttpSession session)
    {
        Usuario usuario = getUsuario(session);
        if (usuario == null)
            return "redirect:/usuarios/login";

        itemRepo.save(item);

        return "redirect:/itens";
    }

    @RequestMapping("/{id}")
    public ModelAndView read(@PathVariable Long id, HttpSession session)
    {
        Usuario usuario = getUsuario(session);
        if (usuario == null)
            return new ModelAndView("redirect:/usuarios/login");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("item-read");
        mv.addObject("item", itemRepo.findById(id).get());

        return mv;
    }

    // @GetMapping("/{id}/update")
    // public ModelAndView update(@PathVariable Long id, HttpSession session)
    // {
    //     Usuario usuario = getUsuario(session);
    //     if (usuario == null)
    //         return new ModelAndView("redirect:/usuarios/login");

    //     ModelAndView mv = new ModelAndView();
    //     mv.setViewName("item-update");
    //     Item item = itemRepo.findById(id).get();
    //     mv.addObject("item", item);

    //     return mv;
    // }

    // @PostMapping("/{id}/update")
    // public String update(Item item, HttpSession session)
    // {
    //     Usuario usuario = getUsuario(session);
    //     if (usuario == null)
    //         return "redirect:/usuarios/login";

    //     itemRepo.save(item);

    //     return "redirect:/itens/{id}";
    // }

    // @RequestMapping("/{id}/delete")
    // public String delete(@PathVariable Long id, HttpSession session)
    // {
    //     Usuario usuario = getUsuario(session);
    //     if (usuario == null)
    //         return "redirect:/usuarios/login";

	// 	itemRepo.deleteById(id);

    //     return "redirect:/itens";
    // }
}