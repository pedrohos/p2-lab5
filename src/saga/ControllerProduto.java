package saga;

import java.util.HashMap;
import java.util.Iterator;

public class ControllerProduto {
	
	private String fornecedor;
	
	/**
	 * Armazena no mapa de produtos o IdProduto de um produto, Produto.
	 */
	private HashMap<IdProduto, Produto> produtos;
	
	public ControllerProduto(String nome) {
		this.produtos =  new HashMap<>();
		this.fornecedor = nome;
	}
	
	/**
	 * Verifica se um fornecedor possui um produto a partir do nome do produto e da
	 * descricao do produto. Ao recuperar um Fornecedor no mapa fornecedores.
	 * E passado ao metodo existeProduto de fornecedor um nome do produto e sua descricao.s 
	 * Retorna um boolean indicando true caso o forneceor possuia aquele produto, caso
	 * contrario, false.
	 * 
	 * @param fornecedor e o fornecedor no qual sera verificado o produto, atraves da
	 * recuperacao de um Fornecedor no mapa fornecedores.
	 * @param nome e o nome do produto a a ser verificado se esta ligada a algum
	 * fornecedor do mapa fornecedores.
	 * @param descricao e a descricao do produto a a ser verificado se esta ligada a algum
	 * fornecedor do mapa fornecedores.
	 * @return retorna true caso fornecedor exista, false caso nao exista.
	 */
	public boolean existeProduto(String nome, String descricao) {
		if(this.produtos.containsKey(new IdProduto(nome, descricao))) {
			return true;
		}
		return false;
	}
	
	/**
	 * Associa um produto a um fornecedor.
	 * O produto e criado a partir de um nome, descricao e preco.
	 * 
	 * Caso o nome do fornecedor seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo."
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro de produto: nome nao pode ser vazio ou nulo."
	 * Caso o descricao seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro de produto: descricao nao pode ser vazia ou nula."
	 * Caso o preco seja menor que ou igual a 0 sera lancado um IllegalArgumentException:
	 * "Erro na cadastro de produto: preco invalido."
	 * Caso o fornecedor nao exista sera lancado um IllegalArgumentException:
	 * "Erro no cadastro de produto: fornecedor nao existe."
	 * Caso o produto ja exista sera lancado um IllegalArgumentException:
	 * "Erro no cadastro de produto: produto ja existe."
	 * 
	 * @param fornecedor e o nome do fornecedor que sera adicionado o produto.
	 * @param nome e o nome do produto que sera passado em sua construcao.
	 * @param descricao e a descricao do produto que sera passado em sua construcao.
	 * @param preco e o preco do produto que sera passado em sua construcao.
	 */
	public void adicionaProduto(String nome, String descricao, double preco) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		if (descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		if (preco <= 0)
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		
		this.produtos.put(new IdProduto(nome, descricao), new Produto(nome, descricao, preco));
	}
	
	/**
	 * Retorna a representacao toString do produto de um fornecedor, o fornecedor sera indentificado
	 * pelo nome do fornecedor, o produto sera identificado a partir do seu id, que e composto por um
	 * nome por uma descricao.
	 * A representacao esta no formato:
	 * NOME - DESCRICAO - R$X,XX
	 * 
	 * Caso o nome do fornecedor seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo."
	 * Caso o nome do produto seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na exibicao de produto: nome nao pode ser vazio ou nulo."
	 * Caso a descricao do produto seja nula ou vazia sera lancado um IllegalArgumentException:
	 * "Erro na exibicao de produto: descricao nao pode ser vazia ou nula."
	 * Caso o fornecedor nao exista ser lancado um IllegalArgumentException:
	 * "Erro na exibicao de produto: fornecedor nao existe."
	 * Caso o produto nao exista ser lancado um IllegalArgumentException:
	 * "Erro na exibicao de produto: produto nao existe."
	 * 
	 * @param nome e o nome do produto que identificara o produto.
	 * @param descricao e a descricao do produto que identificara o produto.
	 * @param fornecedor e o nome do fornecedor que sera utilizado para recuperar o produto.
	 * @return retorna a representacao toString do produto.
	 */
	public String exibeProduto(String nome, String descricao) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		if (descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		
		return this.produtos.get(new IdProduto(nome, descricao)).toString();
	}
	
	/**
	 * Edita o preco de um produto de fornecedor. O forncedor e identificado a partir do nome
	 * do fornecedor. O produto e identificado a partir do nome do produto e da descricao do
	 * produto.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na edicao de produto: nome nao pode ser vazio ou nulo."
	 * Caso a descricao seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na edicao de produto: descricao nao pode ser vazia ou nula."
	 * Caso o nome do fornecedor seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo."
	 * Caso o preco seja menor que ou igual a 0 sera lancado um IllegalArgumentException:
	 * "Erro na edicao de produto: preco invalido."
	 * Caso o fornecedor nao exista ser lancado um IllegalArgumentException:
	 * "Erro na edicao de produto: fornecedor nao existe."
	 * Caso o produto nao exista ser lancado um IllegalArgumentException:
	 * "Erro na edicao de produto: produto nao existe."
	 * 
	 * @param nome e o nome que ira identificar o produto unicamente. 
	 * @param descricao e a descricao que ira identificar o produto unicamente.
	 * @param fornecedor e o nome do fornecedor no qual sera procurado o produto a ser
	 * editado.
	 * @param valor e o novo valor que ira substituir o atual do produto.
	 */
	public void editaProduto(String nome, String descricao, double valor) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		if (descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		if (valor <= 0)
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		
		this.produtos.get(new IdProduto(nome, descricao)).setPreco(valor);
	}
	
	/**
	 * Remove um fornecedor do mapa fornecedores a partir de um dado nome.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na remocao de produto: nome nao pode ser vazio ou nulo."
	 * Caso a descricao seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na remocao de produto: descricao nao pode ser vazia ou nula."
	 * Caso o nome do fornecedor seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo."
	 * Caso o fornecedor nao exista ser lancado um IllegalArgumentException:
	 * "Erro na remocao de produto: fornecedor nao existe."
	 * Caso o produto nao exista ser lancado um IllegalArgumentException:
	 * "Erro na remocao de produto: produto nao existe."
	 * 
	 * @param nome e o nome que ira identificar o produto unicamente. 
	 * @param descricao e a descricao que ira identificar o produto unicamente.
	 * @param fornecedor e o fornecedor no qual sera deletado o produto.
	 */
	public void removeProduto(String nome, String descricao) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		if (descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		
		this.produtos.remove(new IdProduto(nome, descricao));
	}

	public boolean possuiProduto() {
		if (produtos.isEmpty())
			return false;
		return true;
	}

	public String listarProdutos() {
		String resultado = "";
		Iterator<Produto> it = produtos.values().iterator();
		while(it.hasNext()) {
			Produto elemento = it.next();
			if (it.hasNext()) {
				resultado += this.fornecedor + " - " + elemento.toString() + " | ";
			} else {
				resultado += this.fornecedor  + " - " + elemento.toString();
			}
		}
		return resultado;
	}
}
