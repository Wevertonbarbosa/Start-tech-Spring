package com.nintendo.pokedex;

import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {
}
