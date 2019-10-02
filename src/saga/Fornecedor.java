package saga;

import java.util.HashMap;
import java.util.Iterator;

public class Fornecedor {
	private HashMap<IdProduto, Produto> produtos;
	private String nome;
	private String email;
	private String telefone;
	
	public Fornecedor(String nome, String email, String telefone) {
		if (nome == null || nome.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		if (email == null || email.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		if (telefone == null || telefone.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: telefone nao pode ser vazio ou nulo.");
		}
		
		this.produtos = new HashMap<>();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
	public boolean existeProduto(String nome, String descricao) {
		IdProduto id = new IdProduto(nome, descricao);
		if(produtos.containsKey(id)) {
			return true;
		}
		return false;
	}
	
	public boolean possuiProduto() {
		if (!produtos.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public void adicionaProduto(String nome, String descricao, double preco) {
		IdProduto id = new IdProduto(nome, descricao);
		if (!existeProduto(nome, descricao)) {
			produtos.put(id, new Produto(nome, descricao, preco));
		}
	}
	
	public String exibeProduto(String nome, String descricao) {
		if (!existeProduto(nome, descricao)) {
			return "NaNProduto";
		}
		
		return this.produtos.get(new IdProduto(nome, descricao)).toString();
	}
	
	public String listarProdutos() {
		String resultado = "";
		if(!produtos.isEmpty()) {
			Iterator<Produto> it = produtos.values().iterator();
			while(it.hasNext()) {
				Produto elemento = it.next();
				if (it.hasNext()) {
					resultado += elemento.toString() + " | ";
				} else {
					resultado += it.next().toString();
				}
			}
		}
		return resultado;
	}
	
	public void editaProduto(String nome, String descricao, double valor) {
		if (!existeProduto(nome, descricao)) {
			throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
		}
		
		this.produtos.get(new IdProduto(nome, descricao)).setPreco(valor);
	}
	
	public void removeProduto(String nome, String descricao) {
		if (!existeProduto(nome, descricao)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}
		
		this.produtos.remove(new IdProduto(nome, descricao));
	}
	
	public void setEmail(String valor) {
		this.email = valor;
	}
	
	public void setTelefone(String valor) {
		this.telefone = valor;
	}

	@Override
	public String toString() {
		return nome + " - " + email + " - " + telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

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
}
