package saga;

import java.util.HashMap;
import java.util.Iterator;

public class Sistema {
	private HashMap<String, Cliente> clientes; 
	
	public Sistema() {
		this.clientes = new HashMap<>();
	}
	
	private boolean existeCliente(String cpf) {
		if(this.clientes.containsKey(cpf)) {
			return true;
		}
		return false;
	}
	
	public String cadastraCliente(String cpf, String nome, String email, String localizacao) {
		if(!this.clientes.containsKey(cpf)) {
			this.clientes.put(cpf, new Cliente(cpf, nome, email, localizacao));
			return cpf;
		}
		throw new IllegalArgumentException("Cpf ja cadastrado!");
		
	}
	
	public String getClienteToString(String cpf) {
		if(existeCliente(cpf)) {
			return this.clientes.get(cpf).toString();	
		}
		return "Cliente não cadastrado.";
	}
	
	public String editaCliente(String cpf, String atributo, String valor) {
		if (valor.trim().equals("")) throw new IllegalArgumentException("Valor vazio!");
		if(existeCliente(cpf)) {
			switch(atributo) {
				case "nome":
					this.clientes.get(cpf).setNome(valor);
					return "Atributo " + atributo + " alterado.";
				case "email":
					this.clientes.get(cpf).setEmail(valor);
					return "Atributo " + atributo + " alterado.";
				case "localizacao":
					this.clientes.get(cpf).setLocalizacao(valor);
					return "Atributo " + atributo + " alterado.";
				default:
					return "Atributo inexistente.";
			}
		}
		return "Cliente não cadastrado.";
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
}
