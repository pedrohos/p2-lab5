package saga;

import easyaccept.EasyAccept;

public class Saga {
	private Sistema sistema;
	
	public Saga() {
		sistema = new Sistema();
	}
	
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return sistema.adicionaCliente(cpf, nome, email, localizacao);
	}
	
	public String exibeCliente(String cpf) {
		return sistema.exibeCliente(cpf);
	}
	
	public String editaCliente(String cpf, String atributo, String valor) {
		return sistema.editaCliente(cpf, atributo, valor);
	}
	
	public String listaClientes() {
		return sistema.listaClientes();
	}
	
	public void removeCliente(String cpf) {
		sistema.removeCliente(cpf);
	}
	
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return sistema.adicionaFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor(String nome) {
		return sistema.exibeFornecedor(nome);
	}
	
	public String listarFornecedores() {
		return sistema.listarFornecedores();
	}
	
	public String editaFornecedor(String nome, String atributo, String valor) {
		return sistema.editaFornecedor(nome, atributo, valor);
	}
	
	public void removeFornecedor(String cpf) {
		sistema.removeFornecedor(cpf);
	}
	
	public String cadastrarProduto(String fornecedor, String nome, String descricao, double preco) {
		return sistema.cadastrarProduto(fornecedor, nome, descricao, preco);
	}
	
	public String exibirProduto(String fornecedor, String nome, String descricao) {
		return sistema.exibirProduto(fornecedor, nome, descricao);
	}
	
	public String listarProdutos(String fornecedor) {
		return sistema.listarProdutos(fornecedor);
	}
	
	public String listarProdutosTodosFornecedores () {
		return sistema.listarProdutosTodosFornecedores();
	}
	
	public String removeProduto(String fornecedor, String nome, String descricao) {
		return sistema.removeProduto(fornecedor, nome, descricao);
	}
	
	public static void main(String[] args) {
		//args = new String[] { "saga.Saga", "testes_aceitacao/use_case_1.txt" };
		//EasyAccept.main(args);
		
		args = new String[] { "saga.Saga", "testes_aceitacao/use_case_2.txt" };
		EasyAccept.main(args);
		
		//args = new String[] { "saga.Saga", "testes_aceitacao/use_case_3.txt" };
		//EasyAccept.main(args);
		
		//args = new String[] { "saga.Saga", "testes_aceitacao/use_case_1.txt", "testes_aceitacao/use_case_2.txt", "testes_aceitacao/use_case_3.txt" };
		//EasyAccept.main(args);
	}
}
