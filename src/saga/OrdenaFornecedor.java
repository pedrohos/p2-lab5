package saga;

import java.util.Comparator;

public class OrdenaFornecedor implements Criterio {

	@Override
	public int compare(Compra o1, Compra o2) {
		if (o1.getFornecedor().compareTo(o2.getFornecedor()) == 0) {
			return (o1.getCliente() + o1.getDescricao() + o1.getData()).compareTo(o2.getCliente() + o2.getDescricao() + o2.getData());
		}
		return o1.getFornecedor().compareTo(o2.getFornecedor());
	}
}
