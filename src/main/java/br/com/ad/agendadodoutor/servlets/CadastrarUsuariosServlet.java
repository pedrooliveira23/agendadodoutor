package br.com.ad.agendadodoutor.servlets;

import br.com.ad.agendadodoutor.models.businessobjects.PapelBo;
import br.com.ad.agendadodoutor.models.businessobjects.UsuarioBo;
import br.com.ad.agendadodoutor.models.entidades.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/cadastrarusuarios")
public class CadastrarUsuariosServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listePapeis(request);

        String acaoParam = request.getParameter("acao");
        String acao = acaoParam == null ? "" : acaoParam;

        if (acao.equals("salvar")) {
            crieUsuario(request);
        }

        request.getRequestDispatcher("cadastrarusuarios.jsp").forward(request, response);
    }


    private List<String> obtenhaParametros(HttpServletRequest request) {
        String nomeParam = request.getParameter("nomedeusuario");
        String emailParam = request.getParameter("email");
        String senhaParam = request.getParameter("senha");
        String papelParam = request.getParameter("papel");

        String nome = nomeParam == null ? "" : nomeParam;
        String email = emailParam == null ? "" : emailParam;
        String senha = senhaParam == null ? "" : senhaParam;
        String papel = papelParam == null ? "" : papelParam;

        List<String> listaDeParametros = new ArrayList<String>();
        listaDeParametros.add(nome);
        listaDeParametros.add(email);
        listaDeParametros.add(senha);
        listaDeParametros.add(papel);

        return listaDeParametros;
    }

    private void crieUsuario(HttpServletRequest request) {
        UsuarioBo usuabiobo = new UsuarioBo();
        List<String> parametros = obtenhaParametros(request);
        Usuario usuario = new Usuario();
        usuario.setNomeDeUsuario(parametros.get(0));
        usuario.setEmail(parametros.get(1));
        usuario.setSenha(parametros.get(2));
        usuario.setPapel(parametros.get(3));

        usuabiobo.crieUsuario(usuario);
    }

    private void listePapeis(HttpServletRequest request) {
        PapelBo papelBo = new PapelBo();
        HttpSession sessao = request.getSession();
        sessao.setAttribute("listaDePapeis", papelBo.listePapeis());
    }
}
