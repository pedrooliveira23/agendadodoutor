package br.com.ad.agendadodoutor.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Papel {
    @Id  @GeneratedValue
    private int id;
    private String nome;

    public Papel(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Papel() {
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
