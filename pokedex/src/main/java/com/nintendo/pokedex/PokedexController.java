package com.nintendo.pokedex;


//Toda a definição da API  vai estar aqui.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/pokemons")// Label para registrar que é uma classe Controller
public class PokedexController {
    @Autowired
    private PokemonRepository repository;
    private ArrayList<Pokemon> pokemons = new ArrayList<>();

    private int ultimoId = 1;

    @GetMapping
    public Iterable<Pokemon> listar() {
        return repository.findAll();
    }

    @GetMapping
    private Pokemon descrever(@PathVariable int id){
        Optional<Pokemon> pokemonOptional = repository.findById(id);

        if (pokemonOptional.isPresent()){
            return pokemonOptional.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void inserir(@RequestBody Pokemon pokemon) {
        repository.save(pokemon);
    }


    @PutMapping("/{id}")
    private void atualizar(@PathVariable int id, @RequestBody Pokemon pokemon) {
        Optional<Pokemon> pokemonOptional = repository.findById(id);

        if(pokemonOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Pokemon pokemonEncontrado = pokemonOptional.get();
        pokemonEncontrado.atualizar(pokemon);

        repository.save(pokemonEncontrado);
    }


    @DeleteMapping("/{id}")
    private void remover(@PathVariable int id) {
        Optional<Pokemon> pokemonOptional = repository.findById(id);

        if(pokemonOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        repository.delete(pokemonOptional.get());
    }



}
