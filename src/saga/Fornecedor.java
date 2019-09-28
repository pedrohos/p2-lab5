package saga;

import java.util.HashMap;
import java.util.Iterator;

public class Fornecedor {
	private HashMap<IdProduto, Produto> produtos;
	private String nome;
	private String email;
	private String telefone;
	
	public Fornecedor(String nome, String email, String telefone) {
		if (nome == null || email == null || telefone == null) {
			throw new IllegalArgumentException("Parametro nulo!");
		}
		if (nome.trim().equals("") || email.trim().equals("") || telefone.trim().equals("")) {
			throw new IllegalArgumentException("Parametro vazio!");
		}
		
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
	
	public boolean cadastrarProduto(String nome, String descricao, double preco) {
		IdProduto id = new IdProduto(nome, descricao);
		if (existeProduto(nome, descricao)) {
			produtos.put(id, new Produto(nome, descricao, preco));
			return true;
		}
		return false;
	}
	
	public String exibirProduto(String nome, String descricao) {
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
	
	public String removeProduto(String nome, String descricao) {
		if (!existeProduto(nome, descricao)) {
			return "NaNProduto";
		}
		
		this.produtos.remove(new IdProduto(nome, descricao));
		return "";
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
