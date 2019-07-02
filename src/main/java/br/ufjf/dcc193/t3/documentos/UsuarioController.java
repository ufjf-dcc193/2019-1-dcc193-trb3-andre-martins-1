package br.ufjf.dcc193.t3.documentos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usuario")
public class UsuarioController
{
    @Autowired
    UsuarioRepository usuarioRepo;
    
    @RequestMapping({"", "/", "/index"})
    public ModelAndView list()
    {
        List<Usuario> avaliadores = usuarioRepo.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("usuario-list");
        mv.addObject("usuarios", avaliadores);
        return mv;
    }
}