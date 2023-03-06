package com.nintendo.pokedex;


//Toda a definição da API  vai estar aqui.

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("/pokemons")// Label para registrar que é uma classe Controller
public class PokedexController {
    private ArrayList<Pokemon> pokemons = new ArrayList<>();

    private int ultimoId = 1;

    @GetMapping
    public ArrayList<Pokemon> listar() {
        return pokemons;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@RequestBody Pokemon pokemon){
        pokemon.setId(ultimoId);
        pokemons.add(pokemon);
        ultimoId++;
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable int id){
        Pokemon pokemonEncontrado = null;

        for (Pokemon pokemon : pokemons){
            if(pokemon.getId()== id){
                pokemonEncontrado = pokemon;
                break;
            }
        }

        if (pokemonEncontrado != null){
            pokemons.remove(pokemonEncontrado);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }




}
