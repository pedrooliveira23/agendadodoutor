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
}
