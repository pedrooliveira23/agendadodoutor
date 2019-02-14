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
    private String acao;
    private String pesquisar;
    private String editarUsuario;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        usuarioBo = new UsuarioBo();

        carregueParametros(request);
        listeUsuarios(request);

        if (!pesquisar.equals("")) {
            pesquiseUsuarios(request, pesquisar);
            limpeParametros();
            atualize(request, response);
        } else if (acao.equals("novo")) {
            limpeParametros();
            vaParaCadastrarUsuarios(request, response);
        } else if (!editarUsuario.equals("")) {
            request.setAttribute("usuarioParaEditar", editarUsuario);
            vaParaCadastrarUsuarios(request, response);
        } else {
            atualize(request, response);
        }
    }

    private void limpeParametros() {
        acao = "";
        pesquisar = "";
    }

    private void vaParaCadastrarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cadastrarusuarios.jsp").forward(request, response);
    }

    private void carregueParametros(HttpServletRequest request) {
        acao = request.getParameter("acao") == null ? "" : request.getParameter("acao");
        pesquisar = request.getParameter("pesquisar") == null ? "" : request.getParameter("pesquisar");
        editarUsuario = request.getParameter("editarUsuario") == null ? "" : request.getParameter("editarUsuario");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("listagemdeusuarios.jsp").forward(request, response);
    }

    private void pesquiseUsuarios(HttpServletRequest request, String sentenca) {
        request.setAttribute("listaDeUsuarios", usuarioBo.pesquiseUsuarios(sentenca));
    }

    private void listeUsuarios(HttpServletRequest request) {
        request.setAttribute("listaDeUsuarios", usuarioBo.obtenhaUsuarios());
    }
}
