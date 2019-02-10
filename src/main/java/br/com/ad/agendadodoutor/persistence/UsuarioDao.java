package br.com.ad.agendadodoutor.persistence;

import br.com.ad.agendadodoutor.models.entities.Usuario;
import br.com.ad.agendadodoutor.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ad-persistence");
    private EntityManager em = emf.createEntityManager();

    public Usuario obtenhaUsuario(String nomeDeUsuario) {
        List<Usuario> result = new ArrayList();
        try {
            String jpql = "FROM Usuario WHERE nomedeusuario='" + nomeDeUsuario + "'";
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Usuario.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        if (result.size() == 0) {
            return null;
        } else {
            return result.get(0);
        }
    }

    public List<Usuario> pesquiseUsuarios(String sentenca) {
        List<Usuario> result = new ArrayList();
        try {
            String jpql = "FROM Usuario WHERE nomedeusuario LIKE LOWER('%" + sentenca + "%')";
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Usuario.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        if (result.size() == 0) {
            return null;
        } else {
            return result;
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
        if (result.size() == 0) {
            return null;
        } else {
            return result;
        }
    }

    public boolean crieUsuario(Usuario usuario) {
        try {
            em.getTransaction().begin();

            em.persist(usuario);

            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (em != null) {
                em.getTransaction().rollback();
            }
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
            return false;
        }
    }
}
