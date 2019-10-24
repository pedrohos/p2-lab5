package saga;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Representa o criterio de ordenacao.
 * 
 * @author Pedro Henrique
 */
public interface Criterio extends Comparator<Compra> {

	/**
	 * Compara compras.
	 */
	public int compare(Compra o1, Compra o2);

	/**
	 * Lista todas as compras.
	 * 
	 * @param compras e a lista de todas as compras.
	 * @return e retornado uma lista com as compras ordenadas.
	 */
	public String listaCompras(ArrayList<Compra> compras);
}
