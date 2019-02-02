package br.com.ad.agendadodoutor.models.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Papel {
    @Id
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
