package saga;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Representacao de um Fornecedor no sistema. Todo fornecedor possui um nome
 * (seu identificador unico), um email, um telefone e um mapa de produtos,
 * IdProduto, Produto. O IdProduto sera utilizado para reobter o Produto.
 * 
 * @author Pedro Henrique
 */
public class Fornecedor implements Comparable<Fornecedor> {

	/**
	 * Controlador de produtos, vai controlar e organizar os produtos deste
	 * fornecedor.
	 */
	private ControllerProduto controladorProduto;

	/**
	 * Controlador das contas do cliente.
	 */
	private ControllerConta controladorConta;

	/**
	 * Nome do fornecedor, e o identificado unico.
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
	 * Constroi um novo fornecedor a partir de seu nome, email e telefone. Al�m de
	 * criar um contolador de produtos com o nome do fornecedor.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo." Caso o
	 * email seja nulo ou vazio sera lancado um IllegalArgumentException: "Erro no
	 * cadastro do fornecedor: email nao pode ser vazio ou nulo." Caso a localizacao
	 * seja nula ou vazia sera lancado um IllegalArgumentException: "Erro no
	 * cadastro do fornecedor: telefone nao pode ser vazio ou nulo."
	 * 
	 * @param nome     e o nome do fornecedor que sera seu identificador unico.
	 * @param email    e o email do fornecedor.
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
		this.controladorConta = new ControllerConta(nome);
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	/**
	 * Verifica se existe um produto no mapa produtos. O nome do produto e descricao
	 * do produto criam um novo IdProduto. Este IdProduto sera verificado se existe
	 * no mapa produtos. Retorna true caso o produto exista no mapa produtos, caso
	 * contrario, false.
	 * 
	 * @param nome      e nome do produto a ser verificado no mapa.
	 * @param descricao e a descricao do produto a ser verificado no mapa.
	 * @return retorna true caso o produto exista no mapa produtos, caso contrario,
	 *         false.
	 */
	public boolean existeProduto(String nome, String descricao) {
		if (controladorProduto.existeProduto(nome, descricao)) {
			return true;
		}
		return false;
	}

	/**
	 * Retorna true caso o fornecedor possua algum produto cadastrado. Caso nao
	 * possua, sera retornado false.
	 * 
	 * @return retorna true caso o mapa produtos possua algum elemento, caso
	 *         contrario, sera retornado false.
	 */
	public boolean possuiProduto() {
		if (!controladorProduto.possuiProduto()) {
			return true;
		}
		return false;
	}

	/**
	 * Adiciona um produto ao mapa produtos a partir de um nome, descricao e preco.
	 * Cria um id para o produto a partir de seu nome e descricao. E atribui esse id
	 * ao produto construido.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro de produto: nome nao pode ser vazio ou nulo." Caso a
	 * descricao seja nula ou vazia sera lancado um IllegalArgumentException: "Erro
	 * no cadastro de produto: descricao nao pode ser vazia ou nula." Caso ja exista
	 * o produto sera lancado um IllegalArgumentException: "Erro no cadastro de
	 * produto: produto ja existe."
	 * 
	 * @param nome      e nome do produto.
	 * @param descricao e a descricao do produto.
	 * @param preco     e o preco do produto.
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
	 * Retorna o toString de um produto a partir de seu nome e descricao, no
	 * formato: NOME - DESCRICAO - R$X,XX
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na exibicao de produto: nome nao pode ser vazio ou nulo." Caso a
	 * descricao seja nula ou vazia sera lancado um IllegalArgumentException: "Erro
	 * na exibicao de produto: descricao nao pode ser vazia ou nula." Caso o produto
	 * nao exista sera lancado um IllegalArgumentException: "Erro na exibicao de
	 * produto: produto nao existe."
	 * 
	 * @param nome      e o nome do produto que sera pesquisado.
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
	 * Lista todos os produtos deste fornecedor no formato: NOME1 - DESCRICAO1 -
	 * R$X,XX | NOME1 - DESCRICAO2 - R$X,XX | NOME1 - DESCRICAON - R$X,XX
	 * 
	 * @return retorna a representacao toString de todos os produtos deste
	 *         fornecedor.
	 */
	public String listarProdutos() {
		return this.controladorProduto.listarProdutos();
	}

