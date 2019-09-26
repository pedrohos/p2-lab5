package saga;

public class Cliente {
	private String cpf;
	private String nome;
	private String email;
	private String localizacao;
	
	public Cliente(String cpf, String nome, String email, String localizacao) {
		if (cpf == null || nome == null || email == null || localizacao == null) {
			throw new IllegalArgumentException("Parametro nulo!");
		}
		if (cpf.trim().equals("") || cpf.trim().equals("") || cpf.trim().equals("") || cpf.trim().equals("")) {
			throw new IllegalArgumentException("Parametro vazio!");
		}
		
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
