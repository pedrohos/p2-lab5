package saga;

import java.util.HashMap;
import java.util.Iterator;

public class Sistema {
	private HashMap<String, Cliente> clientes;
	private HashMap<String, Fornecedor> fornecedores;
	
	public Sistema() {
		this.clientes = new HashMap<>();
		this.fornecedores = new HashMap<>();
	}
	
	private boolean existeCliente(String cpf) {
		if(this.clientes.containsKey(cpf)) {
			return true;
		}
		return false;
	}
	
	private boolean existeFornecedor(String nome) {
		if(this.fornecedores.containsKey(nome)) {
			return true;
		}
		return false;
	}
	
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
	
	public boolean removeCliente(String cpf) {
		if (cpf == null || cpf.equals(""))
			throw new IllegalArgumentException("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		
		if(existeCliente(cpf)) {
			clientes.remove(cpf);
			return true;
		}
		throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
	}
	
	public boolean cadastrarFornecedor(String nome, String email, String telefone) {
		if (!this.existeFornecedor(nome)) {
			fornecedores.put(nome, new Fornecedor(nome, email, telefone));
			return true;
		}
		return false;
	}
	
	public String exibirFornecedor(String nome) {
		if (this.existeFornecedor(nome)) {
			return this.fornecedores.get(nome).toString();
		}
		return "";
	}
	
	public String listarFornecedores() {
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
		if (valor.trim().equals("")) throw new IllegalArgumentException("Valor vazio!");
		if(existeFornecedor(nome)) {
			switch(atributo) {
				case "email":
					this.fornecedores.get(nome).setEmail(valor);
					return "Email";
				case "telefone":
					this.clientes.get(nome).setLocalizacao(valor);
					return "Telefone";
				default:
					return "";
			}
		}
		return "NaNFornecedor";
	}
	
	public boolean removeFornecedor(String cpf) {
		if(existeFornecedor(cpf)) {
			fornecedores.remove(cpf);
			return true;
		}
		return false;
	}
	
	public String cadastrarProduto(String fornecedor, String nome, String descricao, double preco) {
		if (!existeFornecedor(nome)) {
			return "NaNFornecedor";
		}
		if (existeProduto(fornecedor, nome, descricao)) {
			return "ExisteProduto";
		}
		this.fornecedores.get(nome).cadastrarProduto(nome, descricao, preco);
		return "";
	}
	
	public String exibirProduto(String fornecedor, String nome, String descricao) {
		if (!existeFornecedor(fornecedor)) {
			return "NaNFornecedor";
		}
		if (!existeProduto(fornecedor, nome, descricao)) {
			return "NaNProduto";
		}
		
		return this.fornecedores.get(nome).exibirProduto(nome, descricao);
	}
	
	public String listarProdutos(String fornecedor) {
		if (!existeFornecedor(fornecedor)) {
			return "NaNFornecedor";
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
	
	public String removeProduto(String fornecedor, String nome, String descricao) {
		if (!existeFornecedor(fornecedor)) {
			return "NaNFornecedor";
		}
		
		this.fornecedores.get(fornecedor).removeProduto(nome, descricao);
		return "";
	}
}