	/**
	 * Edita o valor de um produto a partir de seu nome e de sua descricao.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na edicao de produto: nome nao pode ser vazio ou nulo." Caso a
	 * descricao seja nula ou vazia sera lancado um IllegalArgumentException: "Erro
	 * na edicao de produto: descricao nao pode ser vazia ou nula." Caso o novo
	 * preco seja menor que ou igual a 0 sera lancado um IllegalArgumentException:
	 * "Erro na edicao de produto: preco invalido." Caso o produto nao exista sera
	 * lancado uma excecao IllegalArgumentException: "Erro na edicao de produto:
	 * produto nao existe."
	 * 
	 * @param nome      e o nome do produto a ser editado.
	 * @param descricao e a descricao do produto a ser editado.
	 * @param valor     e o novo preco do produto que atualizara o atual.
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
	 * Remove um produto do mapa produtos a partir do nome do produto e da descricao
	 * do produto.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na remocao de produto: nome nao pode ser vazio ou nulo." Caso a
	 * descricao seja nula ou vazia sera lancado um IllegalArgumentException: "Erro
	 * na remocao de produto: descricao nao pode ser vazia ou nula." Caso o produto
	 * nao exista sera lancado uma excecao IllegalArgumentException: "Erro na
	 * remocao de produto: produto nao existe."
	 * 
	 * @param nome      e o nome do produto que sera removido.
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

	/**
	 * Recupera o preco do produto a partir de seu nome e descricao.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na remocao de produto: nome nao pode ser vazio ou nulo." Caso a
	 * descricao seja nula ou vazia sera lancado um IllegalArgumentException: "Erro
	 * na remocao de produto: descricao nao pode ser vazia ou nula."
	 * 
	 * @param nome      e o nome do produto.
	 * @param descricao e a descricao do produto.
	 * @return e retornado o preco do produto.
	 */
	private double getPrecoProduto(String nome, String descricao) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		if (descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");

		return this.controladorProduto.getPrecoProduto(nome, descricao);
	}

	/**
	 * Retorna a representacao String do Fornecedor, no formato: NOME - EMAIL -
	 * TELEFONE
	 */
	@Override
	public String toString() {
		return nome + " - " + email + " - " + telefone;
	}

	/**
	 * Adiciona uma nova compra ao controlador de contas. Passando o cpf cliente que
	 * efetuou a compra, o nome e descricao do produto da compra e o nome do
	 * cliente.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo." Caso
	 * a descricao seja nula ou vazia sera lancado um IllegalArgumentException:
	 * "Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula."
	 * Caso a data seja nula ou vazia sera lancado um IllegalArgumentException:
	 * "Erro ao cadastrar compra: data nao pode ser vazia ou nula." Caso o produto
	 * nao eixta sera lancado um IllegalArgumentException: "Erro ao cadastrar
	 * compra: produto nao existe." Caso a data seja invalida sera lancado um
	 * IllegalArgumentException: "Erro ao cadastrar compra: data invalida."
	 * 
	 * @param cpf       e o cpf do cliente.
	 * @param data      e a data da compra.
	 * @param nome      e o nome do produto da compra.
	 * @param descricao e a descricao do produto da compra.
	 * @param cliente   e o cliente que efetuou a compra.
	 */
	public void adicionaCompra(String cpf, String data, String nome, String descricao, String cliente) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
		if (descricao == null || descricao.equals(""))
			throw new IllegalArgumentException(
					"Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
		if (data == null || data.equals(""))
			throw new IllegalArgumentException("Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
		if (!existeProduto(nome, descricao))
			throw new IllegalArgumentException("Erro ao cadastrar compra: produto nao existe.");
		String[] valoresData = data.split("/");
		int dia, mes, ano;
		try {
			dia = Integer.parseInt(valoresData[0]);
			mes = Integer.parseInt(valoresData[1]);
			ano = Integer.parseInt(valoresData[2]);
		} catch (ArrayIndexOutOfBoundsException aiobe) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");
		}
		if (dia <= 0 || dia > 31 || mes <= 0 || mes > 12 || ano <= 1900
				|| ano > Calendar.getInstance().get(Calendar.YEAR))
			throw new IllegalArgumentException("Erro ao cadastrar compra: data invalida.");

		data = data.replace("/", "-");
		double preco = this.getPrecoProduto(nome, descricao);
		this.controladorConta.adicionaCompra(cpf, data, nome, descricao, cliente, preco);
	}

