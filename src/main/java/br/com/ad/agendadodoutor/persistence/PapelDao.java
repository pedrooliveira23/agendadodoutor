package br.com.ad.agendadodoutor.persistence;

import br.com.ad.agendadodoutor.models.entities.Papel;
import br.com.ad.agendadodoutor.utils.JpaUtil;

import java.util.ArrayList;
import java.util.List;

public class PapelDao {
    public List<Papel> listePapeis() {
        List<Papel> result = new ArrayList<Papel>();
        try {
            String jpql = "FROM Papel";
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Papel.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.closeEntityManager();
        }
        return result;
    }

    public Papel obtenhaPapelPeloId(int id) {
        List<Papel> result = new ArrayList();
        try {
            String jpql = "FROM Papel WHERE id = " + id;
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Papel.class).getResultList();
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

    public Papel obtenhaPapelPeloNome(String nome) {
        List<Papel> result = new ArrayList();
        try {
            String jpql = "FROM Papel WHERE nome = '" + nome + "'";
            result = JpaUtil.getEntityManager()
                    .createQuery(jpql, Papel.class).getResultList();
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
}
