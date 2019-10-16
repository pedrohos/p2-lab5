package saga;

public class ProdutoCombo extends Produto implements Comparable<Produto> {

	private double fator;
	
	public ProdutoCombo(String nome, String descricao, double preco, double fator, String produtos) {
		super(nome, descricao, preco);
		this.fator = fator;
	}
	
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
