package testesSaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import saga.Fornecedor;

class FornecedorTest {

	static Fornecedor osvaldo; 
	static Fornecedor alice;
	
	@BeforeAll
	static void criaFornecedores() {
		osvaldo = new Fornecedor("Osvaldo", "osvaldovendas@xmail.com", "83289652321");
		alice = new Fornecedor("Alice", "alicecomercial@xmail.com", "83284546231");
		
		osvaldo.adicionaProduto("Caderno", "Edicao limitada: De surfista.", 25.5);
		osvaldo.adicionaProduto("Caderno Raro", "Edicao especial: De skatista.", 25.5);
		alice.adicionaProduto("Grafite", "Quebra a ponta em 20 linhas ou menos.", 6.5);
		alice.adicionaProduto("Km2 da Amazonia", "Poucos km ate esgotar a floresta!", 0.2);
	}
	

	@Test
	void testConstrutorVazio() {
		try {
			Fornecedor tiago = new Fornecedor("", "tiagoxkal@xmail.com", "832945123621");
			fail("Nome foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			Fornecedor tiago = new Fornecedor("Tiago", "", "832945123621");
			fail("Email foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		
		try {
			Fornecedor tiago = new Fornecedor("Tiago", "tiagoxkal@xmail.com", "");
			fail("Telefone foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testConstrutorNulo() {
		try {
			Fornecedor tiago = new Fornecedor(null, "tiagoxkal@xmail.com", "832945123621");
			fail("Nome foi cadastrado nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			Fornecedor tiago = new Fornecedor("Tiago", null, "832945123621");
			fail("Email foi cadastrado nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		
		try {
			Fornecedor tiago = new Fornecedor("Tiago", "tiagoxkal@xmail.com", null);
			fail("Telefone foi cadastrado nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
	}

	@Test
	void testExisteProduto() {
		assertEquals(osvaldo.existeProduto("Caderno", "Edicao limitada: De surfista."), true);
		assertEquals(osvaldo.existeProduto("Carregador", "Original do Paraguai."), false);
	}

	@Test
	void testPossuiProduto() {
		Fornecedor carla = new Fornecedor("Carla", "carlaprecocerto@xmail.com", "83298654213");
		assertEquals(carla.possuiProduto(), false);
		assertEquals(alice.possuiProduto(), true);
	}

	@Test
	void testAdicionaProduto() {
		alice.adicionaProduto("Narguile", "Testada em massa na amazonia a 2 meses com Anacardium Giganteum", 195.5);
		assertEquals(alice.existeProduto("Narguile", "Testada em massa na amazonia a 2 meses com Anacardium Giganteum"), true);
	}

	@Test
	void testExibeProduto() {
		assertEquals(osvaldo.exibeProduto("Caderno", "Edicao limitada: De surfista."), "Caderno - Edicao limitada: De surfista. - R$25,50");
	}
	
	@Test
	void testExibeProdutoInvalido() {
		try {
			alice.exibeProduto("Cachorro quente chines", "Eu nao comeria...");
			fail("Nenhuma excecao lancada");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na exibicao de produto: produto nao existe."); 
		}
	}

	@Test
	void testListarProdutos() {
		assertEquals(alice.listarProdutos(), "Alice - Km2 da Amazonia - Poucos km ate esgotar a floresta! - R$0,20 | "
										   + "Alice - Grafite - Quebra a ponta em 20 linhas ou menos. - R$6,50");
	}

	@Test
	void testEditaProduto() {
		osvaldo.editaProduto("Caderno", "Edicao limitada: De surfista.", 785.03);
		assertEquals(osvaldo.exibeProduto("Caderno", "Edicao limitada: De surfista."), "Caderno - Edicao limitada: De surfista. - R$785,03");
	}

	@Test
	void testRemoveProduto() {
		alice.adicionaProduto("Ifone do Mercado Livre", "100% Original, ifone da aple, frete gratis.", 300);
		assertEquals(alice.exibeProduto("Ifone do Mercado Livre", "100% Original, ifone da aple, frete gratis."), "Ifone do Mercado Livre - "
										+ "100% Original, ifone da aple, frete gratis. - R$300,00");
		
		alice.removeProduto("Ifone do Mercado Livre", "100% Original, ifone da aple, frete gratis.");
		try {
			alice.exibeProduto("Ifone do Mercado Livre", "100% Original, ifone da aple, frete gratis.");
			fail("Produto nao foi removido.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na exibicao de produto: produto nao existe.");
		}
	}
	@Test
	void testEqualsObject() {
		assertEquals(osvaldo, new Fornecedor("Osvaldo", "contasecundaria@xmail.com", "88298654124"));
		assertNotEquals(osvaldo, new Fornecedor("Vanderlei", "osvaldovendas@xmail.com", "88298481295"));
		assertNotEquals(osvaldo, new Fornecedor("Daniel", "contasecundaria@xmail.com", "83289652321"));
	}

}
