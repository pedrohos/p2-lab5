package saga;

public class Compra {
	private String data;
	private String nome;
	private String descricao;
	private double preco;
	
	public Compra(String data, String nome, String descricao, double preco) {
		this.data = data;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public double getPreco() {
		return this.preco;
	}

	@Override
	public String toString() {
		return nome + " - " + data;
	}
	
	
}
