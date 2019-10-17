package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class ControllerConta {
	private String fornecedor;
	private HashMap<String, Conta> contasCliente;

	public ControllerConta(String fornecedor) {
		this.fornecedor = fornecedor;
		this.contasCliente = new HashMap<>();
	}
	
	public boolean existeConta(String cpf) {
		if (this.contasCliente.containsKey(cpf)) {
			return true; 
		}
		return false;
	}
	
	private void criaConta(String cpf, String cliente) {
		this.contasCliente.put(cpf, new Conta(cliente, this.fornecedor));
	}
	
	public void adicionaCompra(String cpf, String data, String nome, String descricao, String cliente, double preco) {
		if(!existeConta(cpf))
			criaConta(cpf, cliente);
		
		this.contasCliente.get(cpf).adicionaCompra(data, nome, descricao, preco);
	}
	
	public String getDebitoCliente(String cpf) {
		if(cpf.length() != 11)
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf invalido.");
		if(cpf == null || cpf.equals(""))
			throw new IllegalArgumentException("Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
		if(!existeConta(cpf))
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		
		return this.contasCliente.get(cpf).getDebito();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contasCliente == null) ? 0 : contasCliente.hashCode());
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
		ControllerConta other = (ControllerConta) obj;
		if (contasCliente == null) {
			if (other.contasCliente != null)
				return false;
		} else if (!contasCliente.equals(other.contasCliente))
			return false;
		return true;
	}

	public String exibeContas(String cpf) {
		return this.contasCliente.get(cpf).exibeContas();
	}

	public void realizaPagamento(String cpf) {
		if (!existeConta(cpf))
			throw new IllegalArgumentException("Erro no pagamento de conta: nao ha debito do cliente associado a este fornecedor.");
		
		this.contasCliente.remove(cpf);
	}
}
