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
            if (obtenhaParametros(request).get(0)[0].equals("salvar")) {
                crieUsuario(request);
            } else if (obtenhaParametros(request).get(0)[0].equals("limpar")) {
                limparParametros(request);
            }
        }

        request.getRequestDispatcher("cadastrarusuarios.jsp").forward(request, response);
    }

    private void limparParametros(HttpServletRequest request) {

    }

    private Map<String, String[]> obtenhaParametros(HttpServletRequest request) {
        Map<String, String[]> parametros = request.getParameterMap();
        return parametros;
    }

    private boolean existeParametros(HttpServletRequest request) {
        return request.getParameterMap().size() > 0 ? true : false;
    }

    private void crieUsuario(HttpServletRequest request) {
        if (existeParametros(request)) {
            UsuarioBo usuariobo = new UsuarioBo();
            Usuario usuario = new Usuario();
            usuario.setNomeDeUsuario(obtenhaParametros(request).get(1)[0]);
            usuario.setEmail(obtenhaParametros(request).get(2)[0]);
            usuario.setSenha(obtenhaParametros(request).get(3)[0]);
            usuario.setPapel(obtenhaParametros(request).get(4)[0]);
            usuariobo.crieUsuario(usuario);
        }
    }

    private void listePapeis(HttpServletRequest request) {
        PapelBo papelBo = new PapelBo();
        HttpSession sessao = request.getSession();
        sessao.setAttribute("listaDePapeis", papelBo.listePapeis());
    }
}
