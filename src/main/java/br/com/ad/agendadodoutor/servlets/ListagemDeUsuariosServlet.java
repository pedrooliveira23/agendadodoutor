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

@WebServlet(value = "/listagemdeusuarios")
public class ListagemDeUsuariosServlet extends HttpServlet {
    private UsuarioBo usuarioBo;
    private Usuario usuarioAtual;
    private String acao;
    private String pesquisar;
    private String editarUsuario;
    private String removerUsuario;
    private String nomeDeUsuario;
    private String email;
    private String senha;
    private String papel;
    HttpSession sessao;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        usuarioBo = new UsuarioBo();
        sessao = request.getSession();
        carregueParametros(request);

        if (!pesquisar.equals("")) {
            pesquiseUsuarios(request, pesquisar);
            limpeParametros();
            atualize(request, response);
        } else if (acao.equals("novo")) {
            limpeParametros();
            vaParaCadastrarUsuarios(request, response);
        } else if (acao.equals("salvar")) {
            boolean editandoUsuario = sessao.getAttribute("editarUsuario") != null;
            if (!editandoUsuario) {
                crieUsuario();
            } else {
                editeUsuario();
                sessao.removeAttribute("editarUsuario");
            }
            limpeParametros();
            listeUsuarios(request);
            atualize(request, response);
        } else if (!editarUsuario.equals("")) {
            vaParaCadastrarUsuarios(request, response);
        } else if (!removerUsuario.equals("")) {
            removaUsuario(removerUsuario);
            limpeParametros();
            listeUsuarios(request);
            atualize(request, response);
        } else {
            atualize(request, response);
        }
    }

    private void removaUsuario(String removerUsuario) {
        usuarioBo.removaUsuario(usuarioBo.obtenhaUsuario(removerUsuario));
    }

    private void editeUsuario() {
        Usuario usuario = setUsuario();
        usuarioBo.editeUsuario(usuarioAtual, usuario);
    }

    private Usuario setUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNomeDeUsuario(nomeDeUsuario);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setPapel(papel);
        return usuario;
    }

    private void limpeParametros() {
        acao = "";
        pesquisar = "";
    }

    private void vaParaCadastrarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cadastrarusuarios.jsp").forward(request, response);
    }

    private void carregueParametros(HttpServletRequest request) {
        listeUsuarios(request);
        acao = request.getParameter("acao") == null ? "" : request.getParameter("acao");
        pesquisar = request.getParameter("pesquisar") == null ? "" : request.getParameter("pesquisar");
        editarUsuario = request.getParameter("editarUsuario") == null ? "" : request.getParameter("editarUsuario");
        removerUsuario = request.getParameter("removerUsuario") == null ? "" : request.getParameter("removerUsuario");

        if (editarUsuario.equals("")) {
            nomeDeUsuario = request.getParameter("nomedeusuario") == null ? "" : request.getParameter("nomedeusuario");
            email = request.getParameter("email") == null ? "" : request.getParameter("email");
            senha = request.getParameter("senha") == null ? "" : request.getParameter("senha");
            papel = request.getParameter("papel") == null ? "" : request.getParameter("papel");
        } else {
            usuarioBo = new UsuarioBo();
            Usuario usuario = usuarioBo.obtenhaUsuario(editarUsuario);
            nomeDeUsuario = usuario.getNomeDeUsuario();
            email = usuario.getEmail();
            senha = usuario.getSenha();
            papel = usuario.getPapel();
            usuarioAtual = usuario;
        }
        setAtributos(request);
    }


    private void setAtributos(HttpServletRequest request) {
        PapelBo papelBo = new PapelBo();
        request.setAttribute("nomeDeUsuario", nomeDeUsuario);
        request.setAttribute("email", email);
        request.setAttribute("senha", senha);
        request.setAttribute("papel", papel);
        request.setAttribute("papeis", papelBo.listePapeis());

        if(!editarUsuario.equals("")) {
            sessao.setAttribute("editarUsuario", editarUsuario);
        }
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

    private void crieUsuario() {
        UsuarioBo usuarioBo = new UsuarioBo();
        Usuario usuario = setUsuario();
        usuarioBo.crieUsuario(usuario);
    }
}
