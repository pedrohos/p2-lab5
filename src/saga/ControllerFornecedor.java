package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Representacao do controlador de fornecedores do sistema.
 * 
 * @author Pedro Henrique
 */
public class ControllerFornecedor {

	private Criterio criterio;
	
	/**
	 * Armazena no mapa de fornecedores o nome do Fornecedor, Fornecedor.
	 */
	private HashMap<String, Fornecedor> fornecedores;

	/**
	 * Constroi os mapas de fornecedores.
	 */
	public ControllerFornecedor() {
		this.fornecedores = new HashMap<>();
	}

	/**
	 * Verifica se um fornecedor existe no mapa fornecedores a partir de seu nome.
	 * Retorna um boolean indicando true caso o fornecedor exista, caso contrario,
	 * false.
	 * 
	 * @param nome e o nome do fornecedor a sera verificado se esta ligada a algum
	 *             fornecedor no mapa fornecedores.
	 * @return retorna true caso fornecedor exista, false caso nao exista.
	 */
	private boolean existeFornecedor(String nome) {
		if (this.fornecedores.containsKey(nome)) {
			return true;
		}
		return false;
	}

	/**
	 * Adiciona um fornecedor ao mapa de fornecedores a partir de seu nome, que sera
	 * seu identificador unico. O fornecedor e criado a partir de um nome, email e
	 * telefone. Caso a adicao tenha sido efetuada com sucesso sera retornado o
	 * nome.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo." Caso o
	 * email seja nulo ou vazio sera lancado um IllegalArgumentException: "Erro no
	 * cadastro do fornecedor: email nao pode ser vazio ou nulo." Caso o telefone
	 * seja nulo ou vazio sera lancado um IllegalArgumentException: "Erro no
	 * cadastro do fornecedor: telefone nao pode ser vazio ou nulo."
	 * 
	 * @param nome     e o nome do fornecedor que sera passado em sua construcao.
	 * @param email    e o email do fornecedor que sera passado em sua construcao.
	 * @param telefone e o telefone do cliente que sera passado em sua construcao.
	 * @return retorna o nome do fornecedor caso ele tenha sido adiiconado com
	 *         sucesso.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		if (email == null || email.equals(""))
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		if (telefone == null || telefone.equals(""))
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");

		if (!this.existeFornecedor(nome)) {
			this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
			return nome;
		}
		throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
	}

	/**
	 * Retorna a representacao toString do fornecedor a partir de seu nome, no
	 * formato: NOME - EMAIL - TELEFONE
	 * 
	 * Caso o nome do fornecedor seja nulo ou vazio sera lancado um
	 * IllegalArgumentException: "Erro na exibicao do fornecedor: nome nao pode ser
	 * vazio ou nulo." Caso o fornecedor nao exista sera lancado um
	 * IllegalArgumentException: "Erro na exibicao do fornecedor: fornecedor nao
	 * existe."
	 * 
	 * @param nome e o nome do fornecedor que sera utilizado para recuperar o
	 *             fornecedor no mapa fornecedores.
	 * @return retorna a representacao toString do fornecedor.
	 */
	public String exibeFornecedor(String nome) {
		if (nome == null | nome.equals(""))
			throw new IllegalArgumentException("Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
		if (this.existeFornecedor(nome)) {
			return this.fornecedores.get(nome).toString();
		}
		throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
	}

	/**
	 * Lista todos os fornecedores pela sua representacao toString, no formato:
	 * NOME1 - EMAIL1 - TELEFONE1 | NOME2 - EMAIL2 - TELEFONE2 | NOMEN - EMAILN -
	 * TELEFONEN
	 * 
	 * @return retorna a representacao toString de todos os fornecedores do sistema.
	 */
	public String exibeFornecedores() {
		String resultado = "";
		if (!fornecedores.isEmpty()) {

			ArrayList<Fornecedor> valores = new ArrayList<>();
			for (Fornecedor f : fornecedores.values())
				valores.add(f);
			Collections.sort(valores);

			Iterator<Fornecedor> it = valores.iterator();
			while (it.hasNext()) {
				Fornecedor elemento = it.next();
				if (it.hasNext()) {
					resultado += elemento.toString() + " | ";
				} else {
					resultado += elemento.toString();
				}
			}
		}
		return resultado;
	}

	/**
	 * Permite a edicao do valor atual de um atributo do fornecedor, e atualizado
	 * com um novo valor. O nome e utilizado para recuperar o fornecedor no mapa
	 * fornecedores. O valor do atributo indicado sera substituido pelo valor
	 * recebido por parametro. Caso a edicao tenha sido efetuada com sucesso sera
	 * retornado o nome do atributo que foi alterado. O nome nao pode ser alterado.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo." Caso o
	 * atributo seja nulo ou vazio sera lancado um IllegalArgumentException: "Erro
	 * na edicao do fornecedor: atributo nao pode ser vazio ou nulo." Caso o valor
	 * seja nulo ou vazio sera lancado um IllegalArgumentException: "Erro na edicao
	 * do fornecedor: novo valor nao pode ser vazio ou nulo." Caso o nome tente ser
	 * alterado sera lancado um IllegalArgumentException: "Erro na edicao do
	 * fornecedor: nome nao pode ser editado." Caso o atributo nao exista sera
	 * lancado um IllegalArgumentException: "Erro na edicao do fornecedor: atributo
	 * nao existe." Caso o nome nao remeta a nenhum fronecedor no mapa de clientes
	 * sera lancado um IllegalArgumentException: "Erro na edicao do fornecedor:
	 * fornecedor nao existe."
	 * 
	 * @param nome     e o nome do fornecedor que sera utilizado para recuperar o
	 *                 fornecedor no mapa fornecedores.
	 * @param atributo e o atributo cujo seu valor sera alterado.
	 * @param valor    e o valor que ira substituir o valor atual do atributo.
	 * @return retorna o nome do atributo que foi alterado.
	 */
	public String editaFornecedor(String nome, String atributo, String valor) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		if (valor == null || valor.equals(""))
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		if (atributo == null || atributo.equals(""))
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");

		if (existeFornecedor(nome)) {
			switch (atributo) {
			case "nome":
				throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
			case "email":
				this.fornecedores.get(nome).setEmail(valor);
				return "Email";
			case "telefone":
				this.fornecedores.get(nome).setTelefone(valor);
				return "Telefone";
			default:
				throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
			}
		}
		throw new IllegalArgumentException("Erro na edicao do fornecedor: fornecedor nao existe.");
	}

