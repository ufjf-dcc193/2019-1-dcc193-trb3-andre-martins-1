package br.ufjf.dcc193.t3.documentos;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/itens/{id}/vinculos/{vid}/anotacoes")
public class AnotacaoVinculoController
{
    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    AnotacaoRepository anotacaoRepo;

    @Autowired
    VinculoRepository vinculoRepo;

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
    public ModelAndView list(@PathVariable Long id, @PathVariable Long vid, HttpSession session)
    {
        Usuario usuario = getUsuario(session);
        if (usuario == null)
            return new ModelAndView("redirect:/usuarios/login");

        Vinculo vinculo = vinculoRepo.findById(vid).get();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("anotacao-vinculo-list");
        mv.addObject("anotacoes", vinculo.getAnotacoes());
        return mv;
    }

    @GetMapping("/create")
    public ModelAndView create(@PathVariable Long id, @PathVariable Long vid, HttpSession session)
    {
        Usuario usuario = getUsuario(session);
        if (usuario == null)
            return new ModelAndView("redirect:/usuarios/login");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("anotacao-vinculo-create");
        mv.addObject("anotacao", new Anotacao());
        return mv;
    }

    @PostMapping("/create")
    public String create(@PathVariable Long id, @PathVariable Long vid, Anotacao anotacao, HttpSession session)
    {
        Usuario usuario = getUsuario(session);
        if (usuario == null)
            return "redirect:/usuarios/login";

        Vinculo vinculo = vinculoRepo.findById(vid).get();
        anotacao.setVinculo(vinculo);
        anotacao.setCriador(usuario);
        anotacaoRepo.save(anotacao);

        return "redirect:/itens/{id}/vinculos/{vid}/anotacoes";
    }

    @RequestMapping("/{aid}")
    public ModelAndView read(@PathVariable Long id, @PathVariable Long vid, @PathVariable Long aid, HttpSession session)
    {
        Usuario usuario = getUsuario(session);
        if (usuario == null)
            return new ModelAndView("redirect:/usuarios/login");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("anotacao-vinculo-read");
        mv.addObject("anotacao", anotacaoRepo.findById(aid).get());

        return mv;
    }

    @GetMapping("/{aid}/update")
    public ModelAndView update(@PathVariable Long id, @PathVariable Long vid, @PathVariable Long aid, HttpSession session)
    {
        Usuario usuario = getUsuario(session);
        if (usuario == null)
            return new ModelAndView("redirect:/usuarios/login");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("anotacao-vinculo-update");
        Anotacao anotacao = anotacaoRepo.findById(aid).get();
        mv.addObject("anotacao", anotacao);

        return mv;
    }

    @PostMapping("/{aid}/update")
    public String update(Anotacao anotacao, HttpSession session)
    {
        Usuario usuario = getUsuario(session);
        if (usuario == null)
            return "redirect:/usuarios/login";

        Anotacao oldAnotacao = anotacaoRepo.findById(anotacao.getId()).get();
        oldAnotacao.setTitulo(anotacao.getTitulo());
        oldAnotacao.setDescricao(anotacao.getDescricao());
        oldAnotacao.setUrl(anotacao.getUrl());
        oldAnotacao.setDataAlteracao(new Date(System.currentTimeMillis()));

        anotacaoRepo.save(oldAnotacao);

        return "redirect:/itens/{id}/vinculos/{vid}/anotacoes/{aid}";
    }

    @RequestMapping("/{aid}/delete")
    public String delete(@PathVariable Long id, @PathVariable Long vid, @PathVariable Long aid, HttpSession session)
    {
        Usuario usuario = getUsuario(session);
        if (usuario == null)
            return "redirect:/usuarios/login";

		anotacaoRepo.deleteById(aid);

        return "redirect:/itens/{id}/vinculos/{vid}/anotacoes";
    }
}