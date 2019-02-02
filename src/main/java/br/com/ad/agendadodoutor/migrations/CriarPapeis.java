package br.com.ad.agendadodoutor.migrations;

import br.com.ad.agendadodoutor.models.entidades.Papel;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class CriarPapeis extends BaseJavaMigration {
    private EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("ad-persistence");
    private EntityManager em = emf.createEntityManager();

    @Override
    public void migrate(Context context) throws Exception {
        List<Papel> papeis = new ArrayList<Papel>();

        papeis.add(new Papel(id, "Administrador"));
        papeis.add(new Papel(id, "Operador"));

        try {
            em.getTransaction().begin();

            em.persist(papeis);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em != null) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}
