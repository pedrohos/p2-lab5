package saga;

/**
 * Representacao de um combo de produtos. Cada combo herda de Produto (possui
 * nome, descricao e preco), alem de possui um fator.
 * 
 * @author Pedro Henrique
 */
public class ProdutoCombo extends Produto implements Comparable<Produto> {

	/**
	 * Armazena o fator de desconto do combo.
	 */
	private double fator;

	/**
	 * Constroi um Combo a partir dos atributos do Produto e a partir do fator.
	 * 
	 * @param nome      e o nome do combo.
	 * @param descricao e a descricao do combo.
	 * @param preco     e o preco do combo.
	 * @param fator     e o fator de desconto do combo.
	 * @param produtos  e a lista de produtos que formam o combo.
	 */
	public ProdutoCombo(String nome, String descricao, double preco, double fator, String produtos) {
		super(nome, descricao, preco);
		this.fator = fator;
	}

	/**
	 * Retorna o preco do combo ao realizar o produto do preco pelo fator de
	 * desconto.
	 * 
	 * @return e retornado o preco do combo.
	 */
	public double getPrecoCombo() {
		return this.preco * (1 - this.fator);
	}

	public void editaCombo(double fator) {
		this.fator = fator;
	}

	/**
	 * Representacao toString o produto, no formato: NOME - DESCRICAO - R$X,XX
	 */
	@Override
	public String toString() {
		return String.format("%s - R$%.2f", this.id.toString(), getPrecoCombo()).replace(".", ",");
	}
}
