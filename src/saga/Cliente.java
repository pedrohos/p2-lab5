package saga;

/**
 * Representação do Cliente no sistema.
 * Todo cliente possui um cpf (identificador único), nome, email e um local onde ele frenquenta (localizacao).
 * 
 * 
 * @author Pedro Silva
 */
public class Cliente {
	
	/**
	 * Cpf do cliente, é seu identificador único.
	 */
	private String cpf;
	
	/**
	 * Nome do cliente.
	 */
	private String nome;
	
	/**
	 * Email do cliente.
	 */
	private String email;
	
	/**
	 * Localizacao do cliente.
	 */
	private String localizacao;
	
	/**
	 * Constroi o cliente atribuindo os parametros cpf, nome, email e localizacao aos atributos do cliente.
	 * Verifica se qualquer um dos parametros é nulo ou vazio, caso seja, será retornado um IllegalArgumentException.
	 * 
	 * @throws Lanca um IllegalArgumentException("Parametro nulo!") caso o parametro seja nulo, caso ele esteja vazio,
	 * ser lancado um IllegalArgumentException("Parametro vazio!") 
	 * @param cpf sera atribuído ao atributo cpf do cliente.
	 * @param nome sera atribuído ao atributo nome do cliente.
	 * @param email sera atribuído ao atributo email do cliente.
	 * @param localizacao sera atribuido ao atributo localizacao do cliente.
	 */
	public Cliente(String cpf, String nome, String email, String localizacao) {
		if (cpf == null || nome == null || email == null || localizacao == null) {
			throw new IllegalArgumentException("Parametro nulo!");
		}
		if (cpf.trim().equals("") || nome.trim().equals("") || email.trim().equals("") || localizacao.trim().equals("")) {
			throw new IllegalArgumentException("Parametro vazio!");
		}
		
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}
	
	/**
	 * Atribui o valor do parametro ao atributo nome.
	 * 
	 * @param valor e o valor que sera atribuido ao atributo nome.
	 */
	public void setNome(String valor) {
		this.nome = valor;
	}
	
	/**
	 * Atribui o valor do parametro ao atributo email.
	 * 
	 * @param valor e o valor que sera atribuido ao atributo email.
	 */
	public void setEmail(String valor) {
		this.email = valor;
	}
	
	/**
	 * Atribui o valor do parametro ao atributo localizacao.
	 * 
	 * @param valor e o valor que sera atribuido ao atributo localizacao.
	 */
	public void setLocalizacao(String valor) {
		this.localizacao = valor;
	}
	
	/**
	 * Retorna representacao String do cliente no seguinte formato:
	 * "NOME - LOCALIZACAO - EMAIL"
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}
	
	/**
	 * Verifica se dois clientes são iguais ao comparar seus cpfs.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	
}
