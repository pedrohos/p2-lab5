package saga;

/**
 * Representacao do identificador unico de Produto.
 * E composto por um nome e uma descricao.
 * 
 * @author Pedro Henrique
 */
public class IdProduto {
	
	/**
	 * Nome do produto que o identificara unicamente.
	 */
	private String nome;
	
	/**
	 * Descricao do produto que o identificara unicamente.
	 */
	private String descricao;
	
	/**
	 * Constroi um IdProduto com nome e descricao.
	 * 
	 * @param nome e o nome do produto.
	 * @param descricao e a descricao do produto.
	 */
	public IdProduto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	/**
	 * Representacao toStringo do IdProduto, no formato:
	 * NOME - DESCRICAO
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Compara se dois ids sao iguais se, e somente se, seu nomes e
	 * descricoes forem iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdProduto other = (IdProduto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
