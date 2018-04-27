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
	private static Hash hash;
	
	@Rule public TestName name = new TestName();
	
	@Test
	public void test1() {
		System.out.println("TESTES EXCEÇÕES");
		System.out.println("Iniciando os Testes sobre Exceções");
		System.out.println("Testando se é lançada exceção quando se efetua uma busca "
				+ "em uma lista vazia");
		System.out.println("Exceção Esperada: Hash Vazio");
		try {
			hash.busca(10);
			fail("A exceção não foi lançada");
		}catch(Exception e) {
			System.out.println("Mensagem recebida: " + e.getMessage());
			assertEquals("Hash Vazio", e.getMessage());
			System.out.println("O teste passou");
			
		}
	}
	
	@Test
	public void test2() {
		System.out.println("Testando se é lançada exceção quando se efetua uma exlusão "
				+ "em uma lista vazia");
		System.out.println("Exceção Esperada: Hash Vazio");
		try {
			hash.exclui(10);
			fail("A exceção não foi lançada");
		}catch(Exception e) {
			System.out.println("Mensagem recebida: " + e.getMessage());
			assertEquals("Hash Vazio", e.getMessage());
			System.out.println("O teste passou");
			
		}
	}
	
	@Test
	public void test3() {
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
			System.out.println("O teste passou");
		}
	}
	
	@Test
	public void test4() {
		
	}

}
