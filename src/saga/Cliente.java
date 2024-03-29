package saga;

/**
 * Representacao do Cliente no sistema. Todo cliente possui um cpf
 * (identificador unico), nome, email e um local onde ele frenquenta
 * (localizacao).
 * 
 * @author Pedro Henrique
 */
public class Cliente implements Comparable<Cliente> {

	/**
	 * Cpf do cliente, e seu identificador unico.
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
	 * Constroi o cliente atribuindo os parametros cpf, nome, email e localizacao
	 * aos atributos do cliente. Verifica se qualquer um dos parametros é nulo ou
	 * vazio, caso seja, sera retornado um IllegalArgumentException.
	 * 
	 * Caso o cpf seja nulo ou vazio sera lancado um IllegalArgumentException: "Erro
	 * no cadastro do cliente: cpf nao pode ser vazio ou nulo." Caso o nome seja
	 * nulo ou vazio sera lancado um IllegalArgumentException: "Erro no cadastro do
	 * cliente: nome nao pode ser vazio ou nulo." Caso o email seja nulo ou vazio
	 * sera lancado um IllegalArgumentException: "Erro no cadastro do cliente: email
	 * nao pode ser vazio ou nulo." Caso a localizacao seja nula ou vazia sera
	 * lancado um IllegalArgumentException: "Erro no cadastro do cliente:
	 * localizacao nao pode ser vazia ou nula." Caso o cpf nao possui 11 caracteres
	 * sera lancado um IllegalArgumentException: "Erro no cadastro do cliente: cpf
	 * invalido."
	 * 
	 * @param cpf         sera atribuido ao atributo cpf do cliente.
	 * @param nome        sera atribuido ao atributo nome do cliente.
	 * @param email       sera atribuido ao atributo email do cliente.
	 * @param localizacao sera atribuido ao atributo localizacao do cliente.
	 */
	public Cliente(String cpf, String nome, String email, String localizacao) {
		if (cpf == null || cpf.equals(""))
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");

		if (nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");

		if (email == null || email.equals(""))
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");

		if (localizacao == null || localizacao.equals(""))
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");

		if (cpf.length() != 11)
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");

		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}

	public void setNome(String valor) {
		this.nome = valor;
	}

	public void setEmail(String valor) {
		this.email = valor;
	}

	public void setLocalizacao(String valor) {
		this.localizacao = valor;
	}

	/**
	 * Retorna representacao String do cliente no seguinte formato: "NOME -
	 * LOCALIZACAO - EMAIL"
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}

	public String getNome() {
		return this.nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	/**
	 * Verifica se dois clientes sao iguais ao comparar seus cpfs.
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

	/**
	 * Compara dois clientes pelos seus nomes.
	 * 
	 * @return retorna 1, 0 ou -1 a depender da ordem lexicografica dos nomes dos
	 *         clientes.
	 */
	@Override
	public int compareTo(Cliente o) {
		return this.nome.compareTo(o.nome);
	}
}