	/**
	 * Remove um fornecedor do mapa fornecedores a partir de um dado nome.
	 * 
	 * Caso o nome seja vazio ou nulo sera lancado um IllegalArgumentException:
	 * "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou
	 * nulo." Caso o fornecedor nao exista sera lancado um IllegalArgumentException:
	 * "Erro na remocao do fornecedor: fornecedor nao existe."
	 * 
	 * @param nome e atributo que ira identificar o fornecedor no mapa fornecedores.
	 */
	public void removeFornecedor(String nome) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException(
					"Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");

		if (!existeFornecedor(nome)) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
		fornecedores.remove(nome);
	}

	/**
	 * Lista todos os produtos de um fornecedor no formato: NOME1 - DESCRICAO1 -
	 * R$X,XX | NOME2 - DESCRICAO2 - R$X,XX | NOMEN - DESCRICAON - R$X,XX
	 * 
	 * Caso o fornecedor seja vazio ou nulo sera lancado um
	 * IllegalArgumentException: "Erro na exibicao de produto: fornecedor nao pode
	 * ser vazio ou nulo." Caso o fornecedor nao exista sera lancado um
	 * IllegalArgumentException: "Erro na exibicao de produto: fornecedor nao
	 * existe."
	 * 
	 * @param fornecedor e o fornecedor no qual sera verificado listado todos os
	 *                   seus produtos.
	 * @return retorna a representacao toString de todos os produtos.
	 */
	public String exibeProdutos(String fornecedor) {
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if (!existeFornecedor(fornecedor))
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");

		return fornecedores.get(fornecedor).listarProdutos();
	}

	/**
	 * Lista todos os produtos de todos os fornecedores no formato: FORNECEDOR1 -
	 * NOME1 - DESCRICAO1 - R$X,XX | FORNECEDOR1 - NOME2 - DESCRICAO2 - R$Y,YY
	 * FORNECEDORX - NOMEX - DESCRICAOX - R$Z,ZZ
	 * 
	 * @return retorna todos os produtos de todos os fornecedores.
	 */
	public String exibeProdutos() {
		String resultado = "";
		if (!fornecedores.isEmpty()) {
			ArrayList<Fornecedor> valores = new ArrayList<>();
			for (Fornecedor f : fornecedores.values())
				valores.add(f);
			Collections.sort(valores);

			Iterator<Fornecedor> it = valores.iterator();
			while (it.hasNext()) {
				Fornecedor elemento = it.next();
				if (it.hasNext()) {
					resultado += elemento.listarProdutos() + " | ";
				} else {
					resultado += elemento.listarProdutos();
				}
			}
		}
		return resultado;
	}

	/**
	 * Adiciona um produto a um fornecedor do mapa fornecedores.
	 * 
	 * Caso o fornecedor seja vazio ou nulo sera lancado um
	 * IllegalArgumentException: "Erro no cadastro de produto: fornecedor nao pode
	 * ser vazio ou nulo." Caso o fornecedor nao exista sera lancado um
	 * IllegalArgumentException: "Erro no cadastro de produto: fornecedor nao
	 * existe."
	 * 
	 * @param fornecedor e o fornecedor no qual vai ter um produto associado a ele.
	 * @param nome       e o nome do produto que vai ser cadastrado.
	 * @param descricao  e a descricao do produto que vai ser cadastrado.
	 * @param preco      e o preco do produto que vai ser cadastrado.
	 */
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		if (!existeFornecedor(fornecedor))
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");

		this.fornecedores.get(fornecedor).adicionaProduto(nome, descricao, preco);
	}

	/**
	 * Retorna representacao String do produto de um determinado fornecedor do mapa
	 * fornecedores.
	 * 
	 * Caso o fornecedor seja vazio ou nulo sera lancado um
	 * IllegalArgumentException: "Erro no cadastro de produto: fornecedor nao pode
	 * ser vazio ou nulo." Caso o fornecedor nao exista sera lancado um
	 * IllegalArgumentException: "Erro no cadastro de produto: fornecedor nao
	 * existe."
	 * 
	 * @param fornecedor e o fornecedor no qual vai ter um produto associado a ele.
	 * @param nome       e o nome do produto que vai ser cadastrado.
	 * @param descricao  e a descricao do produto que vai ser cadastrado.
	 * @return sera retornado a representacao toString daquele do produto indicado
	 *         do fornecedor indicado.
	 */
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if (!existeFornecedor(fornecedor))
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");

		return this.fornecedores.get(fornecedor).exibeProduto(nome, descricao);
	}

	/**
	 * Edita o preco de um determinado produto de um fornecedor do mapa
	 * fornecedores. O fornecedor e o fornecedor que tera seu produto modificado, o
	 * nome e descricao se referem as informacoes do produto e o preco e o novo
	 * valor do produto.
	 * 
	 * Caso o fornecedor seja vazio ou nulo sera lancado um
	 * IllegalArgumentException: "Erro no cadastro de produto: fornecedor nao pode
	 * ser vazio ou nulo." Caso o fornecedor nao exista sera lancado um
	 * IllegalArgumentException: "Erro no cadastro de produto: fornecedor nao
	 * existe."
	 * 
	 * @param fornecedor e o fornecedor no qual vai ter um produto associado a ele.
	 * @param nome       e o nome do produto que vai ser editado.
	 * @param descricao  e a descricao do produto que vai ser editado.
	 * @param valor      e o novo preco do produto.
	 */
	public void editaProduto(String nome, String descricao, String fornecedor, double valor) {
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if (!existeFornecedor(fornecedor))
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");

		this.fornecedores.get(fornecedor).editaProduto(nome, descricao, valor);
	}

	/**
	 * Remove um produto de um fornecedor. O fornecedor identifica o fornecedor no
	 * mapa fornecedores. O nome e descricao indentificam o produto do fornecedor.
	 * 
	 * Caso o fornecedor seja vazio ou nulo sera lancado um
	 * IllegalArgumentException: "Erro no cadastro de produto: fornecedor nao pode
	 * ser vazio ou nulo." Caso o fornecedor nao exista sera lancado um
	 * IllegalArgumentException: "Erro no cadastro de produto: fornecedor nao
	 * existe."
	 * 
	 * @param fornecedor e o fornecedor no qual vai ter um produto associado a ele.
	 * @param nome       e o nome do produto que vai ser removido.
	 * @param descricao  e a descricao do produto que vai ser removido.
	 */
	public void removeProduto(String nome, String descricao, String fornecedor) {
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		if (!existeFornecedor(fornecedor))
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");

		this.fornecedores.get(fornecedor).removeProduto(nome, descricao);
	}
	
	/**
	 * Adiciona um compra na conta de um cliente em dado fornecedor.
	 * A compra e referente a um produto (que possui nome e descricao) e possui
	 * data, todos esse dados sao registrados na compra.
	 * 
	 * @param cpf e o cpf do cliente que efetuou a compra.
	 * @param fornecedor e o nome do fornecedor que 
	 * @param data e a data da compra.
	 * @param nome e o nome do produto.
	 * @param descricao e a descricao do produto.
	 * @param cliente e o cliente que efetuou a compra.
	 */
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome, String descricao, String cliente) {
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
		if(!existeFornecedor(fornecedor))
			throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao existe.");
		
		this.fornecedores.get(fornecedor).adicionaCompra(cpf, data, nome, descricao, cliente);
	}
	
	/**
	 * Cadastra um combo em determinado fornecedor.
	 * O combo e identificado pelo e nome e descricao e possui um fator que representa
	 * o desconto, além de uma lista de produtos que indicam os produtos que formam este combo.
	 * 
	 * @param fornecedor e o fornecedor que tera o combo cadastrado.
	 * @param nome e o nome do combo que sera cadastrado.
	 * @param descricao e a descricoa do combo que sera cadastrado.
	 * @param fator e o fator que representa o desconto do combo.
	 * @param produtos e a lista de produtos que formam o combo.
	 */
	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao pode ser vazio ou nulo.");
		if (!existeFornecedor(fornecedor))
			throw new IllegalArgumentException("Erro no cadastro de combo: fornecedor nao existe.");
		
		this.fornecedores.get(fornecedor).adicionaCombo(nome, descricao, fator, produtos);
	}

	/**
	 * Edita o fator de um combo de um fornecedor a partir do nome e descricao do combo.
	 * 
	 * @param fornecedor e o fornecedor que tera o combo cadastrado.
	 * @param nome e o nome do combo que sera cadastrado.
	 * @param descricao e a descricoa do combo que sera cadastrado.
	 * @param fator e o novo fator que representa o desconto do combo.
	 */
	public void editaCombo(String fornecedor, String nome, String descricao, double fator) {
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao pode ser vazio ou nulo.");
		if (!existeFornecedor(fornecedor))
			throw new IllegalArgumentException("Erro na edicao de combo: fornecedor nao existe.");
		
		this.fornecedores.get(fornecedor).editaCombo(nome, descricao, fator);
	}

	/**
	 * Retorna o debito que um cliente tem com um dado fornecedor. 
	 * 
	 * @param cpf e o cpf do cliente.
	 * @param fornecedor o nome do fornecedor.
	 * @return e retornado o debito do cliente e fornecedor.
	 */
	public String getDebito(String cpf, String fornecedor) {
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
		if (!existeFornecedor(fornecedor))
			throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
		
		return this.fornecedores.get(fornecedor).getDebito(cpf);
	}

	public String exibeContas(String cpf, String fornecedor, String cliente) {
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
		if (!existeFornecedor(fornecedor))
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
		
		String resultado = "Cliente: " + cliente + " | ";
		ArrayList<Fornecedor> fornecedoresComConta = new ArrayList<>();
		if (!fornecedores.isEmpty()) {
			for (Fornecedor f: fornecedores.values()) {
				if (f.getNome().equals(fornecedor) && f.possuiConta(cpf)) {
					fornecedoresComConta.add(f);
				}
			}
			if (fornecedoresComConta.isEmpty())
				throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao tem nenhuma conta com o fornecedor.");
		}
		return resultado + iteraPelasContas(cpf, fornecedoresComConta);
	}
	
	public String exibeContasClientes(String cpf, String cliente) {
		
		String resultado = "Cliente: " + cliente + " | ";
		ArrayList<Fornecedor> fornecedoresComConta = new ArrayList<>();
		if (!fornecedores.isEmpty()) {
			for (Fornecedor f: fornecedores.values()) {
				if (f.possuiConta(cpf)) {
					fornecedoresComConta.add(f);
				}
			}
			if (fornecedoresComConta.isEmpty())
				throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao tem nenhuma conta.");
			Collections.sort(fornecedoresComConta);
		}
		return resultado + iteraPelasContas(cpf, fornecedoresComConta);
	}
	
	private String iteraPelasContas(String cpf, ArrayList<Fornecedor> fornecedoresComConta) {
		String resultado = "";
		Iterator<Fornecedor> it = fornecedoresComConta.iterator();
		while (it.hasNext()) {
			Fornecedor elemento = it.next();
			resultado += elemento.getNome() + " | ";
			if (it.hasNext()) {
				resultado += elemento.exibeContas(cpf) + " | ";
			} else {
				resultado += elemento.exibeContas(cpf);
			}
		}
		return resultado;
	}

	public void realizaPagamento(String cpf, String fornecedor) {
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");
		if (!existeFornecedor(fornecedor))
			throw new IllegalArgumentException("Erro no pagamento de conta: fornecedor nao existe.");
		
		this.fornecedores.get(fornecedor).realizaPagamento(cpf);
	}

	public void ordenaPor(String criterio) {
		switch (criterio) {
			case "Cliente":
				this.criterio = new OrdenaCliente();
				break;
			case "Fornecedor":
				this.criterio = new OrdenaFornecedor();
				break;
			case "Data":
				this.criterio = new OrdenaCompra();
				break;
			default:
				throw new IllegalArgumentException("Erro na listagem de compras: criterio nao oferecido pelo sistema.");
		}
	}
	
	private ArrayList<Compra> processaCompras() {
		ArrayList<Compra> compras = new ArrayList<>();
		for (Fornecedor f: fornecedores.values()) {
			for (Compra compra: f.retornaCompras()) {
				compras.add(compra);
			}
		}
		return compras;
	}

	public String listarCompras() {
		if (criterio == null)
			throw new IllegalArgumentException("Erro na listagem de compras: criterio ainda nao definido pelo sistema.");
		
		ArrayList<Compra> compras = processaCompras();
		Collections.sort(compras, criterio);
		
		return criterio.listaCompras(compras);
	}
}