	/**
	 * Adiciona um combo ao controlador de produtos. O combo possui um nome,
	 * descricao, fator e uma lista de produtos que o compoe.
	 * 
	 * @param nome      e o nome do combo.
	 * @param descricao e a descricao do combo.
	 * @param fator     e o fator de desconto do combo.
	 * @param produtos  e a lista de produtos que compoem o combo.
	 */
	public void adicionaCombo(String nome, String descricao, double fator, String produtos) {
		this.controladorProduto.adicionaCombo(nome, descricao, fator, produtos);
	}

	/**
	 * Edita o fator de um combo a partir do nome e descricao do combo e o novo
	 * fator.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancada uma excecao: "Erro na edicao de
	 * combo: nome nao pode ser vazio ou nulo." Caso a descricao seja nulo ou vazio
	 * sera lancada uma excecao: "Erro na edicao de combo: descricao nao pode ser
	 * vazia ou nula." Caso o produto nao exista sera lancada uma excecao: "Erro na
	 * edicao de combo: produto nao existe."
	 * 
	 * @param nome      e o nome do combo.
	 * @param descricao e a descricao do combo.
	 * @param fator     e o novo fator do combo.
	 */
	public void editaCombo(String nome, String descricao, double fator) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro na edicao de combo: nome nao pode ser vazio ou nulo.");
		if (descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Erro na edicao de combo: descricao nao pode ser vazia ou nula.");
		if (!existeProduto(nome, descricao))
			throw new IllegalArgumentException("Erro na edicao de combo: produto nao existe.");

		this.controladorProduto.editaCombo(nome, descricao, fator);
	}

	/**
	 * Retorna as compras do controlador de contas.
	 * 
	 * @return retorna todas as compras do controlador de contas.
	 */
	public ArrayList<Compra> retornaCompras() {
		return controladorConta.retornaCompras();
	}

	/**
	 * Retorna o debito que um cliente possui neste fornecedor.
	 * 
	 * @param cpf e o cpf do cliente.
	 * @return e retornado o debito do cliente.
	 */
	public String getDebito(String cpf) {
		return this.controladorConta.getDebitoCliente(cpf);
	}

	public String getNome() {
		return this.nome;
	}

	public void setEmail(String valor) {
		this.email = valor;
	}

	public void setTelefone(String valor) {
		this.telefone = valor;
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

	@Override
	public int compareTo(Fornecedor o) {
		return this.nome.compareTo(o.nome);
	}

	/**
	 * Exibe todas as contas que um cliente possui neste fornecedor.
	 * 
	 * @param cpf e o cpf do cliente.
	 * @return e retornada uma String com a representacao de todas as contas de um
	 *         cliente.
	 */
	public String exibeContas(String cpf) {
		return this.controladorConta.exibeContas(cpf);
	}

	/**
	 * Retorna se o fornecedor possui conta com determinado cliente.
	 * 
	 * @param cpf e o cpf do cliente.
	 * @return e retornado um boolean se existe ou nao uma conta neste fornecedor.
	 */
	public boolean possuiConta(String cpf) {
		return this.controladorConta.existeConta(cpf);
	}

	/**
	 * Realiza o pagamento das contas de um cliente.
	 * 
	 * @param cpf e o cpf de um cliente.
	 */
	public void realizaPagamento(String cpf) {
		this.controladorConta.realizaPagamento(cpf);
	}
}
