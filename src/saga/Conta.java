package saga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/**
 * Representacao de um Conta. Toda conta possui um o dono da conta (cliente), a
 * quem a conta e referente (fornecedor) e um conjunto de compras.
 * 
 * @author Pedro Henrique
 */
public class Conta {

	/**
	 * Armazena uma lista de compras.
	 */
	private ArrayList<Compra> compras;

	/**
	 * Armazena o cliente dono da conta.
	 */
	private String cliente;

	/**
	 * Armazena o fornecedor.
	 */
	private String fornecedor;

	/**
	 * Constroi uma conta a partir do nome do cliente e do fornecedor.
	 * 
	 * @param cliente    e o nome do cliente.
	 * @param fornecedor e o nome do fornecedor.
	 */
	public Conta(String cliente, String fornecedor) {
		this.compras = new ArrayList<>();
		this.cliente = cliente;
		this.fornecedor = fornecedor;
	}

	/**
	 * Adiciona uma compra na lista de compras. Uma compra possui uma data, o nome e
	 * descricao do produto, uma descricao e um preco.
	 * 
	 * @param data      e a data da compra.
	 * @param nome      e o nome do produto.
	 * @param descricao e a descricao do produto.
	 * @param preco     e o preco do produto.
	 */
	public void adicionaCompra(String data, String nome, String descricao, double preco) {
		this.compras.add(new Compra(data, nome, descricao, preco, this.cliente, this.fornecedor));
	}

	public String getCliente() {
		return this.cliente;
	}

	/**
	 * Recupera o debito que o cliente possui com o fornecedor, ao somar seu debito
	 * de todas as compras.
	 * 
	 * Caso o debito seja nulo sera lancado um IllegalArgumentException: "Erro ao
	 * recuperar debito: cliente nao tem debito com fornecedor."
	 * 
	 * @return e retornado o debito que o cliente possui com o fornecedor.
	 */
	public String getDebito() {
		double debito = 0;
		for (Compra c : compras) {
			debito += c.getPreco();
		}
		if (debito == 0)
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		return String.format(Locale.ENGLISH, "%.2f", debito);
	}

	/**
	 * Retorna a exibicao de todas as compras desta conta. Separando os elementos
	 * com " | ".
	 * 
	 * @return e retornado a representacao toString de todas as compras.
	 */
	public String exibeContas() {
		String resultado = "";
		Iterator<Compra> it = compras.iterator();
		while (it.hasNext()) {
			Compra elemento = it.next();
			if (it.hasNext()) {
				resultado += elemento.toString() + " | ";
			} else {
				resultado += elemento.toString();
			}
		}
		return resultado;
	}

	/**
	 * Retorna a lista de compras.
	 * 
	 * @return e retornado todas as compras desta conta.
	 */
	public ArrayList<Compra> retornaCompras() {
		ArrayList<Compra> compras = new ArrayList<>();
		compras = this.compras;
		return compras;
	}
}
