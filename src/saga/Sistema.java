package saga;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Representacao do Sistema SAGA.
 * O sistema adiciona, recupera, edita e apaga clientes e fornecedores.
 * E também adiciona, recupera, edita e apaga produtos que estao afiliados
 * a determinado fornecedor.
 * 
 * @author Pedro Henrique
 */
public class Sistema {
	
	/**
	 * Armazena no mapa de clientes o cpf do Cliente, Cliente.
	 */
	private HashMap<String, Cliente> clientes;
	
	/**
	 * Armazena no mapa de fornecedores o nome do fornecedor, Fornecedor.
	 */
	private HashMap<String, Fornecedor> fornecedores;
	
	/**
	 * Constroi os mapas de clientes e de fornecedores.
	 */
	public Sistema() {
		this.clientes = new HashMap<>();
		this.fornecedores = new HashMap<>();
	}
	
	/**
	 * Verifica se um cliente existe no mapa clientes a partir de seu cpf.
	 * Retorna um boolean indicando true caso o cliente exista, caso contrario,
	 * false.
	 * 
	 * @param cpf e o cpf do cliente a ser verificado se esta ligada a algum
	 * cliente no mapa clientes.
	 * @return retorna true caso cliente exista, false caso nao exista.
	 */
	private boolean existeCliente(String cpf) {
		if(this.clientes.containsKey(cpf)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Verifica se um fornecedor existe no mapa fornecedores a partir de seu nome.
	 * Retorna um boolean indicando true caso o fornecedor exista, caso contrario,
	 * false.
	 * 
	 * @param nome e o nome do fornecedor a ser verificado se esta ligada a algum
	 * fornecedor no mapa fornecedores.
	 * @return retorna true caso fornecedor exista, false caso nao exista.
	 */
	private boolean existeFornecedor(String nome) {
		if(this.fornecedores.containsKey(nome)) {
			return true;
		}
		return false;
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
	private boolean existeProduto(String fornecedor, String nome, String descricao) {
		if(this.fornecedores.get(fornecedor).existeProduto(nome, descricao)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Adiciona um cliente ao mapa de clientes a partir de seu cpf, que
	 * sera seu identificador unico.
	 * O cliente e criado a partir de um cpf, nome, email e localizacao.
	 * Caso  a adicao tenha sido efetuada com sucesso sera retornado o cpf.
	 * 
	 * Caso o cpf seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo."
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo."
	 * Caso o email seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro do cliente: email nao pode ser vazio ou nulo."
	 * Caso a localizacao seja nula ou vazia sera lancado um IllegalArgumentException:
	 * "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula."
	 * Caso o cpf ja exista sera lancado um IllegalArgumentException:
	 * "Erro no cadastro do cliente: cliente ja existe."
	 * 
	 * @param cpf e o cpf do cliente que sera utilizado como seu identificado
	 * unico no mapa clientes.
	 * @param nome e o nome do cliente que sera passado em sua construcao.
	 * @param email e o email do cliente que sera passado em sua construcao.
	 * @param localizacao e a localizacao do cliente que sera passado em sua
	 * construcao.
	 * @return retorna o cpf do cliente caso ele tenha sido adiiconado com sucesso.
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		if(cpf == null || cpf.equals(""))
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		if(nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		if(email == null || email.equals(""))
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		if(localizacao == null || localizacao.equals(""))
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		
		if(!this.clientes.containsKey(cpf)) {
			this.clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
			return cpf;
		}
		throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		
	}
	
	/**
	 * Retorna a representacao toString do cliente a partir de seu cpf, formato:
	 * CPF - LOCALIZACAO - EMAIL
	 * 
	 * Caso o cpf seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo."
	 * Caso o cpf nao exista ser lancado um IllegalArgumentException:
	 * "Erro na exibicao do cliente: cliente nao existe."
	 * 
	 * @param cpf e o cpf do cliente que sera utilizado para recuperar o
	 * cliente no mapa clientes.
	 * @return retorna a representacao toString do cliente.
	 */
	public String exibeCliente(String cpf) {
		if (cpf == null || cpf.equals(""))
			throw new IllegalArgumentException("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		if(existeCliente(cpf)) {
			return this.clientes.get(cpf).toString();	
		}
		throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
	}
	
	/**
	 * Permite a edicao do valor atual de um atributo do cliente, e atualizado com
	 *  um novo valor.
	 * O cpf e utilizado para recuperar o cliente no mapa clientes.
	 * O valor do atributo indicado sera substituido pelo valor recebido por parametro.
	 * Caso a edicao tenha sido efetuada com sucesso sera retornado o nome do atributo
	 * que foi alterado. O cpf nao pode ser alterado.
	 * 
	 * Caso o cpf seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo."
	 * Caso o atributo seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo."
	 * Caso o valor seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo."
	 * Caso o cpf tente ser alterado sera lancado um IllegalArgumentException:
	 * "Erro na edicao do cliente: cpf nao pode ser editado."
	 * Caso o atributo nao exista ser lancado um IllegalArgumentException:
	 * "Erro na edicao do cliente: atributo nao existe."
	 * Caso o cpf nao remeta a nenhum usuario no mapa de clientes ser lancado um
	 * IllegalArgumentException: "Erro na edicao do cliente: cliente nao existe."
	 * 
	 * @param cpf e o cpf do cliente que sera utilizado para recuperar o
	 * cliente no mapa clientes. 
	 * @param atributo e o atributo cujo seu valor sera alterado.
	 * @param valor e o valor que ira substituir o valor atual do atributo.
	 * @return retorna o nome do atributo que foi alterado.
	 */
	public String editaCliente(String cpf, String atributo, String valor) {
		if (cpf == null || cpf.equals(""))
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		
		if (atributo == null || atributo.equals(""))
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		
		if (valor == null || valor.equals(""))
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		
		if(existeCliente(cpf)) {
			switch(atributo) {
				case "cpf":
					throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
				case "nome":
					this.clientes.get(cpf).setNome(valor);
					return "Nome";
				case "email":
					this.clientes.get(cpf).setEmail(valor);
					return "Email";
				case "localizacao":
					this.clientes.get(cpf).setLocalizacao(valor);
					return "Localizacao";
				default:
					throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
			}
		}
		throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
	}
	
	/**
	 * Lista todos os clientes pela sua representacao toString, no formato:
	 * CPF1 - EMAIL1 - LOCALIZACAO1 | CPF2 - EMAIL2 - LOCALIZACAO2 | CPFN - EMAILN - LOCALIZACAON
	 * 
	 * @return retorna a representacao toString de todos os clientes do sistema.
	 */
	public String listaClientes() {
		String resultado = "";
		if(!clientes.isEmpty()) {
			Iterator<Cliente> it = clientes.values().iterator();
			while(it.hasNext()) {
				Cliente elemento = it.next();
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
	 * Remove um cliente do mapa clientes a partir de um dado cpf.
	 * 
	 * Caso o cpf seja vazio ou nulo sera lancado um IllegalArgumentException:
	 * "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo"
	 * Caso o cliente nao exista ser lancado um IllegalArgumentException:
	 * "Erro na remocao do cliente: cliente nao existe."
	 * 
	 * @param cpf e atributo que ira identificar o cliente no mapa clientes.
	 */
	public void removeCliente(String cpf) {
		if (cpf == null || cpf.equals(""))
			throw new IllegalArgumentException("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		
		if(!existeCliente(cpf)) {
			throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
		}
		clientes.remove(cpf);
	}
	
	/**
	 * Adiciona um fornecedor ao mapa de fornecedores a partir de seu nome, que
	 * sera seu identificador unico.
	 * O fornecedor e criado a partir de um nome, email e telefone.
	 * Caso  a adicao tenha sido efetuada com sucesso sera retornado o nome.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo."
	 * Caso o email seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo."
	 * Caso o telefone seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo."
	 * 
	 * @param nome e o nome do fornecedor que sera passado em sua construcao.
	 * @param email e o email do fornecedor que sera passado em sua construcao.
	 * @param telefone e o telefone do cliente que sera passado em sua construcao.
	 * @return retorna o nome do fornecedor caso ele tenha sido adiiconado com sucesso.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		if(nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		if(email == null || email.equals(""))
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		if(telefone == null || telefone.equals(""))
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		
		if (!this.existeFornecedor(nome)) {
			this.fornecedores.put(nome, new Fornecedor(nome, email, telefone));
			return nome;
		}
		throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
	}
	
	/**
	 * Retorna a representacao toString do fornecedor a partir de seu cpf, no formato:
	 * NOME - EMAIL - TELEFONE
	 * 
	 * Caso o nome do fornecedor seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo."
	 * Caso o fornecedor nao exista ser lancado um IllegalArgumentException:
	 * "Erro na exibicao do fornecedor: fornecedor nao existe."
	 * 
	 * Caso o cpf seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo."
	 * Caso o cpf nao exista ser lancado um IllegalArgumentException:
	 * "Erro na exibicao do cliente: cliente nao existe."
	 * throw new IllegalArgumentException("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
	 * @param nome e o nome do fornecedor que sera utilizado para recuperar o fornecedor no mapa
	 * fornecedores.
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
	 * NOME1 - EMAIL1 - TELEFONE1 | NOME2 - EMAIL2 - TELEFONE2 | NOMEN - EMAILN - TELEFONEN
	 * 
	 * @return retorna a representacao toString de todos os fornecedores do sistema.
	 */
	public String listaFornecedores() {
		String resultado = "";
		if(!fornecedores.isEmpty()) {
			Iterator<Fornecedor> it = fornecedores.values().iterator();
			while(it.hasNext()) {
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
	 * Permite a edicao do valor atual de um atributo do cliente, e atualizado com
	 *  um novo valor.
	 * O nome e utilizado para recuperar o cliente no mapa clientes.
	 * O valor do atributo indicado sera substituido pelo valor recebido por parametro.
	 * Caso a edicao tenha sido efetuada com sucesso sera retornado o nome do atributo
	 * que foi alterado. O nome nao pode ser alterado.
	 * 
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo."
	 * Caso o atributo seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo."
	 * Caso o valor seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo."
	 * Caso o nome tente ser alterado sera lancado um IllegalArgumentException:
	 * "Erro na edicao do fornecedor: nome nao pode ser editado."
	 * Caso o atributo nao exista ser lancado um IllegalArgumentException:
	 * "Erro na edicao do fornecedor: atributo nao existe."
	 * Caso o cpf nao remeta a nenhum fronecedor no mapa de clientes ser lancado um
	 * IllegalArgumentException: "Erro na edicao do fornecedor: fornecedor nao existe."
	 * 
	 * @param nome e o nome do fornecedor que sera utilizado para recuperar o
	 * fornecedor no mapa fornecedores. 
	 * @param atributo e o atributo cujo seu valor sera alterado.
	 * @param valor e o valor que ira substituir o valor atual do atributo.
	 * @return retorna o nome do atributo que foi alterado.
	 */
	public String editaFornecedor(String nome, String atributo, String valor) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		if (valor == null || valor.equals(""))
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		if (atributo == null || atributo.equals(""))
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		
		if(existeFornecedor(nome)) {
			switch(atributo) {
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
	 * "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo."
	 * Caso o fornecedor nao exista ser lancado um IllegalArgumentException:
	 * "Erro na remocao do fornecedor: fornecedor nao existe."
	 * 
	 * @param nome e atributo que ira identificar o fornecedor no mapa fornecedores.
	 */
	public void removeFornecedor(String nome) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		
		if(!existeFornecedor(nome)) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
		fornecedores.remove(nome);
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
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		if (descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		if (preco <= 0)
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		
		if (!existeFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}
		if (existeProduto(fornecedor, nome, descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: produto ja existe.");
		}
		
		this.fornecedores.get(fornecedor).adicionaProduto(nome, descricao, preco);
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
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		if (descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		
		if (!existeFornecedor(fornecedor)) 
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		
		if (!existeProduto(fornecedor, nome, descricao))
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		
		
		return this.fornecedores.get(fornecedor).exibeProduto(nome, descricao);
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
	public String listarProdutos(String fornecedor) {
		if (!existeFornecedor(fornecedor)) 
			throw new IllegalArgumentException("Erro na listagem de produtos: fornecedor nao existe.");
		
		return fornecedores.get(fornecedor).listarProdutos();
	}
	
	/**
	 * Lista todos os produtos de todos os fornecedores no formato:
	 * FORNECEDOR1 - NOME1 - DESCRICAO1 - R$X,XX | FORNECEDOR1 - NOME2 - DESCRICAO2 - R$Y,YY
	 * FORNECEDORX - NOMEX - DESCRICAOX - R$Z,ZZ
	 * 
	 * @return retorna todos os produtos de todos os fornecedores.
	 */
	public String listarProdutosTodosFornecedores () {
		String resultado = "";
		if(!fornecedores.isEmpty()) {
			Iterator<Fornecedor> it = fornecedores.values().iterator();
			while(it.hasNext()) {
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
	public void editaProduto(String nome, String descricao, String fornecedor, double valor) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		if (descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if (valor <= 0)
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		
		if(!existeFornecedor(fornecedor))
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		
		if(!existeProduto(fornecedor, nome, descricao)) 
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		
		this.fornecedores.get(fornecedor).editaProduto(nome, descricao, valor);
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
	public void removeProduto(String nome, String descricao, String fornecedor) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		if (descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		
		if (!existeFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}
		if (!existeProduto(fornecedor, nome, descricao)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
		
		this.fornecedores.get(fornecedor).removeProduto(nome, descricao);
	}
}
