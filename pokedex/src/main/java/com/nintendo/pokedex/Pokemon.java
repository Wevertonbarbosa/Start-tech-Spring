package com.nintendo.pokedex;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Traz o incremento para o Id
    private int id;
    private String nome;
    private String especie;
    private String tipo;
    private String nivel;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }


    public void atualizar(Pokemon pokemon) {
        this.nome = pokemon.getNome();
        this.especie = pokemon.getEspecie();
        this.tipo = pokemon.getTipo();
        this.nivel = pokemon.getNivel();
    }
}
