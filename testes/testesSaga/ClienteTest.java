package testesSaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import saga.Cliente;

class ClienteTest {

	static Cliente sandra;
	static Cliente carlos;
	
	@BeforeAll
	static void criaClientes() {
		sandra = new Cliente("12345678901", "Sandra", "sandra@computacao.ufcg.edu.br", "LSD");
		carlos = new Cliente("78541236548", "Carlos", "carlos@computacao.ufcg.edu.br", "SPLAB");
	}

	@Test
	void testConstrutorVazio() {
		try {
			Cliente marcela = new Cliente("", "Marcela", "marcela@computacao.ufcg.edu.br", "LCC2");
			fail("Cpf foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}
		
		try {
			Cliente marcela = new Cliente("154784959812", "", "marcela@computacao.ufcg.edu.br", "LCC2");
			fail("Nome foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			Cliente marcela = new Cliente("154784959812", "Marcela", "", "LCC2");
			fail("Email foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		
		try {
			Cliente marcela = new Cliente("154784959812", "Marcela", "marcela@computacao.ufcg.edu.br", "");
			fail("Localizacao foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testConstrutorNulo() {
		try {
			Cliente marcela = new Cliente(null, "Marcela", "marcela@computacao.ufcg.edu.br", "LCC2");
			fail("Cpf foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}
		
		try {
			Cliente marcela = new Cliente("154784959812", null, "marcela@computacao.ufcg.edu.br", "LCC2");
			fail("Nome foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			Cliente marcela = new Cliente("154784959812", "Marcela", null, "LCC2");
			fail("Email foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		
		try {
			Cliente marcela = new Cliente("154784959812", "Marcela", "marcela@computacao.ufcg.edu.br", null);
			fail("Localizacao foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
	}

	@Test
	void testToString() {
		assertEquals(sandra.toString(), "Sandra - LSD - sandra@computacao.ufcg.edu.br");
	}

	@Test
	void testEqualsObject() {
		assertEquals(sandra, new Cliente("12345678901", "Alexandre", "alexandre@computacao.ufcg.edu.br", "LCC3"));
		assertNotEquals(sandra, new Cliente("89498481131", "Sandra", "alexandre@computacao.ufcg.edu.br", "LCC3"));
		assertNotEquals(sandra, new Cliente("89498481131", "Alexandre", "sandra@computacao.ufcg.edu.br", "LCC3"));
		assertNotEquals(sandra, new Cliente("89498481131", "Alexandre", "alexandre@computacao.ufcg.edu.br", "LSD"));
	}
}
