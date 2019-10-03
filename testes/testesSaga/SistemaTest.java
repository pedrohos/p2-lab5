package testesSaga;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import saga.Sistema;

class SistemaTest {

	static Sistema sistema;
	
	@BeforeAll
	static void criaSistema() {
		sistema = new Sistema();
	}
	
	@Test
	void testAdicionaClienteVazio() {
		try {
			sistema.adicionaCliente("", "Sandra", "sandra@computacao.ufcg.edu.br", "LSD");
			fail("Cpf foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.adicionaCliente("154784959812", "", "marcela@computacao.ufcg.edu.br", "LCC2");
			fail("Nome foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.adicionaCliente("154784959812", "Marcela", "", "LCC2");
			fail("Telefone foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.adicionaCliente("154784959812", "Marcela", "marcela@computacao.ufcg.edu.br", "");
			fail("Telefone foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testAdicionaClienteNulo() {
		try {
			sistema.adicionaCliente(null, "Sandra", "sandra@computacao.ufcg.edu.br", "LSD");
			fail("Cpf foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.adicionaCliente("154784959812", null, "marcela@computacao.ufcg.edu.br", "LCC2");
			fail("Nome foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.adicionaCliente("154784959812", "Marcela", null, "LCC2");
			fail("Email foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.adicionaCliente("154784959812", "Marcela", "marcela@computacao.ufcg.edu.br", null);
			fail("Localizacao foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
	}

	@Test
	void testAdicionaCliente() {
		assertEquals(sistema.adicionaCliente("18914948974", "Fernando", "fernando@computacao.ufcg.edu.br", "LSD"), "18914948974");
	}
	
	@Test
	void testExibeCliente() {
		sistema.adicionaCliente("15148942398", "Cassia", "cassia@computacao.ufcg.edu.br", "LSD");
		sistema.adicionaCliente("89564512436", "Caio", "caio@computacao.ufcg.edu.br", "LCC");
		sistema.adicionaCliente("78948946516", "Tamires", "tamires@computacao.ufcg.edu.br", "SPLAB");
		assertEquals(sistema.exibeCliente("15148942398"), "Cassia - LSD - cassia@computacao.ufcg.edu.br");
	}
	
	@Test
	void testExibeClienteVazioOuNulo() {
		try {
			sistema.exibeCliente("");
			fail("Cpf esta vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.exibeCliente(null);
			fail("Cpf esta nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testExibeClienteInexistente() {
		try {
			sistema.exibeCliente("4894984141");
			fail("Cpf inexistente.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na exibicao do cliente: cliente nao existe.");
		}
	}

	@Test
	void testEditaClienteInvalido() {
		try {
			sistema.editaCliente("", "nome", "Carla");
			fail("Cpf esta vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.editaCliente(null, "nome", "Carla");
			fail("Cpf esta nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.editaCliente("15148942398", "", "Carla");
			fail("Atributo esta vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.editaCliente("15148942398", null, "Carla");
			fail("Atributo esta nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.editaCliente("15148942398", "nome", "");
			fail("Valor esta vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.editaCliente("15148942398", "nome", null);
			fail("Valor esta nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.editaCliente("15148942398", "cpf", "Carla");
			fail("Atributo nao pode ser cpf.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao do cliente: cpf nao pode ser editado.");
		}
		
		try {
			sistema.editaCliente("15148942398", "telefone", "Carla");
			fail("Atributo nao existe.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao do cliente: atributo nao existe.");
		}
		
		try {
			sistema.editaCliente("48948941538", "telefone", "Carla");
			fail("Cpf nao existe.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao do cliente: cliente nao existe.");
		}
	}

	@Test
	void testListaClientes() {
		assertEquals(sistema.listaClientes(), "Fernando - LSD - fernando@computacao.ufcg.edu.br | "
											+ "Caio - LCC - caio@computacao.ufcg.edu.br | "
											+ "Cassia - LSD - cassia@computacao.ufcg.edu.br");
	}

	@Test
	void testRemoveClienteInvalido() {
		try {
			sistema.removeCliente("");
			fail("Cpf esta vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		}
		
		try {
			sistema.removeCliente(null);
			fail("Cpf esta nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		}
		
		try {
			sistema.removeCliente("77123154812");
			fail("Cpf nao existe.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na remocao do cliente: cliente nao existe.");
		}
	}
	
	@Test
	void testRemoveCliente() {
		try {
			sistema.removeCliente("78948946516");
		} catch (IllegalArgumentException iae) {
			fail("Cpf existe.");
		}
	}
	
	@Test
	void testAdicionaFornecedorVazio() {
		try {
			sistema.adicionaFornecedor("", "hannah@xmail.com", "83 28956-2794");
			fail("Nome foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.adicionaFornecedor("Hannah", "", "83 28956-2794");
			fail("Email foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.adicionaFornecedor("Hannah", "hannah@xmail.com", "");
			fail("Telefone foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testAdicionaFornecedorNulo() {
		try {
			sistema.adicionaFornecedor(null, "hannah@xmail.com", "83 28956-2794");
			fail("Fornecedor foi cadastrado nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.adicionaFornecedor("Hannah", null, "83 28956-2794");
			fail("Fornecedor foi cadastrado nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.adicionaFornecedor("Hannah", "hannah@xmail.com", null);
			fail("Fornecedor foi cadastrado nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testAdicionaFornecedor() {
		assertEquals(sistema.adicionaFornecedor("Jaqueline", "jaqueline@xmail.com", "83 78949-4141"), "Jaqueline");
	}
	
	@Test
	void testAdicionaFornecedorInvalido() {		
		try {
			sistema.adicionaFornecedor("Amanda", "depositoearmazenamento@xmail.com", "83 79547-8888");
			fail("Fornecedor ja foi cadastrado.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
	}

	@Test
	void testExibeFornecedorNuloOuVazio() {
		try {
			sistema.exibeFornecedor("");
			fail("Nome e vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na exibicao do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.exibeFornecedor(null);
			fail("Nome e nulo.");
		} catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testExibeFornecedorInexistente() {
		try {
			sistema.exibeFornecedor("Aliexpress");
			fail("Fornecedor nao existe.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
	}
	
	@Test
	void testExibeFornecedor() {
		sistema.adicionaFornecedor("Amanda", "amanda@xmail.com", "83 79845-8956");
		sistema.adicionaFornecedor("Amaro", "amaro@xmail.com", "83 77484-9141");
		assertEquals(sistema.exibeFornecedor("Amanda"), "Amanda - amanda@xmail.com - 83 79845-8956");
	}

	@Test
	void testListaFornecedores() {
		assertEquals(sistema.listaFornecedores(), "Amaro - amaro@xmail.com - 83 77484-9141 | "
												+ "Amanda - amanda@xmail.com - 83 79845-8956");
	}

	@Test
	void testEditaFornecedorInvalido() {
		try {
			sistema.editaFornecedor("", "email", "amandax@xmail.com");
			fail("Nome esta vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.editaFornecedor("Amanda", "", "amandax@xmail.com");
			fail("Atributo esta vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.editaFornecedor("Amanda", "email", "");
			fail("Atributo esta vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.editaFornecedor(null, "email", "amandax@xmail.com");
			fail("Nome esta nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.editaFornecedor("Amanda", null, "amandax@xmail.com");
			fail("Valor esta nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.editaFornecedor("Amanda", "email", null);
			fail("Valor esta nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.editaFornecedor("Amanda", "nome", "amandax@xmail.com");
			fail("Atributo nao pode ser nome.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao do fornecedor: nome nao pode ser editado.");
		}
		
		try {
			sistema.editaFornecedor("Amanda", "cpf", "17489489148");
			fail("Atributo nao existe.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao do fornecedor: atributo nao existe.");
		}
		
		try {
			sistema.editaFornecedor("Moura", "email", "mourax@xmail.com");
			fail("Nome nao existe.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao do fornecedor: fornecedor nao existe.");
		}
	}

	@Test
	void testRemoveFornecedorInvalido() {
		try {
			sistema.removeFornecedor("");
			fail("Nome esta vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.removeCliente(null);
			fail("Nome esta nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		}
		
		try {
			sistema.removeCliente("Paulo");
			fail("Nome nao existe.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na remocao do cliente: cliente nao existe.");
		}
	}
	
	@Test
	void testRemoveFornecedor() {
		sistema.adicionaFornecedor("Felipe", "felipe@xmail.com", "83 98778-9989");
		try {
			sistema.removeFornecedor("Felipe");
		} catch (IllegalArgumentException iae) {
			fail("Nome existe.");
		}
	}

	@Test
	void testAdicionaProdutoVazio() {
		try {
			sistema.adicionaProduto("", "Raquete Eletrica", "Recomendado o uso em rios, somente sem protecao.", 12.2);
			fail("Fornecedor foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.adicionaProduto("Amanda", "", "Recomendado o uso em rios, somente sem protecao.", 12.2);
			fail("Nome foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.adicionaProduto("Amanda", "Raquete Eletrica", "", 12.2);
			fail("Descricao foi cadastradA vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
	}
	
	@Test
	void testAdicionaProdutoNulo() {
		try {
			sistema.adicionaProduto(null, "Raquete Eletrica", "Recomendado o uso em rios, somente sem protecao.", 12.2);
			fail("Fornecedor foi cadastrado nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.adicionaProduto("Amanda", null, "Recomendado o uso em rios, somente sem protecao.", 12.2);
			fail("Nome foi cadastrado nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.adicionaProduto("Amanda", "Raquete Eletrica", null, 12.2);
			fail("Descricao foi cadastradA nula.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}
		
		try {
			sistema.adicionaProduto("Amanda", "Raquete Eletrica", "Recomendado o uso em rios, somente sem protecao.", 0);
			fail("Preco invalido.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro no cadastro de produto: preco invalido.");
		}
	}
	
	@Test
	void testAdicionaProduto() {
		try {
			sistema.adicionaProduto("Amanda", "Grafite da Radex", "Agora com capsula de niobio.", 15);
		} catch (IllegalArgumentException iae) {
			fail("Ocorreu um erro.");
		}
	}
	
	@Test
	void testExibeProdutoVazio() {
		try {
			sistema.exibeProduto("", "Recomendado o uso em rios, somente sem protecao.", "Amanda");
			fail("Nome foi cadastrado vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.exibeProduto("Raquete Eletrica", "", "Amanda");
			fail("Descricao foi cadastrado vazia.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}
		
		try {
			sistema.exibeProduto("Raquete Eletrica", "Recomendado o uso em rios, somente sem protecao.", "");
			fail("Fornecedor foi cadastrada vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
	}
	
	@Test
	void testExibeProdutoNulo() {
		try {
			sistema.exibeProduto(null, "Raquete Eletrica", "Recomendado o uso em rios, somente sem protecao.");
			fail("Nome foi cadastrado nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.exibeProduto("Amanda", null, "Recomendado o uso em rios, somente sem protecao.");
			fail("Descricao foi cadastrado nula.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}
		
		try {
			sistema.exibeProduto("Amanda", "Raquete Eletrica", null);
			fail("Fornecedor foi cadastrada nula.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
	}

	@Test
	void testExibeProduto() {
		assertEquals(sistema.exibeProduto("Chave Desconhecida", "Talvez seja a do banheiro", "Amanda"),
										  "Chave Desconhecida - Talvez seja a do banheiro - R$3,00");
	}

	@Test
	void testListarProdutosInvalido() {
		try {
			sistema.listarProdutos("Ademar");
		} catch(IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na listagem de produtos: fornecedor nao existe.");
		}
		
	}
	
	@Test
	void testListarProdutos() {
		assertEquals(sistema.listarProdutos("Amanda"), "Amanda - Aro banhado a ouro - Aumenta o peso do veiculo em pelo menos 1t - R$13850,70 | "
													 + "Amanda - Chave Desconhecida - Talvez seja a do banheiro - R$3,00");
	}

	@Test
	void testListarProdutosTodosFornecedores() {
		sistema.adicionaProduto("Amanda", "Aro banhado a ouro", "Aumenta o peso do veiculo em pelo menos 1t", 13850.7);
		sistema.adicionaProduto("Amanda", "Chave Desconhecida", "Talvez seja a do banheiro", 3);
		sistema.adicionaProduto("Amaro", "Foto 3x4", "Figurinha adesiva da copa de 2014", 3.5);
		assertEquals(sistema.listarProdutosTodosFornecedores(), "Amaro - Foto 3x4 - Figurinha adesiva da copa de 2014 - R$3,50 | "
																+ "Amanda - Aro banhado a ouro - Aumenta o peso do veiculo em pelo menos 1t - R$13850,70 | "
																+ "Amanda - Chave Desconhecida - Talvez seja a do banheiro - R$3,00");
	}
	
	@Test
	void testEditaProdutoInvalido() {
		try {
			sistema.editaProduto("", "Recomendado o uso em rios, somente sem protecao.", "Amanda", 12.2);
			fail("Nome esta vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.editaProduto("Raquete Eletrica", "", "Amanda", 12.2);
			fail("Descricao esta vazia.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}
		
		try {
			sistema.editaProduto("Raquete Eletrica", "Recomendado o uso em rios, somente sem protecao.", "", 12.2);
			fail("Fornecedor esta vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.editaProduto(null, "Recomendado o uso em rios, somente sem protecao.", "Amanda", 12.2);
			fail("Nome esta nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.editaProduto("Raquete Eletrica", null, "Amanda", 12.2);
			fail("Descricao esta nula.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}
		
		try {
			sistema.editaProduto("Raquete Eletrica", "Recomendado o uso em rios, somente sem protecao.", null, 12.2);
			fail("Fornecedor esta nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.editaProduto("Estocador de Vento", "Tecnologia que revolucionou a industria energetica eolica.", "Amanda", 12.2);
			fail("Produto nao existe.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao de produto: produto nao existe.");
		}
		
		try {
			sistema.editaProduto("Raquete Eletrica", "Recomendado o uso em rios, somente sem protecao.", "Carol", 12.2);
			fail("Fornecedor nao existe.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao de produto: fornecedor nao existe.");
		}
		
		try {
			sistema.editaProduto("Raquete Eletrica", "Recomendado o uso em rios, somente sem protecao.", "Amanda", -4);
			fail("Preco invalido.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na edicao de produto: preco invalido.");
		}
	}
	
	@Test
	void testRemoveProdutoInvalido() {
		sistema.adicionaProduto("Amanda", "Raquete Eletrica", "Recomendado o uso em rios, somente sem protecao.", 26.5);
		try {
			sistema.removeProduto("", "Recomendado o uso em rios, somente sem protecao.", "Amanda");
			fail("Nome esta vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.removeProduto("Raquete Eletrica", "", "Amanda");
			fail("Descricao esta vazia.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}
		
		try {
			sistema.removeProduto("Raquete Eletrica", "Recomendado o uso em rios, somente sem protecao.", "");
			fail("Fornecedor esta vazio.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.removeProduto(null, "Recomendado o uso em rios, somente sem protecao.", "Amanda");
			fail("Nome esta nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.removeProduto("Raquete Eletrica", null, "Amanda");
			fail("Descricao esta nula.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}
		
		try {
			sistema.removeProduto("Raquete Eletrica", "Recomendado o uso em rios, somente sem protecao.", null);
			fail("Fornecedor esta nulo.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		
		try {
			sistema.removeProduto("Estocador de Vento", "Tecnologia que revolucionou a industria energetica eolica.", "Amanda");
			fail("Produto nao existe.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na remocao de produto: produto nao existe.");
		}
		
		try {
			sistema.removeProduto("Raquete Eletrica", "Recomendado o uso em rios, somente sem protecao.", "Carol");
			fail("Fornecedor nao existe.");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na remocao de produto: fornecedor nao existe.");
		}
	}

	@Test
	void testRemoveProduto() {
		sistema.adicionaProduto("Amanda", "Raquete Eletrica", "Recomendado o uso em rios, somente sem protecao.", 26.5);
		assertEquals(sistema.exibeProduto("Raquete Eletrica", "Recomendado o uso em rios, somente sem protecao.", "Amanda"), "Raquete Eletrica - Recomendado o uso em rios, somente sem protecao. - R$26,50");
		sistema.removeProduto("Raquete Eletrica", "Recomendado o uso em rios, somente sem protecao.", "Amanda");
		try {
			sistema.exibeProduto("Raquete Eletrica", "Recomendado o uso em rios, somente sem protecao.", "Amanda");
		} catch (IllegalArgumentException iae) {
			assertEquals(iae.getMessage(), "Erro na exibicao de produto: produto nao existe.");
		}
	}

}
