package saga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

public class Conta {
	private ArrayList<Compra> compras;
	private String cliente;
	private String fornecedor;
	
	public Conta(String cliente, String fornecedor) {
		this.compras = new ArrayList<>();
		this.cliente = cliente;
		this.fornecedor = fornecedor;
	}
	
	public void adicionaCompra(String data, String nome, String descricao, double preco) {
		this.compras.add(new Compra(data, nome, descricao, preco, this.cliente, this.fornecedor));
	}
	
	public String getCliente() {
		return this.cliente;
	}
	
	public String getDebito() {
		double debito = 0;
		for(Compra c: compras) {
			debito += c.getPreco();
		}
		if (debito == 0)
			throw new IllegalArgumentException("Erro ao recuperar debito: cliente nao tem debito com fornecedor.");
		return String.format(Locale.ENGLISH,"%.2f", debito);
	}

	public String exibeContas() {
		String resultado = "";
		Iterator<Compra> it = compras.iterator();
		while (it.hasNext()) {
			Compra elemento = it.next();
			if (it.hasNext()) {
				resultado += elemento.toString() + " | ";
			} else {
				resultado += elemento.toString();
			}
		}
		return resultado;
	}
}
