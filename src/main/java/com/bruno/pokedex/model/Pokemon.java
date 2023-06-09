package com.bruno.pokedex.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Objects;

@Document
public class Pokemon {
    @Id
    private String id;
    private String nome;
    private String categoria;

    public ArrayList<Habilidade> getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(ArrayList<Habilidade> habilidade) {
        this.habilidade = habilidade;
    }

    private ArrayList<Habilidade> habilidade;
    private Double peso;

    public String getId() {
        return id;
    }

    public Pokemon(String id, String nome, String categoria, ArrayList<Habilidade> habilidade, Double peso) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.habilidade = habilidade;
        this.peso = peso;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(id, pokemon.id) && Objects.equals(nome, pokemon.nome) && Objects.equals(categoria, pokemon.categoria) && Objects.equals(habilidade, pokemon.habilidade) && Objects.equals(peso, pokemon.peso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, categoria, habilidade, peso);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", habilidade='" + habilidade + '\'' +
                ", peso=" + peso +
                '}';
    }
}
