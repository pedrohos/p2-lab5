package saga;

import easyaccept.EasyAccept;

/**
 * Representacao da fachada do sistema.
 * O sistema consiste no controle de Clientes, Fornecedores, e Produtos
 * dos fornecedores.
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
		sistema = new Sistema();
	}
	
	/**
	 * Adiciona um cliente ao sistema.
	 * Chama o metodo adicionaCliente passando o cpf, nome, email e localizacao.
	 * Se a adicao for efetuado com sucesso sera retornado o cpf.
	 * 
	 * @param cpf e o cpf do cliente.
	 * @param nome e o nome do cliente.
	 * @param email e o email do cliente.
	 * @param localizacao e a localizacao do cliente.
	 * @return retorna o cpf do cliente.
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return sistema.adicionaCliente(cpf, nome, email, localizacao);
	}
	
	/**
	 * Retorna a Representacao toString do cliente a partir do seu cpf.
	 * 
	 * @param cpf e o atributo que sera usado para identificar o cliente.
	 * @return retorna a representacao toString do cliente.
	 */
	public String exibeCliente(String cpf) {
		return sistema.exibeCliente(cpf);
	}
	
	/**
	 * Edita um atributo do cliente, com o valor indicado pelo parametro.
	 * O cpf ira identificar o cliente, o atributo ira identificar o atributo
	 * a ser modificado e o valor sera o valor que sera substituido no local
	 * do valor atual. Caso a edicao tenha ocorrido, sera retornado qual atributo foi
	 * atualizado. O cpf nao pode ser alterado.
	 * 
	 * @param cpf e o atributo que sera usado para identificar o cliente.
	 * @param atributo e o atributo que sera alterado.
	 * @param valor e o valor que substituira o valor atual.
	 * @return retorna o atributo que foi modificado caso a modificacao tenha
	 * sido efetuada com sucesso.
	 */
	public String editaCliente(String cpf, String atributo, String valor) {
		return sistema.editaCliente(cpf, atributo, valor);
	}
	
	/**
	 * Retorna uma String listando todos os clientes do sistema.
	 * 
	 * @return retorna a representacao toString de todos os clientes do sistema.
	 */
	public String listaClientes() {
		return sistema.listaClientes();
	}
	
	/**
	 * Remove o cliente do sistema, identificando ele atraves do cpf.
	 * 
	 * @param cpf e o atributo que sera usado para identificar o cliente.
	 */
	public void removeCliente(String cpf) {
		sistema.removeCliente(cpf);
	}
	
	/**
	 * Adiciona um fornecedor ao sistema.
	 * Chama o metodo adicionaFornecedor passando o nome, email e telefone.
	 * Se a adicao for efetuado com sucesso sera retornado o nome.
	 * 
	 * @param nome e o nome do fornecedor.
	 * @param email e o email do fornecedor.
	 * @param telefone e o telefone do fornecedor.
	 * @return retorna o nome do fornecedor.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return sistema.adicionaFornecedor(nome, email, telefone);
	}
	
	/**
	 * Retorna a Representacao toString do fornecedor a partir do seu nome.
	 * 
	 * @param nome e o atributo que sera usado para identificar o fornecedor.
	 * @return retorna a representacao toString do fornecedor.
	 */
	public String exibeFornecedor(String nome) {
		return sistema.exibeFornecedor(nome);
	}
	
	/**
	 * Retorna uma String listando todos os fornecedores do sistema.
	 * 
	 * @return retorna a representacao toString de todos os fornecedores do sistema.
	 */
	public String listaFornecedores() {
		return sistema.listaFornecedores();
	}
	
	/**
	 * Edita um atributo do fornecedor, com o valor indicado pelo parametro.
	 * O nome ira identificar o fornecedor, o atributo ira identificar o atributo
	 * a ser modificado e o valor sera o valor que sera substituido no local
	 * do valor atual. Caso a edicao tenha ocorrido, sera retornado qual atributo foi
	 * atualizado. O nome nao pode ser alterado.
	 * 
	 * @param nome e o atributo que sera usado para identificar o fornecedor.
	 * @param atributo e o atributo que sera alterado.
	 * @param valor e o valor que substituira o valor atual.
	 * @return retorna o atributo que foi modificado caso a modificacao tenha
	 * sido efetuada com sucesso.
	 */
	public String editaFornecedor(String nome, String atributo, String valor) {
		return sistema.editaFornecedor(nome, atributo, valor);
	}
	
	/**
	 * Remove o fornecedor do sistema, identificando ele atraves do nome.
	 * 
	 * @param nome e o atributo que sera usado para identificar o fornecedor.
	 */
	public void removeFornecedor(String nome) {
		sistema.removeFornecedor(nome);
	}
	
	/**
	 * Adiciona um produto a um fornecedor.
	 * Chama o metodo adicionaProduto passando o nome do fornecedor,
	 * nome do produto, descricao do produto e preco do produto.
	 * 
	 * @param fornecedor e o nome do fornecedor ao qual o produto sera afiliado.
	 * @param nome e o nome do produto.
	 * @param descricao e a descricao do produto.
	 * @param preco e o telefone do fornecedor.
	 */
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		sistema.adicionaProduto(fornecedor, nome, descricao, preco);
	}
	
	/**
	 * Retorna a Representacao toString do produto de um fornecedor,
	 * a partir do fornecedor, do nome do produto e da descricao do produto.
	 * 
	 * @param fornecedor e o nome do fornecedor ao qual o produto sera afiliado.
	 * @param nome e o nome do produto.
	 * @param descricao e a descricao do produto.
	 * @return retorna a representacao toString do produto.
	 */
	public String exibeProduto(String fornecedor, String nome, String descricao) {
		return sistema.exibeProduto(fornecedor, nome, descricao);
	}
	
	/**
	 * Retorna uma String listando todos os produto de um fornecedor, recebido por
	 * parametro.
	 * 
	 * @return retorna a representacao toString de todos os produtos de um fornecedor.
	 */
	public String listarProdutos(String fornecedor) {
		return sistema.listarProdutos(fornecedor);
	}
	
	/**
	 * Retorna uma String listando todos os produtos de todos os fornecedores.
	 * 
	 * @return retorna a representacao toString de todos os produtos de todos os fornecedores.
	 */
	public String listarProdutosTodosFornecedores() {
		return sistema.listarProdutosTodosFornecedores();
	}
	
	/**
	 * Edita o atributo do fornecedor, com o valor indicado pelo parametro.
	 * O nome e descricao irao identificar unicamente um produto, este produto
	 * sera verificado se existe no dado fornecedor. O unico atributo que pode
	 * ser alterado e o preco do produto, indicado por valor.
	 * 
	 * @param nome e o nome do produto.
	 * @param descricao e a descricao do produto.
	 * @param fornecedor e o nome do fornecedor ao qual o produto sera verificado se
	 * esta afiliado.
	 * @param preco e o preco a ser editado no dado produto do fornecedor.
	 * @return retorna o atributo que foi modificado caso a modificacao tenha
	 * sido efetuada com sucesso.
	 */
	public void editaProduto(String nome, String descricao, String fornecedor, double valor) {
		sistema.editaProduto(nome, descricao, fornecedor, valor);
	}
	
	/**
	 * Remove o produto de um fornecedor, identificando o produto atraves do nome
	 * e descricao.
	 * 
	 * @param fornecedor e o fornecedor em que sera removido o produto.
	 * @param nome e o nome do produto a ser removido.
	 * @param descricao e a descricao do produto a ser removido.
	 */
	public void removeProduto(String fornecedor, String nome, String descricao) {
		sistema.removeProduto(fornecedor, nome, descricao);
	}
	
	public static void main(String[] args) {
		args = new String[] { "saga.Saga", "testes_aceitacao/use_case_1.txt", "testes_aceitacao/use_case_2.txt", "testes_aceitacao/use_case_3.txt" };
		EasyAccept.main(args);
	}
}
