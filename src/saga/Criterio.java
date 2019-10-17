package saga;

import java.util.Comparator;

public interface Criterio extends Comparator<Compra> {
	public int compare(Compra o1, Compra o2);
}
