package saga;

/**
 * Representacao do Sistema, o sistema possui dois controladores, um de clientes
 * e um de fornecedores, alem de gerenciar o funcionamento de todas as operacoes
 * entre eles. Como o gerenciamento dos proprios cliente e fornecedores, de
 * produtos dos fornecedores, das contas do cliente, de combos do fornecedores e
 * das compras dos clientes.
 * 
 * @author Pedro Henrique
 */
public class Sistema {

	/**
	 * Representa o controlador de clientes.
	 */
	private ControllerCliente controladorCliente;

	/**
	 * Representa o controlador de fornecedores.
	 */
	private ControllerFornecedor controladorFornecedor;

	/**
	 * Constroi o sistema, construindo os controladores de clientes e de
	 * fornecedores.
	 */
	public Sistema() {
		controladorCliente = new ControllerCliente();
		controladorFornecedor = new ControllerFornecedor();
	}

	/**
	 * Adiciona um cliente ao sistema. Chama o metodo adicionaCliente passando o
	 * cpf, nome, email e localizacao. Se a adicao for efetuado com sucesso sera
	 * retornado o cpf.
	 * 
	 * @param cpf         e o cpf do cliente.
	 * @param nome        e o nome do cliente.
	 * @param email       e o email do cliente.
	 * @param localizacao e a localizacao do cliente.
	 * @return retorna o cpf do cliente.
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return controladorCliente.adicionaCliente(cpf, nome, email, localizacao);
	}

	/**
	 * Retorna a Representacao toString do cliente a partir do seu cpf.
	 * 
	 * @param cpf e o atributo que sera usado para identificar o cliente.
	 * @return retorna a representacao toString do cliente.
	 */
	public String exibeCliente(String cpf) {
		return controladorCliente.exibeCliente(cpf);
	}

	/**
	 * Edita um atributo do cliente, com o valor indicado pelo parametro. O cpf ira
	 * identificar o cliente, o atributo ira identificar o atributo a ser modificado
	 * e o valor sera o valor que sera substituido no local do valor atual. Caso a
	 * edicao tenha ocorrido, sera retornado qual atributo foi atualizado. O cpf nao
	 * pode ser alterado.
	 * 
	 * @param cpf      e o atributo que sera usado para identificar o cliente.
	 * @param atributo e o atributo que sera alterado.
	 * @param valor    e o valor que substituira o valor atual.
	 * @return retorna o atributo que foi modificado caso a modificacao tenha sido
	 *         efetuada com sucesso.
	 */
	public String editaCliente(String cpf, String atributo, String valor) {
		return controladorCliente.editaCliente(cpf, atributo, valor);
	}

	/**
	 * Retorna uma String listando todos os clientes do sistema.
	 * 
	 * @return retorna a representacao toString de todos os clientes do sistema.
	 */
	public String exibeClientes() {
		return controladorCliente.exibeClientes();
	}

	/**
	 * Remove o cliente do sistema, identificando ele atraves do cpf.
	 * 
	 * @param cpf e o atributo que sera usado para identificar o cliente.
	 */
	public void removeCliente(String cpf) {
		controladorCliente.removeCliente(cpf);
	}

	/**
	 * Adiciona um fornecedor ao sistema. Chama o metodo adicionaFornecedor passando
	 * o nome, email e telefone. Se a adicao for efetuado com sucesso sera retornado
	 * o nome.
	 * 
	 * @param nome     e o nome do fornecedor.
	 * @param email    e o email do fornecedor.
	 * @param telefone e o telefone do fornecedor.
	 * @return retorna o nome do fornecedor.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return controladorFornecedor.adicionaFornecedor(nome, email, telefone);
	}

	/**
	 * Retorna a Representacao toString do fornecedor a partir do seu nome.
	 * 
	 * @param nome e o atributo que sera usado para identificar o fornecedor.
	 * @return retorna a representacao toString do fornecedor.
	 */
	public String exibeFornecedor(String nome) {
		return controladorFornecedor.exibeFornecedor(nome);
	}

	/**
	 * Retorna uma String listando todos os fornecedores do sistema.
	 * 
	 * @return retorna a representacao toString de todos os fornecedores do sistema.
	 */
	public String exibeFornecedores() {
		return controladorFornecedor.exibeFornecedores();
	}

