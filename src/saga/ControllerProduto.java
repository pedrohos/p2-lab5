package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Representacao do controlador do produto, ele possui um nome de um fornecedor
 * associado e um conjunto de produtos. Cada fornecedor possui um controlador de
 * produto.
 * 
 * @author Pedro Henrique
 */
public class ControllerProduto {

	/**
	 * Armazena o nome do fornecedor que possui este controlador.
	 */
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
		this.produtos = new HashMap<>();
		this.fornecedor = nome;
	}

	/**
	 * Verifica se determinado produto existe no mapa produtos, baseando se no nome
	 * do produto e descricao do produto. Retorna um boolean indicando true caso o
	 * forneceor possuia aquele produto, caso contrario, false.
	 * 
	 * @param nome      e o nome do produto que sera verificado se existe no mapa
	 *                  produtos.
	 * @param descricao e a descricao do produto a a ser verificado se esta ligada a
	 *                  algum fornecedor do mapa fornecedores.
	 * @return retorna true caso o produto exista, false caso nao exista.
	 */
	public boolean existeProduto(String nome, String descricao) {
		IdProduto id = new IdProduto(nome, descricao);
		for (IdProduto chaves : produtos.keySet()) {
			if (chaves.equals(id)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Associa um produto a lista produtos. O produto e criado a partir de um nome,
	 * descricao e preco.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro de produto: nome nao pode ser vazio ou nulo." Caso o
	 * descricao seja nulo ou vazio sera lancado um IllegalArgumentException: "Erro
	 * no cadastro de produto: descricao nao pode ser vazia ou nula." Caso o preco
	 * seja menor que ou igual a 0 sera lancado um IllegalArgumentException: "Erro
	 * na cadastro de produto: preco invalido." Caso o produto ja exista sera
	 * lancado um IllegalArgumentException: "Erro no cadastro de produto: produto ja
	 * existe."
	 * 
	 * @param nome      e o nome do produto que sera passado em sua construcao.
	 * @param descricao e a descricao do produto que sera passado em sua construcao.
	 * @param preco     e o preco do produto que sera passado em sua construcao.
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
	 * Retorna a representacao String do produto de um fornecedor, o fornecedor sera
	 * indentificado pelo nome do fornecedor, o produto sera identificado a partir
	 * do seu id, que e composto por um nome por uma descricao. A representacao esta
	 * no formato: NOME - DESCRICAO - R$X,XX
	 * 
	 * Caso o nome do produto seja nulo ou vazio sera lancado um
	 * IllegalArgumentException: "Erro na exibicao de produto: nome nao pode ser
	 * vazio ou nulo." Caso a descricao do produto seja nula ou vazia sera lancado
	 * um IllegalArgumentException: "Erro na exibicao de produto: descricao nao pode
	 * ser vazia ou nula." Caso o produto nao exista sera lancado um
	 * IllegalArgumentException: "Erro na exibicao de produto: produto nao existe."
	 * 
	 * @param nome      e o nome do produto que identificara o produto.
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
	 * Edita o preco de um produto de fornecedor. O forncedor e identificado a
	 * partir do nome do fornecedor. O produto e identificado a partir do nome do
	 * produto e da descricao do produto.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na edicao de produto: nome nao pode ser vazio ou nulo." Caso a
	 * descricao seja nulo ou vazio sera lancado um IllegalArgumentException: "Erro
	 * na edicao de produto: descricao nao pode ser vazia ou nula." Caso o preco
	 * seja menor que ou igual a 0 sera lancado um IllegalArgumentException: "Erro
	 * na edicao de produto: preco invalido." Caso o produto nao exista ser lancado
	 * um IllegalArgumentException: "Erro na edicao de produto: produto nao existe."
	 * 
	 * @param nome      e o nome que ira identificar o produto unicamente.
	 * @param descricao e a descricao que ira identificar o produto unicamente.
	 * @param valor     e o novo valor que ira substituir o atual do produto.
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
	 * "Erro na remocao de produto: nome nao pode ser vazio ou nulo." Caso a
	 * descricao seja nulo ou vazio sera lancado um IllegalArgumentException: "Erro
	 * na remocao de produto: descricao nao pode ser vazia ou nula." Caso o produto
	 * nao exista ser lancado um IllegalArgumentException: "Erro na remocao de
	 * produto: produto nao existe."
	 * 
	 * @param nome       e o nome que ira identificar o produto unicamente.
	 * @param descricao  e a descricao que ira identificar o produto unicamente.
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
	 * Retorna um boolean indicando se o controlador possui algum produto cadastrado
	 * no mapa produtos. E retorna true caso possui, false caso contrario
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
	 * FORNECEDOR - NOME1 - DESCRICAO1 - R$X,XX | FORNECEDOR - NOME2 - DESCRICAO2 -
	 * R$Y,YY | FORNECEDOR - NOMEN - DESCRICAON - R$X,XX |
	 * 
	 * @return e retornado a representacao de todos os produtos no padrao acima.
	 */
	public String listarProdutos() {
		String resultado = "";

		ArrayList<Produto> valores = new ArrayList<>();
		for (Produto p : produtos.values())
			valores.add(p);
		Collections.sort(valores);

		Iterator<Produto> it = valores.iterator();
		if (!it.hasNext()) {
			return this.fornecedor + " -";
		}
		while (it.hasNext()) {
			Produto elemento = it.next();
			if (it.hasNext()) {
				resultado += this.fornecedor + " - " + elemento.toString() + " | ";
			} else {
				resultado += this.fornecedor + " - " + elemento.toString();
			}
		}
		return resultado;
	}

	/**
	 * Recupera o preco de um produto a partir de seu nome e descricao.
	 * 
	 * Caso o produto nao exista sera lancado um IllegalArgumentException: "Erro ao
	 * recuperar preco: produto nao existe."
	 * 
	 * @param nome      e o nome do produto.
	 * @param descricao e a descricao do produto.
	 * @return e retornado o preco do produto.
	 */
	public double getPrecoProduto(String nome, String descricao) {
		for (IdProduto id : produtos.keySet()) {
			if (id.equals(new IdProduto(nome, descricao))) {
				return this.produtos.get(id).getPreco();
			}
		}
		throw new IllegalArgumentException("Erro ao recuperar preco: produto nao existe.");
	}

	/**
	 * Adiciona um combo ao mapa de produtos. O combo e identificado a partir de um
	 * nome, descricao e fator de desconto e conjunto de produtos que formam este
	 * combo.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro de produto: nome nao pode ser vazio ou nulo." Caso o
	 * descricao seja nulo ou vazio sera lancado um IllegalArgumentException: "Erro
	 * no cadastro de produto: descricao nao pode ser vazia ou nula." Caso o preco
	 * seja menor que ou igual a 0 sera lancado um IllegalArgumentException: "Erro
	 * na cadastro de produto: preco invalido." Caso o produto ja exista sera
	 * lancado um IllegalArgumentException: "Erro no cadastro de produto: produto ja
	 * existe." Caso o conjunto de produtos que formam o combo sejam vazio ou nulo
	 * sera lancado um IllegalArgumentException: "Erro no cadastro de combo: combo
	 * deve ter produtos." Caso os produto que compoem o combo nao existam sera
	 * lancado um IllegalArgumentException: "Erro no cadastro de combo: produto nao
	 * existe." Caso os produtos que formam o combo seja um combo sera lancado um
	 * IllegalArgumentException: "Erro no cadastro de combo: um combo nao pode
	 * possuir combos na lista de produtos."
	 * 
	 * @param nome      e o nome do produto que sera passado em sua construcao.
	 * @param descricao e a descricao do produto que sera passado em sua construcao.
	 * @param preco     e o preco do produto que sera passado em sua construcao.
	 */
	public void adicionaCombo(String nome, String descricao, double fator, String produtos) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro no cadastro de combo: nome nao pode ser vazio ou nulo.");
		if (descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Erro no cadastro de combo: descricao nao pode ser vazia ou nula.");
		if (fator <= 0 || fator == 1)
			throw new IllegalArgumentException("Erro no cadastro de combo: fator invalido.");
		if (existeProduto(nome, descricao))
			throw new IllegalArgumentException("Erro no cadastro de combo: combo ja existe.");
		if (produtos == null || produtos == "")
			throw new IllegalArgumentException("Erro no cadastro de combo: combo deve ter produtos.");
		double preco = 0;
		String[] produtosSeparados = produtos.split(", ");
		for (String s : produtosSeparados) {
			String[] nomeEDescricao = s.split(" - ");
			if (nomeEDescricao.length != 2)
				throw new IllegalArgumentException("Erro no cadastro de combo: combo deve ter produtos.");
			String nomeProduto = nomeEDescricao[0];
			String descricaoProduto = nomeEDescricao[1];

			if (!existeProduto(nomeProduto, descricaoProduto))
				throw new IllegalArgumentException("Erro no cadastro de combo: produto nao existe.");
			if (this.produtos.get(new IdProduto(nomeProduto, descricaoProduto)) instanceof ProdutoCombo)
				throw new IllegalArgumentException(
						"Erro no cadastro de combo: um combo nao pode possuir combos na lista de produtos.");
			preco += this.produtos.get(new IdProduto(nomeProduto, descricaoProduto)).getPreco();
		}

		this.produtos.put(new IdProduto(nome, descricao), new ProdutoCombo(nome, descricao, preco, fator, produtos));
	}

	/**
	 * Substitui o fator atual de um combo por um novo. O combo e identificado a
	 * partir de seu nome e descricao, e e trocado seu fator atual pelo passado pelo
	 * parametro.
	 * 
	 * Caso o combo nao exista sera lancado um IllegalArgumentException: "Erro na
	 * edicao de combo: produto nao existe." Caso o fator seja negativo ou igual a 1
	 * sera lancado um IllegalArgumentException: "Erro na edicao de combo: fator
	 * invalido."
	 * 
	 * @param nome      e o nome do combo.
	 * @param descricao e a descricao do combo.
	 * @param fator     e o fator de desconto do combo.
	 */
	public void editaCombo(String nome, String descricao, double fator) {
		if (!existeProduto(nome, descricao))
			throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");
		if (fator <= 0 || fator == 1)
			throw new IllegalArgumentException("Erro na edicao de combo: fator invalido.");
		ProdutoCombo combo = (ProdutoCombo) this.produtos.get(new IdProduto(nome, descricao));
		combo.editaCombo(fator);
	}
}
