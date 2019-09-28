package saga;

public class Produto {
	private IdProduto id;
	private double preco;
	
	public Produto(String nome, String descricao, double preco) {
		this.id = new IdProduto(nome, descricao);
		this.preco = preco;
	}
	
	public void setPreco(double preco) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return id.toString() + " - R$" + preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
