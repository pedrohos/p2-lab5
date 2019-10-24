package saga;

/**
 * Representacao de uma Compra. Cada compra possui uma data, o nome e descricao
 * do produto que o compoem, o nome do cliente, o nome do fornecedor e o preco.
 * 
 * @author Pedro Henrique
 */
public class Compra {

	/**
	 * Armazena a data da compra.
	 */
	private String data;

	/**
	 * Armazena o nome do produto.
	 */
	private String nome;

	/**
	 * Armazena a descricao do produto.
	 */
	private String descricao;

	/**
	 * Armazena o preco da compra.
	 */
	private double preco;

	/**
	 * Armazena o nome do cliente.
	 */
	private String cliente;

	/**
	 * Armazena o nome do fornecedor.
	 */
	private String fornecedor;

	/**
	 * Constroi uma compra atribuindo incializando todos os atributos com os
	 * parametros.
	 * 
	 * @param data       e a data da compra.
	 * @param nome       e o nome do produto.
	 * @param descricao  e a descricao do produto.
	 * @param preco      e o valor da compra.
	 * @param cliente    e o nome do cliente.
	 * @param fornecedor e o nome do fornecedor.
	 */
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

	@Override
	public String toString() {
		return nome + " - " + data;
	}

}
