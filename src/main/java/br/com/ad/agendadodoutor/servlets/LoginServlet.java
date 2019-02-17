package br.com.ad.agendadodoutor.servlets;

import br.com.ad.agendadodoutor.models.businessobjects.UsuarioBo;
import br.com.ad.agendadodoutor.models.entities.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value="/login")
public class LoginServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(valideLogin(request)) {
            response.sendRedirect("paineldecontrole");
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    public boolean valideLogin(HttpServletRequest request) {
        UsuarioBo usuariobo = new UsuarioBo();
        HttpSession sessao = request.getSession();
        boolean usuarioValido;

        String nomeDeUsuarioParam = request.getParameter("nomedeusuario");
        String senhaParam = request.getParameter("senha");
        String nomeDeUsuario = nomeDeUsuarioParam == null ? "" : nomeDeUsuarioParam;
        String senha = senhaParam == null ? "" : senhaParam;

        try {
            Usuario usuario = usuariobo.obtenhaUsuario(nomeDeUsuario);

            if (senha.equals(usuario.getSenha())) {
                sessao.setAttribute("usuarioValido", "true");
                sessao.setAttribute("nomeCompleto", usuario.getNomeCompleto());
                sessao.setAttribute("nomeDeUsuario", usuario.getNomeDeUsuario());
                usuarioValido = true;
            } else {
                sessao.setAttribute("usuarioValido", "false");
                usuarioValido = false;
            }
        } catch (NullPointerException e) {
            sessao.setAttribute("usuarioValido", "false");
            usuarioValido = false;
        }

        return  usuarioValido;
    }
}
