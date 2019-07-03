package br.ufjf.dcc193.t3.documentos;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/itens/{id}/vinculos")
public class VinculoController
{
    @Autowired
    UsuarioRepository usuarioRepo;

    @Autowired
    VinculoRepository vinculoRepo;

    @Autowired
    ItemRepository itemRepo;

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
    public ModelAndView list(@PathVariable Long id, HttpSession session)
    {
        Usuario usuario = getUsuario(session);
        if (usuario == null)
            return new ModelAndView("redirect:/usuarios/login");

        Item item = itemRepo.findById(id).get();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("vinculo-list");
        mv.addObject("vinculosOrigem", item.getVinculosOrigem());
        mv.addObject("vinculosDestino", item.getVinculosDestino());
        return mv;
    }

    // @GetMapping("/create")
    // public ModelAndView create(HttpSession session)
    // {
    //     Usuario usuario = getUsuario(session);
    //     if (usuario == null)
    //         return new ModelAndView("redirect:/usuarios/login");

    //     ModelAndView mv = new ModelAndView();
    //     mv.setViewName("vinculo-create");
    //     mv.addObject("vinculo", new Vinculo());
    //     return mv;
    // }

    // @PostMapping("/create")
    // public String create(Vinculo vinculo, HttpSession session)
    // {
    //     Usuario usuario = getUsuario(session);
    //     if (usuario == null)
    //         return "redirect:/usuarios/login";

    //     vinculoRepo.save(vinculo);

    //     return "redirect:/vinculos";
    // }

    // @RequestMapping("/{id}")
    // public ModelAndView read(@PathVariable Long id, HttpSession session)
    // {
    //     Usuario usuario = getUsuario(session);
    //     if (usuario == null)
    //         return new ModelAndView("redirect:/usuarios/login");

    //     ModelAndView mv = new ModelAndView();
    //     mv.setViewName("vinculo-read");
    //     mv.addObject("vinculo", vinculoRepo.findById(id).get());

    //     return mv;
    // }

    // @GetMapping("/{id}/update")
    // public ModelAndView update(@PathVariable Long id, HttpSession session)
    // {
    //     Usuario usuario = getUsuario(session);
    //     if (usuario == null)
    //         return new ModelAndView("redirect:/usuarios/login");

    //     ModelAndView mv = new ModelAndView();
    //     mv.setViewName("vinculo-update");
    //     Vinculo vinculo = vinculoRepo.findById(id).get();
    //     mv.addObject("vinculo", vinculo);

    //     return mv;
    // }

    // @PostMapping("/{id}/update")
    // public String update(Vinculo vinculo, HttpSession session)
    // {
    //     Usuario usuario = getUsuario(session);
    //     if (usuario == null)
    //         return "redirect:/usuarios/login";

    //     Vinculo oldVinculo = vinculoRepo.findById(vinculo.getId()).get();
    //     oldVinculo.setTitulo(vinculo.getTitulo());

    //     vinculoRepo.save(oldVinculo);

    //     return "redirect:/vinculos/{id}";
    // }

    // @RequestMapping("/{id}/delete")
    // public String delete(@PathVariable Long id, HttpSession session)
    // {
    //     Usuario usuario = getUsuario(session);
    //     if (usuario == null)
    //         return "redirect:/usuarios/login";

	// 	vinculoRepo.deleteById(id);

    //     return "redirect:/vinculos";
    // }

    // @RequestMapping("/{id}/etiquetas")
    // public ModelAndView etiquetas(@PathVariable Long id, HttpSession session)
    // {
    //     Usuario usuario = getUsuario(session);
    //     if (usuario == null)
    //         return new ModelAndView("redirect:/usuarios/login");

    //     ModelAndView mv = new ModelAndView();
    //     mv.setViewName("vinculo-etiquetas");
    //     Vinculo vinculo = vinculoRepo.findById(id).get();
    //     mv.addObject("vinculo", vinculo);
    //     List<Etiqueta> etiquetas = etiquetaRepo.findAll();
    //     mv.addObject("etiquetas", etiquetas);

    //     return mv;
    // }

    // @RequestMapping("/{id}/etiquetas/{eid}/add")
    // public String etiquetasAdd(@PathVariable Long id, @PathVariable Long eid, HttpSession session)
    // {
    //     Usuario usuario = getUsuario(session);
    //     if (usuario == null)
    //         return "redirect:/usuarios/login";

    //     Vinculo vinculo = vinculoRepo.findById(id).get();
    //     Etiqueta etiqueta = etiquetaRepo.findById(eid).get();
    //     vinculo.addEtiqueta(etiqueta);
    //     vinculoRepo.save(vinculo);

    //     return "redirect:/vinculos/{id}/etiquetas";
    // }

    // @RequestMapping("/{id}/etiquetas/{eid}/remove")
    // public String etiquetasRemove(@PathVariable Long id, @PathVariable Long eid, HttpSession session)
    // {
    //     Usuario usuario = getUsuario(session);
    //     if (usuario == null)
    //         return "redirect:/usuarios/login";

    //     Vinculo vinculo = vinculoRepo.findById(id).get();
    //     Etiqueta etiqueta = etiquetaRepo.findById(eid).get();
    //     vinculo.removeEtiqueta(etiqueta);
    //     vinculoRepo.save(vinculo);

    //     return "redirect:/vinculos/{id}/etiquetas";
    // }
}