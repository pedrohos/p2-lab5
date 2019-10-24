package saga;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representa o controlador de contas dos clientes. O controlador gerencia a
 * conta.
 * 
 * @author Pedro Henrique
 */
public class ControllerConta {

	/**
	 * Armazena o nome do fornecedor deste sistema.
	 */
	private String fornecedor;

	/**
	 * Armazena um mapa que mapeia o cpf do cliente a sua conta.
	 */
	private HashMap<String, Conta> contasCliente;

	/**
	 * Controi o controlador com o nome do fornecedor e controi as contas dos
	 * clientes.
	 * 
	 * @param fornecedor e o nome do fornecedor.
	 */
	public ControllerConta(String fornecedor) {
		this.fornecedor = fornecedor;
		this.contasCliente = new HashMap<>();
	}

	/**
	 * Retorna um boolean indicando se determinada conta existe, a partir do cpf do
	 * cliente.
	 * 
	 * @param cpf e o cpf do cliente.
	 * @return e retornado true caso a conta existe, caso contrario, false.
	 */
	public boolean existeConta(String cpf) {
		if (this.contasCliente.containsKey(cpf)) {
			return true;
		}
		return false;
	}

	/**
	 * Cria uma conta a partir do cpf de um cliente e do nome dele.
	 * 
	 * @param cpf     e o cpf do cliente.
	 * @param cliente e o nome do cliente.
	 */
	private void criaConta(String cpf, String cliente) {
		this.contasCliente.put(cpf, new Conta(cliente, this.fornecedor));
	}

	/**
	 * Adiciona uma compra de um produto a conta de um cliente. Caso o cliente nao
	 * possua conta, ela sera criada. A compra possui uma data, um nome, uma
	 * descricao e um preco.
	 * 
	 * @param cpf       e o cpf do cliente.
	 * @param data      e a data da compra.
	 * @param nome      e o nome do produto.
	 * @param descricao e o nome do produto.
	 * @param cliente   e o nome do cleinte.
	 * @param preco     e o valor do produto.
	 */
	public void adicionaCompra(String cpf, String data, String nome, String descricao, String cliente, double preco) {
		if (!existeConta(cpf))
			criaConta(cpf, cliente);

		this.contasCliente.get(cpf).adicionaCompra(data, nome, descricao, preco);
	}

	/**
	 * Retorna o debito que determinado cliente possui.
	 * 
	 * Caso o cpf seja nulo ou vazio sera lancado um IllegalArgumentException: "Erro
	 * ao recuperar debito: cpf nao pode ser vazio ou nulo." Caso o cpf nao possua
	 * 11 caracteres sera lancado um IllegalArgumentException: "Erro ao recuperar
	 * debito: cpf invalido." Caso o cpf nao remeta a nenhuma conta sera lancado um
	 * IllegalArgumentException: "Erro ao recuperar debito: cliente nao tem debito
	 * com fornecedor."
	 * 
	 * @param cpf e o cpf do cliente.
	 * @return e retornado o debito do cliente.
	 */
	public String getDebitoCliente(String cpf) {
		if (cpf == null || cpf.equals(""))
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		if (cpf.length() != 11)
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido.");
		if (!existeConta(cpf))
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");

		return this.contasCliente.get(cpf).getDebito();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contasCliente == null) ? 0 : contasCliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ControllerConta other = (ControllerConta) obj;
		if (contasCliente == null) {
			if (other.contasCliente != null)
				return false;
		} else if (!contasCliente.equals(other.contasCliente))
			return false;
		return true;
	}

	/**
	 * Exibe a representacao toString das contas do cpf especificado.
	 * 
	 * @param cpf e cpf do cliente.
	 * @return e retornado a representacao toString das contas.
	 */
	public String exibeContas(String cpf) {
		return this.contasCliente.get(cpf).exibeContas();
	}

	/**
	 * Paga todo o debito das contas do usuario ao remover suas contas.
	 * 
	 * Caso o cpf nao remeta a nenhuma conta sera lancado um
	 * IllegalArgumentException: "Erro no pagamento de conta: nao ha debito do
	 * cliente associado a este fornecedor."
	 * 
	 * @param cpf e o cpf do cliente.
	 */
	public void realizaPagamento(String cpf) {
		if (!existeConta(cpf))
			throw new IllegalArgumentException(
					"Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.");

		this.contasCliente.remove(cpf);
	}

	/**
	 * Retorna as todas as compras ao iterar por todas as contas de todos os
	 * clientes.
	 * 
	 * @return e retornado uma array list com todas as compras do sistema.
	 */
	public ArrayList<Compra> retornaCompras() {
		ArrayList<Compra> compras = new ArrayList<>();
		for (Conta contas : contasCliente.values()) {
			for (Compra compra : contas.retornaCompras()) {
				compras.add(compra);
			}
		}
		return compras;
	}
}
