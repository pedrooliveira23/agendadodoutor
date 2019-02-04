package br.com.ad.agendadodoutor.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/logout")
public class LogoutServlet extends HttpServlet {

    protected void service(
            HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {

        //Referência para a sessão.
        HttpSession sessaolog = req.getSession();
        //Remove todos os objetos da sessão e a invalida.
        sessaolog.invalidate();

        resp.sendRedirect("login");
    }

}
