package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Pokemon;

public class PokemonDAO extends DAO {
	
	public PokemonDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	public boolean insert(Pokemon pokemon) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO pokemon (codigo, nome, tipo, sexo) "
				       + "VALUES ("+pokemon.getCodigo()+ ", '" + pokemon.getNome() + "', '"  
				       + pokemon.getTipo() + "', '" + pokemon.getSexo() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public Pokemon get(int codigo) {
		Pokemon pokemon = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM produto WHERE id=" + codigo;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
				pokemon = new Pokemon(rs.getInt("codigo"), rs.getString("nome"), rs.getString("tipo"), rs.getString("sexo").charAt(0));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return pokemon;
	}
	
	
	public List<Pokemon> get() {
		return get("");
	}

	
	public List<Pokemon> getOrderByCodigo() {
		return get("codigo");		
	}
	
	
	public List<Pokemon> getOrderByNome() {
		return get("nome");		
	}
	
	
	public List<Pokemon> getOrderBySexo() {
		return get("sexo");		
	}
	
	
	private List<Pokemon> get(String orderBy) {	
	
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM pokemon" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Pokemon u = new Pokemon(rs.getInt("codigo"), rs.getString("nome"), rs.getString("tipo"), rs.getString("sexo").charAt(0));
	            pokemons.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return pokemons;
	}


	public List<Pokemon> getSexoMasculino() {
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM usuario WHERE usuario.sexo LIKE 'M'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	Pokemon u = new Pokemon(rs.getInt("codigo"), rs.getString("nome"), rs.getString("tipo"), rs.getString("sexo").charAt(0));
	            pokemons.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return pokemons;
	}
	
	
	public boolean update(Pokemon pokemon) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE pokemon SET nome = '" + pokemon.getNome() + "', tipo = '"  
				       + pokemon.getTipo() + "', sexo = '" + pokemon.getSexo() + "'"
					   + " WHERE codigo = " + pokemon.getCodigo();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int codigo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM pokemon WHERE codigo = " + codigo;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean autenticar(String login, String senha) {
		boolean resp = false;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM pokemon WHERE login LIKE '" + login + "' AND senha LIKE '" + senha  + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			resp = rs.next();
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return resp;
	}	
}