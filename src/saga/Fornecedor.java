package saga;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Representacao de um Fornecedor no sistema.
 * Todo cliente possui um nome (seu identificador unico), um email, um telefone
 * e um mapa de produtos, IdProduto, Produto.
 * O IdProduto sera utilizado para reobter o Produto.
 * 
 * @author Pedro Henrique
 */
public class Fornecedor {
	
	private ControllerProduto controladorProduto;
	
	/**
	 * Nome do fornecedor.
	 */
	private String nome;
	
	/**
	 * Email do fornecedor.
	 */
	private String email;
	
	/**
	 * Telefone do fornecedor.
	 */
	private String telefone;
	
	/**
	 * Constroi um novo fornecedor a partir de seu nome, email e telefone.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo."
	 * Caso o email seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo."
	 * Caso a localizacao seja nula ou vazia sera lancado um IllegalArgumentException:
	 * "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo."
	 * 
	 * @param nome e o nome do fornecedor que sera seu identificador unico.
	 * @param email e o email do fornecedor.
	 * @param telefone e o telefone do fornecedor.
	 */
	public Fornecedor(String nome, String email, String telefone) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if (email == null || email.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		if (telefone == null || telefone.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
		
		this.controladorProduto = new ControllerProduto(nome);
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
	/**
	 * Verifica se existe um produto no mapa produtos.
	 * O nome do produto e descricao do produto criam um novo IdProduto.
	 * Este IdProduto sera verificado se existe no mapa produtos. 
	 * Retorna true caso o produto exista no mapa produtos, caso contrario, false.
	 * 
	 * @param nome e nome do produto a ser verificado no mapa.
	 * @param descricao e a descricao do produto a ser verificado no mapa.
	 * @return retorna true caso o produto exista no mapa produtos, caso contrario,
	 * false. 
	 */
	public boolean existeProduto(String nome, String descricao) {
		if(controladorProduto.existeProduto(nome, descricao)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna true caso o fornecedor possuir algum produto cadastrado.
	 * Caso nao possuir, sera retornado false.
	 * 
	 * @return retorna true caso o mapa produtos possua algum elemento, caso contrario,
	 * sera retornado false.
	 */
	public boolean possuiProduto() {
		if (!controladorProduto.possuiProduto()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Adiciona um produto ao mapa produtos a partir de um nome, decricao e preco.
	 * Cria um id para o produto a partir de seu nome e descricao.
	 * E atribui esse id ao produto construido.
	 * 
	 * @param nome e nome do produto.
	 * @param descricao e a descricao do produto.
	 * @param preco e o preco do produto.
	 */
	public void adicionaProduto(String nome, String descricao, double preco) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		if (descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		if (existeProduto(nome, descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		this.controladorProduto.adicionaProduto(nome, descricao, preco);
	}
	
	/**
	 * Retorna o toString de um produto a partir de seu nome e descricao, no formato:
	 * NOME - DESCRICAO - R$X,XX
	 * 
	 * @param nome e o nome do produto que sera pesquisado.
	 * @param descricao e a descricao do produto que sera pesquisado.
	 * @return retorna a representacao toString do produto.
	 */
	public String exibeProduto(String nome, String descricao) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		if (descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		if (existeProduto(nome, descricao)) {
			return this.controladorProduto.exibeProduto(nome, descricao);
		}
		throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		
	}
	
	/**
	 * Lista todos os produtos de um fornecedor no formato:
	 * NOME1 - DESCRICAO1 - R$X,XX | NOME2 - DESCRICAO2 - R$X,XX | NOMEN - DESCRICAON - R$X,XX
	 * 
	 * Caso o fornecedor nao exista ser lancado um IllegalArgumentException:
	 * "Erro na exibicao de produto: fornecedor nao existe."
	 * 
	 * @param fornecedor e o fornecedor no qual sera verificado listado todos os seus produtos.
	 * @return retorna a representacao toString de todos os produtos.
	 */
	public String listarProdutos() {
		return this.controladorProduto.listarProdutos();
	}
	
	/**
	 * Edita o valor de um produto a partir de seu nome e de sua descricao.
	 * 
	 * Caso o produto nao exista sera lancado uma excecao IllegalArgumentException:
	 * "Erro na edicao de produto: produto nao existe."
	 * 
	 * @param nome e o nome do produto a ser editado.
	 * @param descricao e a descricao do produto a ser editado.
	 * @param valor e o novo preco do produto que atualizara o atual.
	 */
	public void editaProduto(String nome, String descricao, double valor) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		if (descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		if (valor <= 0)
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
	
		if (!existeProduto(nome, descricao))
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		
		this.controladorProduto.editaProduto(nome, descricao, valor);
	}
	
	/**
	 * Remove um produto do mapa produtos a partir do nome do produto e
	 * da descricao do produto.
	 * 
	 * @param nome e o nome do produto que sera removido.
	 * @param descricao e a descricao do produto que sera removido.
	 */
	public void removeProduto(String nome, String descricao) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		if (descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
	
		if (!existeProduto(nome, descricao)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
		
		this.controladorProduto.removeProduto(nome, descricao);
	}
	
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Modifica o atributo email pelo valor recebido.
	 * 
	 * @param valor e o valor que sera adicionado no atributo email.
	 */
	public void setEmail(String valor) {
		this.email = valor;
	}
	
	/**
	 * Modifica o atributo telefone pelo valor recebido.
	 * 
	 * @param valor e o valor que sera adicionado no atributo telefone.
	 */
	public void setTelefone(String valor) {
		this.telefone = valor;
	}

	/**
	 * Retorna a representacao toString do Fornecedor, no formato:
	 * NOME - EMAIL - TELEFONE
	 */
	@Override
	public String toString() {
		return nome + " - " + email + " - " + telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Compara se dois fornecedores sao iguais pelos seus nomes.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}


}
