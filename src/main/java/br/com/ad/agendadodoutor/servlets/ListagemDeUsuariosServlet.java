package br.com.ad.agendadodoutor.servlets;

import br.com.ad.agendadodoutor.models.businessobjects.UsuarioBo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/listagemdeusuarios")
public class ListagemDeUsuariosServlet extends HttpServlet {
    private UsuarioBo usuarioBo;
    private HttpSession session;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        usuarioBo = new UsuarioBo();
        session = request.getSession();

        listeUsuarios(request);

        String pesquisar = request.getParameter("pesquisar") == null ? "" : request.getParameter("pesquisar");

        if (!pesquisar.equals("")) {
            pesquiseUsuarios(request, pesquisar);
            atualize(request, response);
        } else {
            atualize(request, response);
        }
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("listagemdeusuarios.jsp").forward(request, response);
    }

    private void pesquiseUsuarios(HttpServletRequest request, String sentenca) {
        session.setAttribute("listaDeUsuarios", usuarioBo.pesquiseUsuarios(sentenca));
    }

    private void listeUsuarios(HttpServletRequest request) {
        session.setAttribute("listaDeUsuarios", usuarioBo.obtenhaUsuarios());
    }
}
