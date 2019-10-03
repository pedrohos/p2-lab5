package testesSaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import saga.IdProduto;
import saga.Produto;

class ProdutoTest {

	static Produto pincel = new Produto("Pincel", "Pincel de Quadros", 2.5);
	static Produto piloto = new Produto("Pincel", "Pincel de Quadros", 3.5);
	
	@Test
	void testSetPreco() {
		try {
			pincel.setPreco(-2);
			fail("Preco invalido aceito.");
		} catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao de produto: preco invalido.");
		}
	}

	@Test
	void testToString() {
		assertEquals(pincel.toString(), "Pincel - Pincel de Quadros - R$2,50");
	}

	@Test
	void testEqualsObject() {
		assertEquals(pincel, piloto);
	}

}
