package saga;

import java.util.Comparator;

public class OrdenaCliente implements Criterio  {

	@Override
	public int compare(Compra o1, Compra o2) {
		
		if (o1.getCliente().compareTo(o2.getCliente()) == 0) {
			return (o1.getFornecedor() + o1.getDescricao() + o1.getData()).compareTo(o2.getFornecedor() + o2.getDescricao() + o2.getData());
		}
		return o1.getCliente().compareTo(o2.getCliente());
	}
}
