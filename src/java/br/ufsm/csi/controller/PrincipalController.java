package br.ufsm.csi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrincipalController {

    @RequestMapping("principal")
    public String principal() { return "principal/principal"; }

    // ROTAS
    @RequestMapping("principal/home")
    public String home() { return "principal/home"; }

    @RequestMapping("principal/produto")
    public String produto() { return "principal/produto/produto"; }

    @RequestMapping("principal/estoque")
    public String estoque() { return "principal/estoque/estoque"; }

    @RequestMapping("principal/venda")
    public String venda() { return "principal/venda/venda"; }

}
