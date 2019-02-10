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
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@WebServlet(value = "/cadastrarusuarios")
public class CadastrarUsuariosServlet extends HttpServlet {

    private String acao;
    private String nomeDeUsuario;
    private String email;
    private String senha;
    private String papel;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listePapeis(request);
        carregueParametros(request);

        if (acao.equals("salvar")) {
            crieUsuario(request);
            limpeParametros(request);
        } else if (acao.equals("limpar")) {
            limpeParametros(request);
            atualize(request, response);
        } else if(acao.equals("voltar")){
            request.getRequestDispatcher("listagemdeusuarios.jsp").forward(request, response);
        } else {
            atualize(request, response);
        }
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cadastrarusuarios.jsp").forward(request, response);
    }

    private void limpeParametros(HttpServletRequest request) {
        acao = "";
        nomeDeUsuario = "";
        email = "";
        senha = "";
        papel = "";
    }

    private void carregueParametros(HttpServletRequest request) {
        acao = request.getParameter("acao") == null ? "" : request.getParameter("acao");
        nomeDeUsuario = request.getParameter("nomedeusuario") == null ? "" : request.getParameter("nomedeusuario");
        email = request.getParameter("email") == null ? "" : request.getParameter("email");
        senha = request.getParameter("senha") == null ? "" : request.getParameter("senha");
        papel = request.getParameter("papel") == null ? "" : request.getParameter("papel");
    }

    private void crieUsuario(HttpServletRequest request) {
        UsuarioBo usuariobo = new UsuarioBo();
        Usuario usuario = new Usuario();
        usuario.setNomeDeUsuario(nomeDeUsuario);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setPapel(papel);
        usuariobo.crieUsuario(usuario);
    }

    private void listePapeis(HttpServletRequest request) {
        PapelBo papelBo = new PapelBo();
        HttpSession sessao = request.getSession();
        sessao.setAttribute("listaDePapeis", papelBo.listePapeis());
    }
}
