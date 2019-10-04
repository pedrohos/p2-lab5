package saga;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Representacao do controlador do produto, ele possui um nome de um fornecedor
 * associado e um conjunto de produtos.
 * Cada fornecedor possui um controlador de produto.
 * 
 * @author Pedro Henrique
 */
public class ControllerProduto {
	
	private String fornecedor;
	
	/**
	 * Armazena no mapa de produtos o IdProduto de um produto, Produto.
	 */
	private HashMap<IdProduto, Produto> produtos;
	
	/**
	 * Constroi um contolador armazenando o nome do fornecedor que o criou no
	 * atributo fornecedor.
	 * 
	 * @param nome e o nome do fornecedor que sera armazenado no atributo.
	 */
	public ControllerProduto(String nome) {
		this.produtos =  new HashMap<>();
		this.fornecedor = nome;
	}
	
	/**
	 * Verifica se determinado produto existe no mapa produtos, baseando se no nome do produto
	 * e descricao do produto. 
	 * Retorna um boolean indicando true caso o forneceor possuia aquele produto, caso
	 * contrario, false.
	 * 
	 * @param nome e o nome do produto que sera verificado se existe no mapa produtos.
	 * @param descricao e a descricao do produto a a ser verificado se esta ligada a algum
	 * fornecedor do mapa fornecedores.
	 * @return retorna true caso o produto exista, false caso nao exista.
	 */
	public boolean existeProduto(String nome, String descricao) {
		if(this.produtos.containsKey(new IdProduto(nome, descricao))) {
			return true;
		}
		return false;
	}
	
	/**
	 * Associa um produto a lista produtos.
	 * O produto e criado a partir de um nome, descricao e preco.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro de produto: nome nao pode ser vazio ou nulo."
	 * Caso o descricao seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro de produto: descricao nao pode ser vazia ou nula."
	 * Caso o preco seja menor que ou igual a 0 sera lancado um IllegalArgumentException:
	 * "Erro na cadastro de produto: preco invalido."
	 * Caso o produto ja exista sera lancado um IllegalArgumentException:
	 * "Erro no cadastro de produto: produto ja existe."
	 * 
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
		if (existeProduto(nome, descricao))
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		
		this.produtos.put(new IdProduto(nome, descricao), new Produto(nome, descricao, preco));
	}
	
	/**
	 * Retorna a representacao String do produto de um fornecedor, o fornecedor sera indentificado
	 * pelo nome do fornecedor, o produto sera identificado a partir do seu id, que e composto por um
	 * nome por uma descricao.
	 * A representacao esta no formato:
	 * NOME - DESCRICAO - R$X,XX
	 * 
	 * Caso o nome do produto seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na exibicao de produto: nome nao pode ser vazio ou nulo."
	 * Caso a descricao do produto seja nula ou vazia sera lancado um IllegalArgumentException:
	 * "Erro na exibicao de produto: descricao nao pode ser vazia ou nula."
	 * Caso o produto nao exista sera lancado um IllegalArgumentException:
	 * "Erro na exibicao de produto: produto nao existe."
	 * 
	 * @param nome e o nome do produto que identificara o produto.
	 * @param descricao e a descricao do produto que identificara o produto.
	 * @return retorna a representacao toString do produto.
	 */
	public String exibeProduto(String nome, String descricao) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		if (descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		if (!existeProduto(nome, descricao))
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		
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
	 * Caso o preco seja menor que ou igual a 0 sera lancado um IllegalArgumentException:
	 * "Erro na edicao de produto: preco invalido."
	 * Caso o produto nao exista ser lancado um IllegalArgumentException:
	 * "Erro na edicao de produto: produto nao existe."
	 * 
	 * @param nome e o nome que ira identificar o produto unicamente. 
	 * @param descricao e a descricao que ira identificar o produto unicamente.
	 * @param valor e o novo valor que ira substituir o atual do produto.
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
		
		this.produtos.get(new IdProduto(nome, descricao)).setPreco(valor);
	}
	
	/**
	 * Remove um produto do mapa produtos a partir de um dado nome e descricao.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na remocao de produto: nome nao pode ser vazio ou nulo."
	 * Caso a descricao seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na remocao de produto: descricao nao pode ser vazia ou nula."
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
		if (!existeProduto(nome, descricao))
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		
		this.produtos.remove(new IdProduto(nome, descricao));
	}
	
	/**
	 * Retorna um boolean indicando se o controlador possui algum produto cadastrado no mapa
	 * produtos. E retorna true caso possui, false caso contrario
	 * 
	 * @return e retornado true caso exista algum produto, false caso contrario.
	 */
	public boolean possuiProduto() {
		if (produtos.isEmpty())
			return false;
		return true;
	}

	/**
	 * Retorna uma String listando todos os produtos deste controlador, no formato:
	 * FORNECEDOR - NOME1 - DESCRICAO1 - R$X,XX | FORNECEDOR - NOME2 - DESCRICAO2 - R$Y,YY | 
	 * FORNECEDOR - NOMEN - DESCRICAON - R$X,XX |
	 * @return
	 */
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
