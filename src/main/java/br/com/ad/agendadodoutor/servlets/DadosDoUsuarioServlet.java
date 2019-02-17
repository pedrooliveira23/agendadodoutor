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

@WebServlet(value = "/dadosdousuario")
public class DadosDoUsuarioServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setAtributos(request);
        request.getRequestDispatcher("dadosdousuario.jsp").forward(request, response);
    }

    private void setAtributos(HttpServletRequest request) {
        UsuarioBo usuarioBo = new UsuarioBo();
        PapelBo papelBo = new PapelBo();
        HttpSession sessao = request.getSession();
        Usuario usuario = usuarioBo.obtenhaUsuario(sessao.getAttribute("nomeDeUsuario").toString());

        request.setAttribute("nomeCompleto", usuario.getNomeCompleto());
        request.setAttribute("nomeDeUsuario", usuario.getNomeDeUsuario());
        request.setAttribute("email", usuario.getEmail());
        request.setAttribute("senha", usuario.getSenha());
        request.setAttribute("papel", papelBo.obtenhaPapelPeloId(usuario.getIdPapel()).getNome());
    }
}
