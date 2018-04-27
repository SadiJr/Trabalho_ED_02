package teste;

import hash.Hash; 

import static org.junit.Assert.*; 
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class HashTest {
	//Hash usado para testes sobre os métodos públicos
	private static Hash hash;
	//Hash usada para testes de Exceção
	private Hash hash2;
	
	@Rule public TestName name = new TestName();
	
	@Test
	public void test1() {
		System.out.println("TESTES EXCEÇÕES\n");
		System.out.println("Iniciando os Testes sobre Exceções\n");
		System.out.println("TESTE 01");
		System.out.println("Testando se é lançada exceção quando se efetua uma busca "
				+ "em uma lista vazia");
		System.out.println("Exceção Esperada: Hash Vazio");
		try {
			hash2 = new Hash(3,10);
			hash2.busca(10);
			fail("A exceção não foi lançada");
		}catch(Exception e) {
			System.out.println("Mensagem recebida: " + e.getMessage());
			assertEquals("Hash Vazio", e.getMessage());
			System.out.println("O teste passou\n");
			
		}
	}
	
	@Test
	public void test2() {
		System.out.println("TESTE 02");
		System.out.println("Testando se é lançada exceção quando se efetua uma exlusão "
				+ "em uma lista vazia");
		System.out.println("Exceção Esperada: Hash Vazio");
		try {
			hash2 = new Hash(3, 10);
			hash2.exclui(10);
			fail("A exceção não foi lançada");
		}catch(Exception e) {
			System.out.println("Mensagem recebida: " + e.getMessage());
			assertEquals("Hash Vazio", e.getMessage());
			System.out.println("O teste passou\n");
			
		}
	}
	
	@Test
	public void test3() {
		System.out.println("TESTE 03");
		System.out.println("Testando se é lançada exceção quando se cria um Hash "
				+ "cujo módulo é menos que 3 vezes menor que o tamanho total do Hash");
		System.out.println("Exceção Esperada: O módulo deve ser, no mínimo, "
				+ "3 vezes menor que o tamanho total do Hash");
		try {
			hash = new Hash(5, 15);
			fail("Uma exceção deveria ser lançada");
		}catch(Exception e) {
			System.out.println("Mensagem recebida: " + e.getMessage());
			assertEquals("O módulo deve ser, no mínimo, 3 vezes menor "
					+ "que o tamanho total do Hash", e.getMessage());
			System.out.println("O teste passou\n");
		}
	}
	
	@Test
	public void test4() {
		System.out.println("TESTE 04");
		System.out.println("Testando se é lançada exceção quando se tenta inserir "
				+ "um elemento quando o Hash já está cheio");
		System.out.println("Exceção Esperada: O Hash está cheio!");
		try {
			hash2 = new Hash(2, 8);
			hash2.insere(0);
			hash2.insere(1);
			hash2.insere(2);
			hash2.insere(3);
			hash2.insere(4);
			hash2.insere(5);
			hash2.insere(6);
			hash2.insere(7);
			hash2.insere(8);
			fail("Uma exceção deveria ser lançada");
		}catch(Exception e) {
			System.out.println("Mensagem recebida: " + e.getMessage());
			assertEquals("O Hash está cheio!", e.getMessage());
			System.out.println("O teste passou\n");	
		}	
	}
	
	@Test
	public void test5() {
		System.out.println("TESTE 05");
		System.out.println("Testando se é lançada exceção quando se tenta excluir um elemento que não está na lista");
		System.out.println("Exceção Esperada: O elemento 8 não se encontra no Hash.");
		try {
			hash2 = new Hash(3, 10);
			hash2.insere(0);
			hash2.insere(1);
			hash2.insere(2);
			hash2.insere(5);
			hash2.exclui(8);
			fail("Uma exceção deveria ser lançada");
		}catch(Exception e) {
			System.out.println("Mensagem recebida: " + e.getMessage());
			assertEquals("O elemento 8 não se encontra no Hash.", e.getMessage());
			System.out.println("O teste passou\n");
		}
	}
	
	@Test
	public void test6() {
		System.out.println("TESTES HASH\n");
		System.out.println("TESTE 06");
		System.out.println("Iniciando os testes sobre o Hash");
		System.out.println("Testando se a inserção funciona");
		try {
			hash = new Hash(5, 20);
			hash.insere(0);
			hash.insere(8);
			hash.insere(14);
			hash.insere(5);
			hash.insere(10);
			assertTrue(hash.busca(14));
			System.out.println("O teste passou\n");
		}catch(Exception e) {
			fail("O teste falhou\n");
		}
	}
	
	@Test
	public void test7() {
		System.out.println("TESTE 07");
		System.out.println("Testando se a busca funciona");
		System.out.println("Testando se é retornado true quando se busca um elemento inserido na lista");
		try {
			System.out.println("Boolean retornado: " + hash.busca(8));
			assertTrue(hash.busca(8));
			System.out.println("O Teste passou\n");
		}catch(Exception e) {
			fail("O teste falhou\n");
		}
	}
	
	@Test 
	public void test8() {
		System.out.println("TESTE 08");
		System.out.println("Testando se é retornado false quando se busca um elemento inserido na lista");
		try {
			System.out.println("Boolean retornado: " + hash.busca(15));
			assertFalse(hash.busca(15));
			System.out.println("O Teste passou\n");
		}catch(Exception e) {
			fail("O teste falhou\n");
		}
	}
	
	@Test
	public void test9() {
		System.out.println("TESTE 09");
		System.out.println("Testando se a exclusão funciona");
		try {
			System.out.println("Excluindo elemento 5");
			hash.exclui(5);
			System.out.println("Buscando elemento 5: " + hash.busca(5));
			assertFalse(hash.busca(5));
			System.out.println("O teste passou\n");
			System.out.println("Todos os Testes Passaram\nSUCESSO!");
		}catch(Exception e) {
			fail("O teste falhou");
		}
	}
}
