package saga;

import java.util.HashMap;

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
	
}
