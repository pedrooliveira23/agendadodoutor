package br.com.ad.agendadodoutor.persistence;

import br.com.ad.agendadodoutor.models.entidades.Usuario;
import br.com.ad.agendadodoutor.utils.JpaUtil;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    public Usuario obtenhaUsuario(String nomeDeUsuario) {
        List<Usuario> result = new ArrayList();
        try {
            String jpql = "FROM Usuario WHERE nomedeusuario='"+nomeDeUsuario+"'";
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Usuario.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        if(result.size() == 0) {
            return null;
        } else {
            return result.get(0);
        }
    }

    public List<Usuario> obtenhaUsuarios() {
        List<Usuario> result = new ArrayList();
        try {
            String jpql = "FROM Usuario";
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Usuario.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        if(result.size() == 0) {
            return null;
        } else {
            return result;
        }
    }
}
