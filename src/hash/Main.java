package hash;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import teste.HashTest;

public class Main {

	public static void main(String[] args) {
		try {
			JUnitCore junit = new JUnitCore();
			//junit.run(ListaTest.class);
			HashTest teste = new HashTest();
			Result result = junit.run(teste.getClass());
			//Util.printResult(result);
			
			System.out.println("Foram efetuados " + result.getRunCount() + " testes em "+ result.getRunTime() +"ms.");
			if (result.wasSuccessful()) {
				System.out.println("Até Logo");
				//System.out.println("\nAll tests were successfull!");
			}else {
				System.err.println(result.getFailureCount() + "Failures:");
				for (Failure fail: result.getFailures()){
					System.err.println("Failure in: "+ fail.getTestHeader());
					System.err.println(fail.getMessage());
					System.err.println(fail.getTrace());
					System.out.println();
				}
				if(result.getIgnoreCount() > 0) {
					System.out.println("And " + result.getIgnoreCount() + " tests ignored");
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		/*				Leia-me ou Morra!
		Esse método, e essa classe, foram criados para testes manuais
		Se o professor quiser testar manualmente, comente as linhas acima e descomente
		as linhas abaixo;
		
		Tela tela = new Tela();
		tela.tela();
		*/

	}

}
