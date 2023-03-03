package app;

import java.util.List;

import dao.DAO;
import dao.PokemonDAO;
import model.Pokemon;

public class Pokedex {
	
	public static void main(String[] args) throws Exception {
		
		PokemonDAO pokemonDAO = new PokemonDAO();
		
		System.out.println("\n\n==== Inserir pokemon === ");
		Pokemon pokemon = new Pokemon(11, "pikachu", "eletrico",'M');
		if(pokemonDAO.insert(pokemon) == true) {
			System.out.println("Inserção com sucesso -> " + pokemon.toString());
		}
		
		System.out.println("\n\n==== Testando autenticação ===");
		System.out.println("Pokemon: (" + pokemon.getNome() + "): " + pokemonDAO.autenticar("pikachu", "eletrico"));
			
		System.out.println("\n\n==== Mostrar pokemons do sexo masculino === ");
		List<Pokemon> pokemons = pokemonDAO.getSexoMasculino();
		for (Pokemon u: pokemons) {
			System.out.println(u.toString());
		}

		System.out.println("\n\n==== Atualizar tipo (código (" + pokemon.getCodigo() + ") === ");
		pokemon.setTipo(DAO.toMD5("ground"));
		pokemonDAO.update(pokemon);
		
		System.out.println("\n\n==== Testando autenticação ===");
		System.out.println("Pokemon (" + pokemon.getNome() + "): " + pokemonDAO.autenticar("pikachu", DAO.toMD5("pikachu")));		
		
		System.out.println("\n\n==== Invadir usando SQL Injection ===");
		System.out.println("Pokemon (" + pokemon.getNome() + "): " + pokemonDAO.autenticar("pikachu", "x' OR 'x' LIKE 'x"));

		System.out.println("\n\n==== Mostrar pokemons ordenados por código === ");
		pokemons = pokemonDAO.getOrderByCodigo();
		for (Pokemon u: pokemons) {
			System.out.println(u.toString());
		}
		
		System.out.println("\n\n==== Excluir pokemon (código " + pokemon.getCodigo() + ") === ");
		pokemonDAO.delete(pokemon.getCodigo());
		
		System.out.println("\n\n==== Mostrar pokemons ordenados por login === ");
		pokemons = pokemonDAO.getOrderByNome();
		for (Pokemon u: pokemons) {
			System.out.println(u.toString());
		}
	}
}