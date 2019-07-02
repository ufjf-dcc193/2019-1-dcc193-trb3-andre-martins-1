package br.ufjf.dcc193.t3.documentos;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/etiquetas")
public class EtiquetaController
{
    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    EtiquetaRepository etiquetaRepo;

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

        List<Etiqueta> etiquetas = etiquetaRepo.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("etiqueta-list");
        mv.addObject("etiquetas", etiquetas);
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView create(HttpSession session)
    {
        Usuario usuario = getUsuario(session);
        if (usuario == null)
            return new ModelAndView("redirect:/usuarios/login");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("etiqueta-create");
        mv.addObject("etiqueta", new Etiqueta());
        return mv;
    }

    @PostMapping("/create")
    public String create(Etiqueta etiqueta, HttpSession session)
    {
        Usuario usuario = getUsuario(session);
        if (usuario == null)
            return "redirect:/usuarios/login";

        etiquetaRepo.save(etiqueta);

        return "redirect:/etiquetas";
    }

    // @RequestMapping("/{id}")
    // public ModelAndView read(@PathVariable Long id)
    // {
    //     ModelAndView mv = new ModelAndView();
    //     mv.setViewName("etiqueta-read");
    //     mv.addObject("etiqueta", etiquetaRepo.findById(id).get());

    //     return mv;
    // }

    // @GetMapping("/{id}/update")
    // public ModelAndView update(@PathVariable Long id)
    // {
    //     ModelAndView mv = new ModelAndView();
    //     mv.setViewName("etiqueta-update");
    //     Etiqueta etiqueta = etiquetaRepo.findById(id).get();
    //     mv.addObject("etiqueta", etiqueta);

    //     return mv;
    // }

    // @PostMapping("/{id}/update")
    // public String update(Etiqueta etiqueta)
    // {
    //     etiquetaRepo.save(etiqueta);

    //     return "redirect:/etiquetas/{id}";
    // }

    // @RequestMapping("/{id}/delete")
    // public String delete(@PathVariable Long id)
    // {
	// 	etiquetaRepo.deleteById(id);

    //     return "redirect:/etiquetas";
    // }

    // @GetMapping("/login")
    // public String login()
    // {
    //     return "login";
    // }

    // @PostMapping("/login")
    // public String login(@RequestParam("email") String email, @RequestParam("senha") String senha, HttpSession session)
    // {
    //     String destination = "/";

    //     Etiqueta etiqueta = etiquetaRepo.findByEmail(email);
    //     if (etiqueta == null || !etiqueta.checkAccess(senha))
    //     {
    //         // ToDo(andre:2019-06-16): Retornar uma mensagem informando que ocorreu um erro
    //         return "redirect:/etiqueta/login";
    //     }

    //     session.setAttribute("userId", etiqueta.getId());
    //     return "redirect:" + destination;
    // }

    // @RequestMapping("/logout")
    // public String logout(HttpSession session)
    // {
    //     session.removeAttribute("userId");
    //     return "redirect:/";
    // }
}