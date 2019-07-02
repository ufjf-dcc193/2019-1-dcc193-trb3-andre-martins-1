package br.ufjf.dcc193.t3.documentos;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController
{
    @Autowired
    UsuarioRepository usuarioRepo;

    @RequestMapping({"", "/", "/index"})
    public ModelAndView list()
    {
        List<Usuario> usuarios = usuarioRepo.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("usuario-list");
        mv.addObject("usuarios", usuarios);
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView create()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("usuario-create");
        mv.addObject("usuario", new Usuario());
        return mv;
    }

    @PostMapping("/create")
    public String create(Usuario usuario)
    {
        usuarioRepo.save(usuario);

        return "redirect:/usuarios";
    }

    @RequestMapping("/{id}")
    public ModelAndView read(@PathVariable Long id)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("usuario-read");
        mv.addObject("usuario", usuarioRepo.findById(id).get());

        return mv;
    }

    @GetMapping("/{id}/update")
    public ModelAndView update(@PathVariable Long id)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("usuario-update");
        Usuario usuario = usuarioRepo.findById(id).get();
        mv.addObject("usuario", usuario);

        return mv;
    }

    @PostMapping("/{id}/update")
    public String update(Usuario usuario)
    {
        usuarioRepo.save(usuario);

        return "redirect:/usuarios/{id}";
    }

    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable Long id)
    {
		usuarioRepo.deleteById(id);

        return "redirect:/usuarios";
    }

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("senha") String senha, HttpSession session)
    {
        String destination = "/";

        Usuario usuario = usuarioRepo.findByEmail(email);
        if (usuario == null || !usuario.checkAccess(senha))
        {
            // ToDo(andre:2019-06-16): Retornar uma mensagem informando que ocorreu um erro
            return "redirect:/usuario/login";
        }

        session.setAttribute("userId", usuario.getId());
        return "redirect:" + destination;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session)
    {
        session.removeAttribute("userId");
        return "redirect:/";
    }
}