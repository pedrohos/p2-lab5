package saga;

import java.util.HashMap;
import java.util.Iterator;

public class ControllerFornecedor {
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

	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		if (!existeFornecedor(fornecedor))
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		
		this.fornecedores.get(fornecedor).adicionaProduto(nome, descricao, preco);
	}

	public String exibeProduto(String nome, String descricao, String fornecedor) {
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if (!existeFornecedor(fornecedor))
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		
		return this.fornecedores.get(fornecedor).exibeProduto(nome, descricao);
	}

	public void editaProduto(String nome, String descricao, String fornecedor, double valor) {
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if (!existeFornecedor(fornecedor))
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		
		this.fornecedores.get(fornecedor).editaProduto(nome, descricao, valor);
	}

	public void removeProduto(String nome, String descricao, String fornecedor) {
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		if (!existeFornecedor(fornecedor))
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		
		this.fornecedores.get(fornecedor).removeProduto(nome, descricao);
	}
}
