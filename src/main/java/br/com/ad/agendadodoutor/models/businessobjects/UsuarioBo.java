package br.com.ad.agendadodoutor.models.businessobjects;

import br.com.ad.agendadodoutor.models.entities.Usuario;
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

    public void crieUsuario(Usuario usuario) {
        usuarioDao.crieUsuario(usuario);
    }

    public void editeUsuario(Usuario usuarioAnterior, Usuario usuarioNovo) {
        usuarioDao.editeUsuario(usuarioAnterior, usuarioNovo);
    }

    public List<Usuario> pesquiseUsuarios(String sentenca) {
        return usuarioDao.pesquiseUsuarios(sentenca);
    }

    public void removaUsuario(Usuario usuario) {
        usuarioDao.removaUsuario(usuario);
    }
}
