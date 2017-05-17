package br.ufsm.csi.controller;

import br.ufsm.csi.DAO.LoginDAO;
import br.ufsm.csi.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("login")
    public String login() { return "login/login"; }

    @RequestMapping("autenticarUsuario")
    public String autenticarUsuario(Usuario usuario, HttpSession session, RedirectAttributes redirect) {

        Usuario usuarioAutenticado = new LoginDAO().autenticarUsuario(usuario);

        if(usuarioAutenticado != null) {
            session.setAttribute("usuarioLogado", usuarioAutenticado);
            return "redirect:principal";
        } else {
            redirect.addFlashAttribute("ERRO_LOGIN", "Email ou senha invalido(s).");
            return "redirect:login";
        }
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }
}
