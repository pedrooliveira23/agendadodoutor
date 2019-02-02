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
    private HttpSession sessao;
    private PapelBo papelBo;

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        listePapeis(request);
            request.getRequestDispatcher("cadastrarusuarios.jsp").forward(request, response);
    }

    private void listePapeis(HttpServletRequest request) {
        papelBo = new PapelBo();
        sessao = request.getSession();
        sessao.setAttribute("listaPapeis",papelBo.listePapeis());
    }
}
