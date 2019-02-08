package br.com.ad.agendadodoutor.servlets;

import br.com.ad.agendadodoutor.models.businessobjects.PapelBo;
import br.com.ad.agendadodoutor.models.businessobjects.UsuarioBo;
import br.com.ad.agendadodoutor.models.entities.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(value = "/cadastrarusuarios")
public class CadastrarUsuariosServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listePapeis(request);

        if (existeParametros(request)) {
            if (obtenhaParametros(request).get(0).toString().equals("salvar")) {
                crieUsuario(request);
            } else if (obtenhaParametros(request).get(0).toString().equals("limpar")) {
                limparParametros(request);
            }
        }

        request.getRequestDispatcher("cadastrarusuarios.jsp").forward(request, response);
    }

    private void limparParametros(HttpServletRequest request) {

    }

    private Map obtenhaParametros(HttpServletRequest request) {
        Map parametros = request.getParameterMap();
        HttpSession session = request.getSession();
        session.setAttribute("usuarioValido","true");
        return parametros;
    }

    private boolean existeParametros(HttpServletRequest request) {
        return request.getParameterMap().size() > 0 ? true : false;
    }

    private void crieUsuario(HttpServletRequest request) {
        if (existeParametros(request)) {
            UsuarioBo usuariobo = new UsuarioBo();
            Usuario usuario = new Usuario();
            usuario.setNomeDeUsuario(obtenhaParametros(request).get(1).toString());
            usuario.setEmail(obtenhaParametros(request).get(2).toString());
            usuario.setSenha(obtenhaParametros(request).get(3).toString());
            usuario.setPapel(obtenhaParametros(request).get(4).toString());
            usuariobo.crieUsuario(usuario);
        }
    }

    private void listePapeis(HttpServletRequest request) {
        PapelBo papelBo = new PapelBo();
        HttpSession sessao = request.getSession();
        sessao.setAttribute("listaDePapeis", papelBo.listePapeis());
    }
}
