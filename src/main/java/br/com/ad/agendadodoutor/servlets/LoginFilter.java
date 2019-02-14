package br.com.ad.agendadodoutor.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("*")
public class LoginFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (req.getRequestURI().endsWith("/login")) {
            chain.doFilter(request, response);
        } else {
            HttpSession sessao = req.getSession();
            try {
                if (sessao.getAttribute("usuarioValido").equals("false")) {
                    res.sendRedirect("login");
                } else {
                    chain.doFilter(request, response);
                }
            } catch (NullPointerException e) {
                res.sendRedirect("login");
            }
        }
    }

    public void destroy() {
    }

}