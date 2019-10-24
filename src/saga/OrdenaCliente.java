package saga;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Ordenacao pelos clientes.
 * 
 * @author Pedro Henrique
 */
public class OrdenaCliente implements Criterio {

	/**
	 * Compara duas compras pelo nome do cliente. Caso os nome sejam iguais serao
	 * comparados o nome do fornecedor + descricao + data.
	 */
	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getCliente().compareTo(o2.getCliente()) == 0) {
			return (o1.getFornecedor() + o1.getDescricao() + o1.getData())
					.compareTo(o2.getFornecedor() + o2.getDescricao() + o2.getData());
		}
		return o1.getCliente().compareTo(o2.getCliente());
	}

	/**
	 * Ordena pelos clientes, depois pelo fornecdor + descricao + data.
	 */
	@Override
	public String listaCompras(ArrayList<Compra> compras) {
		String resultado = "";
		Iterator<Compra> it = compras.iterator();
		while (it.hasNext()) {
			Compra compra = it.next();
			if (it.hasNext()) {
				resultado += String.format("%s, %s, %s, %s", compra.getCliente(), compra.getFornecedor(),
						compra.getDescricao(), compra.getData().replace("-", "/")) + " | ";
			} else {
				resultado += String.format("%s, %s, %s, %s", compra.getCliente(), compra.getFornecedor(),
						compra.getDescricao(), compra.getData().replace("-", "/"));
			}
		}
		return resultado;
	}
}
