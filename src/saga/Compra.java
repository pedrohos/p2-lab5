package saga;

public class Compra {
	private String data;
	private String nome;
	private String descricao;
	private String cliente;
	private double preco;
	private String fornecedor;
	
	public Compra(String data, String nome, String descricao, double preco, String cliente, String fornecedor) {
		this.data = data;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.cliente = cliente;
		this.fornecedor = fornecedor;
	}
	
	public String getFornecedor() {
		return this.fornecedor;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public String getData() {
		return this.data;
	}
	
	public String getCliente() {
		return this.cliente;
	}
	
	public double getPreco() {
		return this.preco;
	}
	
	public String getNomeCompleto() {
		return this.nome + " " + this.descricao;
	}

	@Override
	public String toString() {
		return nome + " - " + data;
	}
	
	
}
