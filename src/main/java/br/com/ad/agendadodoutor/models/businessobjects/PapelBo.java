package br.com.ad.agendadodoutor.models.businessobjects;

import br.com.ad.agendadodoutor.models.entidades.Papel;
import br.com.ad.agendadodoutor.persistence.PapelDao;

import java.util.List;

public class PapelBo {
     private PapelDao papeldao = new PapelDao();

     public List<Papel> listePapeis() {
         return papeldao.listePapeis();
     }
}