package br.com.ad.agendadodoutor.models.businessobjects;

import br.com.ad.agendadodoutor.models.entities.Papel;
import br.com.ad.agendadodoutor.persistence.PapelDao;

import java.util.List;

public class PapelBo {
    private PapelDao papelDao;

    public PapelBo() {
        papelDao = new PapelDao();
    }

    public List<Papel> listePapeis() {
        return papelDao.listePapeis();
    }

    public Papel obtenhaPapelPeloId(int id) {
        return papelDao.obtenhaPapelPeloId(id);
    }

    public Papel obtenhaPapelPeloNome(String nome) {
        return papelDao.obtenhaPapelPeloNome(nome);
    }
}
