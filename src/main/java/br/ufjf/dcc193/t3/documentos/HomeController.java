package br.ufjf.dcc193.t3.documentos;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
    @Autowired
    UsuarioRepository usuarioRepo;

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
    public ModelAndView home(HttpSession session)
    {
        Usuario usuario = getUsuario(session);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("usuario", usuario);
        return mv;
    }
}