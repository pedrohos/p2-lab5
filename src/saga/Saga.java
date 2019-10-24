package saga;

import easyaccept.EasyAccept;

/**
 * Representacao da fachada do sistema. O sistema consiste no controle de
 * Clientes, Fornecedores, e Produtos dos fornecedores.
 * 
 * @author Pedro Henrique
 */
public class Saga {
	/**
	 * Representacao do sistema.
	 */
	private Sistema sistema;

	/**
	 * Construtor instancia o sistema.
	 */
	public Saga() {
		this.sistema = new Sistema();
	}

	/**
	 * {@link saga.Sistema#adicionaCliente(String, String, String, String)}
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return sistema.adicionaCliente(cpf, nome, email, localizacao);
	}

	/**
	 * {@link saga.Sistema#exibeCliente(String)}
	 */
	public String exibeCliente(String cpf) {
		return sistema.exibeCliente(cpf);
	}

	/**
	 * {@link saga.Sistema#editaCliente(String, String, String)}
	 */
	public String editaCliente(String cpf, String atributo, String valor) {
		return sistema.editaCliente(cpf, atributo, valor);
	}

	/**
	 * {@link saga.Sistema#exibeClientes()}
	 */
	public String exibeClientes() {
		return sistema.exibeClientes();
	}

	/**
	 * {@link saga.Sistema#removeCliente(String)}
	 */
	public void removeCliente(String cpf) {
		sistema.removeCliente(cpf);
	}

	/**
	 * {@link saga.Sistema#adicionaFornecedor(String, String, String)}
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return sistema.adicionaFornecedor(nome, email, telefone);
	}

	/**
	 * {@link saga.Sistema#exibeFornecedor(String)}
	 */
	public String exibeFornecedor(String nome) {
		return sistema.exibeFornecedor(nome);
	}

	/**
	 * {@link saga.Sistema#exibeFornecedores()}
	 */
	public String exibeFornecedores() {
		return sistema.exibeFornecedores();
	}

	/**
	 * {@link saga.Sistema#editaFornecedor(String, String, String)}
	 */
	public String editaFornecedor(String nome, String atributo, String valor) {
		return sistema.editaFornecedor(nome, atributo, valor);
	}

	/**
	 * {@link saga.Sistema#exibeProduto(String, String, String)}
	 */
	public void removeFornecedor(String nome) {
		sistema.removeFornecedor(nome);
	}

	/**
	 * {@link saga.Sistema#adicionaProduto(String, String, String, double)}
	 */
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		sistema.adicionaProduto(fornecedor, nome, descricao, preco);
	}

	/**
	 * {@link saga.Sistema#exibeProduto(String, String, String)}
	 */
	public String exibeProduto(String fornecedor, String nome, String descricao) {
		return sistema.exibeProduto(fornecedor, nome, descricao);
	}

	/**
	 * {@link saga.Sistema#exibeProdutosFornecedor(String)}
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		return sistema.exibeProdutosFornecedor(fornecedor);
	}

	/**
	 * {@link saga.Sistema#exibeProdutos()}
	 */
	public String exibeProdutos() {
		return sistema.exibeProdutos();
	}

	/**
	 * {@link saga.Sistema#editaProduto(String, String, String, double)}
	 */
	public void editaProduto(String nome, String descricao, String fornecedor, double valor) {
		sistema.editaProduto(nome, descricao, fornecedor, valor);
	}

	/**
	 * {@link saga.Sistema#removeProduto(String, String, String)}
	 */
	public void removeProduto(String fornecedor, String nome, String descricao) {
		sistema.removeProduto(fornecedor, nome, descricao);
	}

	/**
	 * {@link saga.Sistema#adicionaCompra(String, String, String, String, String)}
	 */
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome, String descricao) {
		sistema.adicionaCompra(cpf, fornecedor, data, nome, descricao);
	}

	/**
	 * {@link saga.Sistema#adicionaCombo(String, String, String, double, String)}
	 */
	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		sistema.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
	}

	/**
	 * {@link saga.Sistema#editaCombo(String, String, String, double)}
	 */
	public void editaCombo(String nome, String descricao, String fornecedor, double fator) {
		sistema.editaCombo(fornecedor, nome, descricao, fator);
	}

	/**
	 * {@link saga.Sistema#getDebito(String, String)}
	 */
	public String getDebito(String cpf, String fornecedor) {
		return sistema.getDebito(cpf, fornecedor);
	}

	/**
	 * {@link saga.Sistema#exibeContas(String, String)}
	 */
	public String exibeContas(String cpf, String fornecedor) {
		return sistema.exibeContas(cpf, fornecedor);
	}

	/**
	 * {@link saga.Sistema#exibeContasClientes(String)}
	 */
	public String exibeContasClientes(String cpf) {
		return sistema.exibeContasClientes(cpf);
	}

	/**
	 * {@link saga.Sistema#realizaPagamento(String, String)}
	 */
	public void realizaPagamento(String cpf, String fornecedor) {
		sistema.realizaPagamento(cpf, fornecedor);
	}

	/**
	 * {@link saga.Sistema#ordenaPor(String)}
	 */
	public void ordenaPor(String criterio) {
		sistema.ordenaPor(criterio);
	}

	/**
	 * {@link saga.Sistema#listarCompras()}
	 */
	public String listarCompras() {
		return sistema.listarCompras();
	}

	public static void main(String[] args) {
		args = new String[] { "saga.Saga", "testes_aceitacao/use_case_1.txt", "testes_aceitacao/use_case_2.txt",
				"testes_aceitacao/use_case_3.txt", "testes_aceitacao/use_case_4.txt", "testes_aceitacao/use_case_6.txt",
				"testes_aceitacao/use_case_5.txt", "testes_aceitacao/use_case_7.txt",
				"testes_aceitacao/use_case_8.txt" };
		EasyAccept.main(args);
	}
}
