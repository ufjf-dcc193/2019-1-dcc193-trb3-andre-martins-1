package br.ufjf.dcc193.t3.documentos.documentos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("index")
    public String home() {
        return "index";
    }
}