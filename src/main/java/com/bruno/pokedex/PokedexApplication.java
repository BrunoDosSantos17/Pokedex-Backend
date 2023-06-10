package com.bruno.pokedex;

import com.bruno.pokedex.model.Habilidade;
import com.bruno.pokedex.model.Pokemon;
import com.bruno.pokedex.repository.PokemonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import reactor.core.publisher.Flux;

import java.util.ArrayList;


@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class PokedexApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokedexApplication.class, args);
	}
	@Bean
	CommandLineRunner init (ReactiveMongoOperations operations, PokemonRepository repository){


		return args -> {
				repository.findAll().hasElements().subscribe(havePokemonPokedex -> {
					if(!havePokemonPokedex){
						ArrayList<Habilidade> habilidades = new ArrayList<>();
						habilidades.add(new Habilidade("Sintase", "0"));
						habilidades.add(new Habilidade("Semente", "5"));
						habilidades.add(new Habilidade("Laminas de folhas", "15"));
						habilidades.add(new Habilidade("Investida", "10"));

						Flux<Pokemon> pokedexFlux = Flux.just(
								new Pokemon(null, "Bulbassaro", "Semente", habilidades, 6.09)
						).flatMap(repository::save);

						pokedexFlux.thenMany(repository.findAll()).subscribe(System.out::println);
					}

				});
		};
	}



}
