package saga;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Ordenacao pelos fornecedores.
 * 
 * @author Pedro Henrique
 */
public class OrdenaFornecedor implements Criterio {

	/**
	 * Compara duas compras pelo nome do fornecedor. Caso os nome sejam iguais serao
	 * comparados o nome do cliente + descricao + data.
	 */
	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getFornecedor().compareTo(o2.getFornecedor()) == 0) {
			return (o1.getCliente() + o1.getDescricao() + o1.getData())
					.compareTo(o2.getCliente() + o2.getDescricao() + o2.getData());
		}
		return o1.getFornecedor().compareTo(o2.getFornecedor());
	}

	/**
	 * Ordena pelos fornecedores, depois pelo cliente + descricao + data.
	 */
	@Override
	public String listaCompras(ArrayList<Compra> compras) {
		String resultado = "";
		Iterator<Compra> it = compras.iterator();
		while (it.hasNext()) {
			Compra compra = it.next();
			if (it.hasNext()) {
				resultado += String.format("%s, %s, %s, %s", compra.getFornecedor(), compra.getCliente(),
						compra.getDescricao(), compra.getData().replace("-", "/")) + " | ";
			} else {
				resultado += String.format("%s, %s, %s, %s", compra.getFornecedor(), compra.getCliente(),
						compra.getDescricao(), compra.getData().replace("-", "/"));
			}
		}
		return resultado;
	}
}
