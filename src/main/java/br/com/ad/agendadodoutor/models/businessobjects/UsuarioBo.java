package br.com.ad.agendadodoutor.models.businessobjects;

import br.com.ad.agendadodoutor.models.entidades.Usuario;
import br.com.ad.agendadodoutor.persistence.UsuarioDao;

public class UsuarioBo {
    public Usuario obtenhaUsuario(String nomeDeUsuario) {
        UsuarioDao usuarioDao = new UsuarioDao();
        return usuarioDao.obtenhaUsuario(nomeDeUsuario);
    }
}
