package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Representacao do controlador de clientes do sistema.
 * O controlador gerencia um conjunto de clientes do mapa
 * cpf do cliente, Cliente.
 * 
 * @author Pedro Henrique
 */
public class ControllerCliente {
	/**
	 * Armazena no mapa de clientes o cpf do Cliente, Cliente.
	 */
	private HashMap<String, Cliente> clientes;
	
	/**
	 * Constroi os mapas de clientes.
	 */
	public ControllerCliente() {
		this.clientes = new HashMap<>();
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
	public boolean existeCliente(String cpf) {
		if(this.clientes.containsKey(cpf)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Adiciona um cliente ao mapa de clientes a partir de seu cpf, que
	 * sera seu identificador unico.
	 * O cliente e criado a partir de um cpf, nome, email e localizacao.
	 * Caso  a adicao tenha sido efetuada com sucesso sera retornado o cpf.
	 * 
	 * Caso o cpf seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo."
	 * Caso o nome seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo."
	 * Caso o email seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro no cadastro do cliente: email nao pode ser vazio ou nulo."
	 * Caso a localizacao seja nula ou vazia sera lancado um IllegalArgumentException:
	 * "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula."
	 * Caso o cpf ja exista sera lancado um IllegalArgumentException:
	 * "Erro no cadastro do cliente: cliente ja existe."
	 * 
	 * @param cpf e o cpf do cliente que sera utilizado como seu identificado
	 * unico no mapa clientes.
	 * @param nome e o nome do cliente que sera passado em sua construcao.
	 * @param email e o email do cliente que sera passado em sua construcao.
	 * @param localizacao e a localizacao do cliente que sera passado em sua
	 * construcao.
	 * @return retorna o cpf do cliente caso ele tenha sido adiiconado com sucesso.
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		if(cpf == null || cpf.equals(""))
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		if(nome == null || nome.equals(""))
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		if(email == null || email.equals(""))
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		if(localizacao == null || localizacao.equals(""))
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		
		if(!this.clientes.containsKey(cpf)) {
			this.clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
			return cpf;
		}
		throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		
	}
	
	/**
	 * Retorna a representacao toString do cliente a partir de seu cpf, formato:
	 * CPF - LOCALIZACAO - EMAIL
	 * 
	 * Caso o cpf seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo."
	 * Caso o cpf nao exista ser lancado um IllegalArgumentException:
	 * "Erro na exibicao do cliente: cliente nao existe."
	 * 
	 * @param cpf e o cpf do cliente que sera utilizado para recuperar o
	 * cliente no mapa clientes.
	 * @return retorna a representacao toString do cliente.
	 */
	public String exibeCliente(String cpf) {
		if (cpf == null || cpf.equals(""))
			throw new IllegalArgumentException("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		if(existeCliente(cpf)) {
			return this.clientes.get(cpf).toString();	
		}
		throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
	}
	
	/**
	 * Permite a edicao do valor atual de um atributo do cliente, e atualizado com
	 *  um novo valor.
	 * O cpf e utilizado para recuperar o cliente no mapa clientes.
	 * O valor do atributo indicado sera substituido pelo valor recebido por parametro.
	 * Caso a edicao tenha sido efetuada com sucesso sera retornado o nome do atributo
	 * que foi alterado. O cpf nao pode ser alterado.
	 * 
	 * Caso o cpf seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo."
	 * Caso o atributo seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo."
	 * Caso o valor seja nulo ou vazio sera lancado um IllegalArgumentException:
	 * "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo."
	 * Caso o cpf tente ser alterado sera lancado um IllegalArgumentException:
	 * "Erro na edicao do cliente: cpf nao pode ser editado."
	 * Caso o atributo nao exista ser lancado um IllegalArgumentException:
	 * "Erro na edicao do cliente: atributo nao existe."
	 * Caso o cpf nao remeta a nenhum usuario no mapa de clientes ser lancado um
	 * IllegalArgumentException: "Erro na edicao do cliente: cliente nao existe."
	 * 
	 * @param cpf e o cpf do cliente que sera utilizado para recuperar o
	 * cliente no mapa clientes. 
	 * @param atributo e o atributo cujo seu valor sera alterado.
	 * @param valor e o valor que ira substituir o valor atual do atributo.
	 * @return retorna o nome do atributo que foi alterado.
	 */
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
	
	/**
	 * Lista todos os clientes pela sua representacao toString, no formato:
	 * CPF1 - EMAIL1 - LOCALIZACAO1 | CPF2 - EMAIL2 - LOCALIZACAO2 | CPFN - EMAILN - LOCALIZACAON
	 * 
	 * @return retorna a representacao toString de todos os clientes do sistema.
	 */
	public String exibeClientes() {
		String resultado = "";
		if(!clientes.isEmpty()) {
			
			ArrayList<Cliente> valores = new ArrayList<>();
			for (Cliente c: clientes.values())
				valores.add(c);
			Collections.sort(valores);
			
			Iterator<Cliente> it = valores.iterator();
			while(it.hasNext()) {
				Cliente elemento = it.next();
				if (it.hasNext()) {
					resultado += elemento.toString() + " | ";
				} else {
					resultado += elemento.toString();
				}
			}
		}
		return resultado;
	}
	
	/**
	 * Remove um cliente do mapa clientes a partir de um dado cpf.
	 * 
	 * Caso o cpf seja vazio ou nulo sera lancado um IllegalArgumentException:
	 * "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo"
	 * Caso o cliente nao exista ser lancado um IllegalArgumentException:
	 * "Erro na remocao do cliente: cliente nao existe."
	 * 
	 * @param cpf e atributo que ira identificar o cliente no mapa clientes.
	 */
	public void removeCliente(String cpf) {
		if (cpf == null || cpf.equals(""))
			throw new IllegalArgumentException("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		
		if(!existeCliente(cpf)) {
			throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
		}
		clientes.remove(cpf);
	}
	
	/**
	 * Recupera o nome de um dado cliente a partir de seu cpf.
	 * 
	 * @param cpf e o cpf do cliente cujo nome sera recuperado.
	 * @return e retornado o nome do cliente cujo cpf foi recebido.
	 */
	public String getNomeCliente(String cpf) {
		return clientes.get(cpf).getNome();
	}
}
