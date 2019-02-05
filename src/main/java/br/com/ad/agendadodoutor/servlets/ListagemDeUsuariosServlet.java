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
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        listeUsuarios(request);

        request.getRequestDispatcher("listagemdeusuarios.jsp").forward(request, response);
    }

    private void listeUsuarios(HttpServletRequest request) {
        UsuarioBo usuarioBo = new UsuarioBo();
        HttpSession session = request.getSession();
        session.setAttribute("listaDeUsuarios", usuarioBo.obtenhaUsuarios());
    }
}
