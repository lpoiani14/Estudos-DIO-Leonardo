import java.util.*;

/*
Faça um programa que simule um lançamento de dados.
Lance o dado 100 vezes e armazene.
Depois, mostre quantas vezes cada valor foi inserido.
*/
public class Main {

	public static void main(String[] args) {
		// Criando os resultados dos lançamentos
		Locale.setDefault(new Locale("en", "US"));
		List<Integer> lancamentos = new ArrayList<>();
		int numLancamentos = 100;
		int ladosDado = 6;
		Random lancador = new Random();
		
		for (int i = 0; i < numLancamentos; i++) {
			lancamentos.add(lancador.nextInt(ladosDado)+1);
		}
		
		// Contando o numero de lancamentos por numero
		Map<Integer, Integer> mapaLancamentos = new HashMap<>();
		for (Integer valor : lancamentos) {
			if(mapaLancamentos.containsKey(valor)) {
				mapaLancamentos.put(valor, mapaLancamentos.get(valor)+1);
			}
			else
				// Cria a primeira vez que o valor apareceu
				mapaLancamentos.put(valor, 1);
		}
		System.out.println(mapaLancamentos);
		
		// Calcula a porcentagem de vezes por valor
		Map<Integer, Float> mapaLancamentosPorcento = new HashMap<>();
		for(Map.Entry<Integer, Integer> valor : mapaLancamentos.entrySet()) {
			mapaLancamentosPorcento.put(valor.getKey(), ((float)valor.getValue()/numLancamentos*100));
		}
		System.out.println("Porcentagem por valor:");
		for(Map.Entry<Integer, Float> valorPorcento : mapaLancamentosPorcento.entrySet()) {
			System.out.printf("%d - %.2f%% \n", valorPorcento.getKey(), valorPorcento.getValue());
		}
	}

}
