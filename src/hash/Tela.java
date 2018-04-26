package hash;

import java.util.Scanner;

public class Tela {
	private Scanner sc;
	 private Hash hash;

	 public Tela() {
	     sc = new Scanner(System.in);
	 }

	 public void tela() {
	    try {
	    	System.out.println("Bem-vindo\n");
	    	System.out.println("Digite o tamanho total do hash:\n");
	    	int tamanho = sc.nextInt();
	    	System.out.println("Digite o tamanho da tabela de espalhamento:\n");
	    	int tamanhoEspalhamento = sc.nextInt();
	    	//Colocar a construcao do hash aqui;
	    	hash = new Hash(tamanhoEspalhamento, tamanho);
		        
	    }catch(Exception e) {
	    	System.out.println(e.getMessage());
	    	tela();
	    }
	 }
	 
	 private void operacoes() {
		 try {
			 int opcao = 0;
			 while(opcao != 5) {
				 System.out.println("Digite o número correspondente a sua escolha:\n"
						 +"1 - Inserir novo elemento\n2 - Buscar elemento\n3 - Excluir elemento\n4 -"
						 +" Listar todos\n5 - Sair");
				 opcao = sc.nextInt();
				 switch(opcao) {
				 	case 1:
				 		System.out.println("Digite o novo elemento que será inserido:\n");
				 		int numero = sc.nextInt();
				 		hash.insere(numero);
				 		break;
				 	case 2:
				 		System.out.println("Digite o elemento que será buscado:\n");
				 		int elemento = sc.nextInt();
				 		System.out.println(hash.busca(elemento));
				 		break;
				 	case 3:
				 		System.out.println("Digite o elemento que será excluído:\n");
				 		int excluido = sc.nextInt();
				 		hash.exclui(excluido);
				 		break;
				 	case 4:
				 		hash.listarTodos();
				 		break;
				 	case 5:
				 		System.out.println("Até logo");
				 		break;
				 	default:
				 		System.out.println("A opção escolhida não é válida");
				 }
			 }
		 }catch(Exception e) {
			 System.out.println(e.getMessage());
			 operacoes();
		 }
	 }
}
