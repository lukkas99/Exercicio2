package model;

public class Pokemon {
	private int codigo;
	private String nome;
	private String tipo;
	private char sexo;
	
	public Pokemon() {
		this.codigo = -1;
		this.nome = "";
		this.tipo = "";
		this.sexo = '*';
	}
	
	public Pokemon(int codigo, String nome, String tipo, char sexo) {
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.sexo = sexo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Pokemon [codigo=" + codigo + ", login=" + nome + ", senha=" + tipo + ", sexo=" + sexo + "]";
	}	
}
