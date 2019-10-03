package testesSaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import saga.IdProduto;

class IdProdutoTest {

	static IdProduto id = new IdProduto("Pincel", "Pincel de Quadros");
	static IdProduto id2 = new IdProduto("Pincel", "Pincel de Paredes");
	static IdProduto id3 = new IdProduto("Paint", "Pincel de Quadros");
	

	@Test
	void testToString() {
		assertEquals(id.toString(), "Pincel - Pincel de Quadros");
	}

	@Test
	void testEqualsObject() {
		assertEquals(id, id);
		assertNotEquals(id, id2);
		assertNotEquals(id2, id3);
	}

}
