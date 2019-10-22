package saga;

import java.util.ArrayList;
import java.util.Iterator;

public class OrdenaCliente implements Criterio  {

	@Override
	public int compare(Compra o1, Compra o2) {
		
		if (o1.getCliente().compareTo(o2.getCliente()) == 0) {
			return (o1.getFornecedor() + o1.getDescricao() + o1.getData()).compareTo(o2.getFornecedor() + o2.getDescricao() + o2.getData());
		}
		return o1.getCliente().compareTo(o2.getCliente());
	}

	@Override
	public String listaCompras(ArrayList<Compra> compras) {
		String resultado = "";
		Iterator<Compra> it = compras.iterator();
		while(it.hasNext()) {
			Compra compra = it.next();
			if (it.hasNext()) {
				resultado += String.format("%s, %s, %s, %s", compra.getCliente(), compra.getFornecedor(), compra.getNomeCompleto(),compra.getData()) + " | ";
			} else {
				resultado += String.format("%s, %s, %s, %s", compra.getCliente(), compra.getFornecedor(), compra.getNomeCompleto(),compra.getData());
			}
		}
		return resultado;
	}
}
