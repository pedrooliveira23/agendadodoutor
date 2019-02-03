package br.com.ad.agendadodoutor.servlets;

import br.com.ad.agendadodoutor.models.businessobjects.PapelBo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "cadastrarusuarios", urlPatterns = {"/cadastrarusuarios"})
public class CadastrarUsuariosServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listePapeis(request);
        request.getRequestDispatcher("cadastrarusuarios.jsp").forward(request, response);
    }

    private void listePapeis(HttpServletRequest request) {
        PapelBo papelBo = new PapelBo();
        HttpSession sessao = request.getSession();
        request.setAttribute("listaPapeis", "Teste");
    }
}
