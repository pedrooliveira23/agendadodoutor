package br.com.ad.agendadodoutor.models.businessobjects;

import br.com.ad.agendadodoutor.models.entidades.Usuario;
import br.com.ad.agendadodoutor.persistence.UsuarioDao;

import java.util.List;

public class UsuarioBo {
    private UsuarioDao usuarioDao;

    public UsuarioBo() {
        usuarioDao = new UsuarioDao();
    }

    public Usuario obtenhaUsuario(String nomeDeUsuario) {
        return usuarioDao.obtenhaUsuario(nomeDeUsuario);
    }

    public List<Usuario> obtenhaUsuarios() {
        return usuarioDao.obtenhaUsuarios();
    }

}