	/**
	 * Edita um atributo do fornecedor, com o valor indicado pelo parametro. O nome
	 * ira identificar o fornecedor, o atributo ira identificar o atributo a ser
	 * modificado e o valor sera o valor que sera substituido no local do valor
	 * atual. Caso a edicao tenha ocorrido, sera retornado qual atributo foi
	 * atualizado. O nome nao pode ser alterado.
	 * 
	 * @param nome     e o atributo que sera usado para identificar o fornecedor.
	 * @param atributo e o atributo que sera alterado.
	 * @param valor    e o valor que substituira o valor atual.
	 * @return retorna o atributo que foi modificado caso a modificacao tenha sido
	 *         efetuada com sucesso.
	 */
	public String editaFornecedor(String nome, String atributo, String valor) {
		return controladorFornecedor.editaFornecedor(nome, atributo, valor);
	}

	/**
	 * Remove o fornecedor do sistema, identificando ele atraves do nome.
	 * 
	 * @param nome e o atributo que sera usado para identificar o fornecedor.
	 */
	public void removeFornecedor(String nome) {
		controladorFornecedor.removeFornecedor(nome);
	}

	/**
	 * Adiciona um produto a um fornecedor. Chama o metodo adicionaProduto passando
	 * o nome do fornecedor, nome do produto, descricao do produto e preco do
	 * produto.
	 * 
	 * @param fornecedor e o nome do fornecedor ao qual o produto sera afiliado.
	 * @param nome       e o nome do produto.
	 * @param descricao  e a descricao do produto.
	 * @param preco      e o telefone do fornecedor.
	 */
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		controladorFornecedor.adicionaProduto(fornecedor, nome, descricao, preco);
	}

	/**
	 * Retorna a Representacao toString do produto de um fornecedor, a partir do
	 * fornecedor, do nome do produto e da descricao do produto.
	 * 
	 * @param fornecedor e o nome do fornecedor ao qual o produto sera afiliado.
	 * @param nome       e o nome do produto.
	 * @param descricao  e a descricao do produto.
	 * @return retorna a representacao toString do produto.
	 */
	public String exibeProduto(String fornecedor, String nome, String descricao) {
		return controladorFornecedor.exibeProduto(fornecedor, nome, descricao);
	}

	/**
	 * Retorna uma String listando todos os produto de um fornecedor, recebido por
	 * parametro.
	 * 
	 * @param fornecedor e o fornecedor que listara seus produtos.
	 * @return retorna a representacao toString de todos os produtos de um
	 *         fornecedor.
	 */
	public String exibeProdutosFornecedor(String fornecedor) {
		return controladorFornecedor.exibeProdutos(fornecedor);
	}

	/**
	 * Retorna uma String listando todos os produtos de todos os fornecedores.
	 * 
	 * @return retorna a representacao toString de todos os produtos de todos os
	 *         fornecedores.
	 */
	public String exibeProdutos() {
		return controladorFornecedor.exibeProdutos();
	}

	/**
	 * Edita o atributo do fornecedor, com o valor indicado pelo parametro. O nome e
	 * descricao irao identificar unicamente um produto, este produto sera
	 * verificado se existe no dado fornecedor. O unico atributo que pode ser
	 * alterado e o preco do produto, indicado por valor.
	 * 
	 * @param nome       e o nome do produto.
	 * @param descricao  e a descricao do produto.
	 * @param fornecedor e o nome do fornecedor ao qual o produto sera verificado se
	 *                   esta afiliado.
	 * @param valor      e o preco a ser editado no dado produto do fornecedor.
	 */
	public void editaProduto(String nome, String descricao, String fornecedor, double valor) {
		controladorFornecedor.editaProduto(nome, descricao, fornecedor, valor);
	}

	/**
	 * Remove o produto de um fornecedor, identificando o produto atraves do nome e
	 * descricao.
	 * 
	 * @param fornecedor e o fornecedor em que sera removido o produto.
	 * @param nome       e o nome do produto a ser removido.
	 * @param descricao  e a descricao do produto a ser removido.
	 */
	public void removeProduto(String fornecedor, String nome, String descricao) {
		controladorFornecedor.removeProduto(fornecedor, nome, descricao);
	}

	/**
	 * Adiciona uma compra a um Conta de um cliente em determinado fornecedor. A
	 * compra é identificada por um produto (que possui nome e descrição) e também
	 * possui uma data, o fornecedor é identificado pelo seu nome e a Conta do
	 * cliente é identificada pelo seu cpf.
	 * 
	 * Caso o cpf seja nulo ou vazio sera lancada uma excecao: "Erro ao cadastrar
	 * compra: cpf nao pode ser vazio ou nulo." Caso o cpf nao possua 11 caracteres
	 * sera lancada uma excecao: "Erro ao cadastrar compra: cpf invalido." Caso o
	 * cpf nao remeter a nenhum cliente sera lancada uma excecao: "Erro ao cadastrar
	 * compra: cliente nao existe."
	 * 
	 * @param cpf        e o cpf do cliente que identifica sua Conta.
	 * @param fornecedor e o fornecedor que possui as contas os clientes.
	 * @param data       e a data que foi realizada a compra.
	 * @param nome       e o nome do produto.
	 * @param descricao  e a descricao do produto.
	 */
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome, String descricao) {
		if (cpf == null || cpf.equals(""))
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
		if (cpf.length() != 11)
			throw new IllegalArgumentException("Erro ao cadastrar compra: cpf invalido.");
		if (!this.controladorCliente.existeCliente(cpf)) {
			throw new IllegalArgumentException("Erro ao cadastrar compra: cliente nao existe.");
		}

		String cliente = this.controladorCliente.getNomeCliente(cpf);
		this.controladorFornecedor.adicionaCompra(cpf, fornecedor, data, nome, descricao, cliente);
	}

	/**
	 * Adiciona uma combo que um fornecedor oferece. O combo e identificado por um
	 * nome e descrição e possui um fator que representa o desconto.
	 * 
	 * @param fornecedor e o fornecedor que possui as contas os clientes.
	 * @param nome       e o nome do produto.
	 * @param descricao  e a descricao do produto
	 * @param fator      e o fator do desconto.
	 * @param produtos   lista de produtos a serem adicionados.
	 */
	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) {
		this.controladorFornecedor.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
	}

	/**
	 * Edita o fator de um combo de um fornecedor. O fornecedor e identificado por
	 * seu nome, o combo e identificado pelo nome e descricao e novo fator e
	 * passado.
	 * 
	 * @param nome
	 * @param descricao
	 * @param fornecedor
	 * @param fator
	 */
	public void editaCombo(String fornecedor, String nome, String descricao, double fator) {
		controladorFornecedor.editaCombo(fornecedor, nome, descricao, fator);
	}

	/**
	 * Recupera o debito que um cliente tem com um fornecedor.
	 * 
	 * Caso o cpf seja nulo ou vazio sera lancada uma excecao: "Erro ao recuperar
	 * debito: cpf nao pode ser vazio ou nulo." Caso o cpf nao possua 11 caracteres
	 * sera lancada uma excecao: "Erro ao recuperar debito: cpf invalido." Caso o
	 * cpf nao remeter a nenhum cliente sera lancada uma excecao: "Erro ao recuperar
	 * debito: cliente nao existe."
	 * 
	 * @param cpf        e o cpf que identificado o cliente.
	 * @param fornecedor e o nome que identifica o fornecedor.
	 * @return e retornado o debito.
	 */
	public String getDebito(String cpf, String fornecedor) {
		if (cpf == null || cpf.equals(""))
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		if (cpf.length() != 11)
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido.");
		if (!this.controladorCliente.existeCliente(cpf))
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao existe.");
		return controladorFornecedor.getDebito(cpf, fornecedor);
	}

	/**
	 * Exibe todas as compras de um cliente de fornecedor.
	 * 
	 * Caso o cpf seja nulo ou vazio sera lancada uma excecao: "Erro ao exibir conta
	 * do cliente: cpf nao pode ser vazio ou nulo." Caso o cpf nao possua 11
	 * caracteres sera lancada uma excecao: "Erro ao exibir conta do cliente: cpf
	 * invalido." Caso o cpf nao remeter a nenhum cliente sera lancada uma excecao:
	 * "Erro ao exibir conta do cliente: cliente nao existe."
	 * 
	 * @param cpf        e o cpf que identifica o cliente.
	 * @param fornecedor e o nome que identifica o fornecedor.
	 * @return e retornado a representacao de todas as compras do cliente do dado
	 *         fornecedor.
	 */
	public String exibeContas(String cpf, String fornecedor) {
		if (cpf == null || cpf.equals(""))
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
		if (cpf.length() != 11)
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf invalido.");
		if (!this.controladorCliente.existeCliente(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir conta do cliente: cliente nao existe.");
		}

		String cliente = this.controladorCliente.getNomeCliente(cpf);
		return controladorFornecedor.exibeContas(cpf, fornecedor, cliente);
	}

	/**
	 * Exibe todas as compras que um cliente possui em todos os fornecedores.
	 * 
	 * Caso o cpf seja nulo ou vazio sera lancada uma excecao: "Erro ao exibir
	 * contas do cliente: cpf nao pode ser vazio ou nulo." Caso o cpf nao possua 11
	 * caracteres sera lancada uma excecao: "Erro ao exibir contas do cliente: cpf
	 * invalido." Caso o cpf nao remeter a nenhum cliente sera lancada uma excecao:
	 * "Erro ao exibir contas do cliente: cliente nao existe."
	 * 
	 * @param cpf e o cpf que identifica o cleinte.
	 * @return e retornado a representacao de todas as compras do cliente.
	 */
	public String exibeContasClientes(String cpf) {
		if (cpf == null || cpf.equals(""))
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
		if (cpf.length() != 11)
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf invalido.");
		if (!this.controladorCliente.existeCliente(cpf)) {
			throw new IllegalArgumentException("Erro ao exibir contas do cliente: cliente nao existe.");
		}

		String cliente = this.controladorCliente.getNomeCliente(cpf);
		return controladorFornecedor.exibeContasClientes(cpf, cliente);
	}

	/**
	 * Efetua o pagamento de todas as compras de um cliente em um dado fornecedor.
	 * 
	 * Caso o cpf seja nulo ou vazio sera lancada uma excecao: "Erro no pagamento de
	 * conta: cpf nao pode ser vazio ou nulo." Caso o cpf nao possua 11 caracteres
	 * sera lancada uma excecao: "Erro no pagamento de conta: cpf invalido." Caso o
	 * cpf nao remeter a nenhum cliente sera lancada uma excecao: "Erro no pagamento
	 * de conta: cliente nao existe."
	 * 
	 * @param cpf        e o cpf que identifica o cliente.
	 * @param fornecedor e o nome que identifica o fornecedor.
	 */
	public void realizaPagamento(String cpf, String fornecedor) {
		if (cpf == null || cpf.equals(""))
			throw new IllegalArgumentException("Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");
		if (cpf.length() != 11)
			throw new IllegalArgumentException("Erro no pagamento de conta: cpf invalido.");
		if (!this.controladorCliente.existeCliente(cpf))
			throw new IllegalArgumentException("Erro no pagamento de conta: cliente nao existe.");

		controladorFornecedor.realizaPagamento(cpf, fornecedor);
	}

	/**
	 * Substitui o criterio de ordenacao atual pelo definido no parametro.
	 * 
	 * Caso o criterio seja nulo ou vazio sera lancada uma excecao: "Erro na
	 * listagem de compras: criterio nao pode ser vazio ou nulo."
	 * 
	 * @param criterio e o criterio de ordenacao a ser definido.
	 */
	public void ordenaPor(String criterio) {
		if (criterio == null || criterio.equals(""))
			throw new IllegalArgumentException("Erro na listagem de compras: criterio nao pode ser vazio ou nulo.");

		controladorFornecedor.ordenaPor(criterio);
	}

	/**
	 * Recupera a representacao String de todas as compras, a ordenacao e baseada no
	 * criterio definido pelo usuario.
	 * 
	 * @return e retronado todas as compras no formato String.
	 */
	public String listarCompras() {
		return controladorFornecedor.listarCompras();
	}
}
