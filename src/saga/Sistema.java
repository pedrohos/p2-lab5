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
	
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		if(!this.clientes.containsKey(cpf)) {
			this.clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
			return cpf;
		}
		throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		
	}
	
	public String exibeCliente(String cpf) {
		if (cpf == null || cpf.equals(""))
			throw new IllegalArgumentException("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		if(existeCliente(cpf)) {
			return this.clientes.get(cpf).toString();	
		}
		throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
	}
	
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
	
	public String listaClientes() {
		String resultado = "";
		if(!clientes.isEmpty()) {
			Iterator<Cliente> it = clientes.values().iterator();
			while(it.hasNext()) {
				Cliente elemento = it.next();
				if (it.hasNext()) {
					resultado += elemento.toString() + " | ";
				} else {
					resultado += it.next().toString();
				}
			}
		}
		return resultado;
	}
	
	public void removeCliente(String cpf) {
		if (cpf == null || cpf.equals(""))
			throw new IllegalArgumentException("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		
		if(!existeCliente(cpf)) {
			throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
		}
		clientes.remove(cpf);
		
	}
	
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
	
	public String exibeFornecedor(String nome) {
		if (this.existeFornecedor(nome)) {
			return this.fornecedores.get(nome).toString();
		}
		throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
	}
	
	public String listaFornecedores() {
		String resultado = "";
		if(!fornecedores.isEmpty()) {
			Iterator<Fornecedor> it = fornecedores.values().iterator();
			while(it.hasNext()) {
				Fornecedor elemento = it.next();
				if (it.hasNext()) {
					resultado += elemento.toString() + " | ";
				} else {
					resultado += it.next().toString();
				}
			}
		}
		return resultado;
	}
	
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
	
	public void removeFornecedor(String nome) {
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		
		if(!existeFornecedor(nome)) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: fornecedor nao existe.");
		}
		fornecedores.remove(nome);
	}
	
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
	
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		if (fornecedor == null || fornecedor.equals(""))
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		if (descricao == null || descricao.equals(""))
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		
		if (!existeFornecedor(fornecedor)) 
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
		
		if (!existeProduto(fornecedor, nome, descricao)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
		}
		
		return this.fornecedores.get(fornecedor).exibeProduto(nome, descricao);
	}
	
	public String listarProdutos(String fornecedor) {
		if (!existeFornecedor(fornecedor)) {
			throw new IllegalArgumentException("Erro na listagem de produtos: fornecedor nao existe.");
		}
		
		if(!fornecedores.get(fornecedor).possuiProduto()) {
			return "SemProduto";
		}
		
		return fornecedores.get(fornecedor).listarProdutos();
	}
	
	public String listarProdutosTodosFornecedores () {
		if (fornecedores.isEmpty()) {
			return "FornecedorVazio";
		}
		
		String resultado = "";
		for (Fornecedor f: fornecedores.values()) {
			if (!f.possuiProduto()) {
				continue;
			}
			resultado += f.listarProdutos();
		}
		
		return resultado;
	}
	
	public String editaProduto(String nome, String descricao, String fornecedor, double valor) {
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
		return "";
	}
	
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
