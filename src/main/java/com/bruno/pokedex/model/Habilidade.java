package com.bruno.pokedex.model;

public class Habilidade {



    String nome;
    String dano;

    public Habilidade(String nome, String dano) {
        this.nome = nome;
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDano() {
        return dano;
    }

    public void setDano(String dano) {
        this.dano = dano;
    }
    @Override
    public String toString() {
        return "Habilidade{" +
                "nome='" + nome + '\'' +
                ", dano='" + dano + '\'' +
                '}';
    }

}
