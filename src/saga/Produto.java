package saga;

import java.util.Locale;

/**
 * Representacao de um produto de um fornecedor. Cada produto possui um
 * IdProduto e um preco. O IdProdtuo ira identificar unicamente o produto, ele e
 * composto por um nome e descricao.
 * 
 * @author Pedro Henrique
 */
public class Produto implements Comparable<Produto> {

	/**
	 * Representa o identificador unico do produto.
	 */
	protected IdProduto id;

	/**
	 * Representa o preco do produto. Nao pode ser menor que ou igual a 0.
	 */
	protected double preco;

	/**
	 * Constroi um produto a partir do preco recebido e de um id que e gerado a
	 * partir do nome do produto e da descricao do produto.
	 * 
	 * Caso o preco seja menor que ou igual a 0 sera lancado um
	 * IllegalArgumentException: "Erro na criacao de produto: preco invalido."
	 * 
	 * @param nome      e o nome que ira construir o id do produto.
	 * @param descricao e a descricao que ira construir o id do produto.
	 * @param preco     e o preco do produto.
	 */
	public Produto(String nome, String descricao, double preco) {
		if (preco <= 0)
			throw new IllegalArgumentException("Erro na criacao de produto: preco invalido.");

		this.id = new IdProduto(nome, descricao);
		this.preco = preco;
	}

	/**
	 * Modifica o preco do produto pelo recebido no parametro. Se o preco for menor
	 * que ou igual a 0, sera lancado um IllegalArgumentException: "Erro na edicao
	 * de produto: preco invalido."
	 * 
	 * @param preco e o novo preco do produto que substituira o atual.
	 */
	public void setPreco(double preco) {
		if (preco <= 0)
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");

		this.preco = preco;
	}

	/**
	 * Retorna o preco atual.
	 * 
	 * @return retorna o preco do produto.
	 */
	public double getPreco() {
		return this.preco;
	}

	/**
	 * Representacao toString o produto, no formato: NOME - DESCRICAO - R$X,XX
	 */
	@Override
	public String toString() {
		return String.format("%s - R$%.2f", this.id.toString(), getPreco()).replace(".", ",");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * Compara se dois produtos sao iguais ao comparar seus ids.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(Produto o) {
		String nomeCompleto = this.id.getNome();
		String nomeCompletoOutro = o.id.getNome();
		return nomeCompleto.compareTo(nomeCompletoOutro);
	}
}
