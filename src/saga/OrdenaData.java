package saga;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Ordenacao pelas datas.
 * 
 * @author Pedro Henrique
 */
public class OrdenaData implements Criterio {

	/**
	 * Compara duas datas pela sua ordem de precedencia.
	 */
	@Override
	public int compare(Compra o1, Compra o2) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date data1 = new Date();
		Date data2 = new Date();
		try {
			data1 = sdf.parse(o1.getData());
			data2 = sdf.parse(o2.getData());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (data1.equals(data2)) {
			return (o1.getCliente() + o1.getFornecedor() + o1.getDescricao())
					.compareTo(o2.getCliente() + o2.getFornecedor() + o2.getDescricao());
		}
		if (data1.before(data2))
			return -1;
		return 1;
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
				resultado += String.format("%s, %s, %s, %s", compra.getData().replace("-", "/"), compra.getCliente(),
						compra.getFornecedor(), compra.getDescricao()) + " | ";
			} else {
				resultado += String.format("%s, %s, %s, %s", compra.getData().replace("-", "/"), compra.getCliente(),
						compra.getFornecedor(), compra.getDescricao());
			}
		}
		return resultado;
	}
}
