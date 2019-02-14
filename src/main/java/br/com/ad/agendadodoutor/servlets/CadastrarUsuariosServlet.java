package br.com.ad.agendadodoutor.servlets;

import br.com.ad.agendadodoutor.models.businessobjects.PapelBo;
import br.com.ad.agendadodoutor.models.businessobjects.UsuarioBo;
import br.com.ad.agendadodoutor.models.entities.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/cadastrarusuarios")
public class CadastrarUsuariosServlet extends HttpServlet {
    private UsuarioBo usuarioBo;
    private String acao;
    private String nomeDeUsuario;
    private String email;
    private String senha;
    private String papel;
    private String usuarioParaEditar;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        carregueParametros(request);
        carregueEditar();
        listePapeis(request);

        if (acao.equals("salvar")) {
            crieUsuario();
            limpeParametros();
            atualize(request, response);
        } else if (acao.equals("limpar")) {
            limpeParametros();
            atualize(request, response);
        } else if (acao.equals("voltar")) {
            request.getRequestDispatcher("listagemdeusuarios.jsp").forward(request, response);
        } else {
            atualize(request, response);
        }
    }

    private void carregueEditar() {
        if (!usuarioParaEditar.equals("")) {
            usuarioBo = new UsuarioBo();
            Usuario usuario = usuarioBo.obtenhaUsuario(usuarioParaEditar);
            nomeDeUsuario = usuario.getNomeDeUsuario();
            email = usuario.getEmail();
            senha = usuario.getSenha();
            papel = usuario.getPapel();
        }
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cadastrarusuarios.jsp").forward(request, response);
    }

    private void limpeParametros() {
        acao = "";
        nomeDeUsuario = "";
        email = "";
        senha = "";
        papel = "";
        usuarioParaEditar = "";
    }

    private void carregueParametros(HttpServletRequest request) {
        acao = request.getParameter("acao") == null ? "" : request.getParameter("acao");
        nomeDeUsuario = request.getParameter("nomedeusuario") == null ? "" : request.getParameter("nomedeusuario");
        email = request.getParameter("email") == null ? "" : request.getParameter("email");
        senha = request.getParameter("senha") == null ? "" : request.getParameter("senha");
        papel = request.getParameter("papel") == null ? "" : request.getParameter("papel");
        usuarioParaEditar = request.getAttribute("usuarioParaEditar").toString() == null ? "" : request.getAttribute("usuarioParaEditar").toString();
    }

    private void crieUsuario() {
        usuarioBo = new UsuarioBo();
        Usuario usuario = new Usuario();
        usuario.setNomeDeUsuario(nomeDeUsuario);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setPapel(papel);
        usuarioBo.crieUsuario(usuario);
    }

    private void listePapeis(HttpServletRequest request) {
        PapelBo papelBo = new PapelBo();
        request.setAttribute("papeis", papelBo.listePapeis());
    }
}
