import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/* Faça um programa que receba a temperatura média dos 6
primeiros meses do ano e armazene-as em uma lista.

Após isto, calcule a média semestral das temperaturas e
mostre todas as temperaturas acima desta média, e em que
mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2
– Fevereiro e etc).
 */
public class Main {

	public static void main(String[] args) {
		// Cria a lista de meses
		Meses listaMeses = new Meses();
		System.out.println("Meses: " + listaMeses.getNomes());
		
		// Recebe input de temperaturas no número de meses selecionados
		int numMeses = 6;
		Temperaturas temperaturas = new Temperaturas();
		temperaturas.setListaTemp(listaMeses.getNomes(),numMeses);
		System.out.println(temperaturas);
		
		// Calcula a média de temperaturas nos meses
		System.out.println("A média de temperaturas é: "+ temperaturas.mediaTemp());
		
		// Verifica quais meses ficaram acima da média
		List<String> mesesAcima = temperaturas.mesesAcima(listaMeses.getNomes());
		System.out.println("Os meses acima da média são: "+ mesesAcima);
		
		
	}
}


class Temperaturas{
	private List<Double> listaTemp;

	public Temperaturas() {
		super();
		this.listaTemp = new ArrayList<Double>();
	}

	public List<Double> getListaTemp() {
		return listaTemp;
	}

	// Método para entrada das temperaturas
	public void setListaTemp(List<String> meses, int mesesContagem) {
		Scanner scan = new Scanner(System.in);
			for (int i = 0; i < mesesContagem; i++) {
				System.out.println("Entre com a temperatura de " + meses.get(i) + ": ");
				// Verificação se o input é válido e criação da lista
				while (true) {
					try {
						this.listaTemp.add(scan.nextDouble());
						break;
					} 
					catch (InputMismatchException e) {
						System.out.println("Entre com um valor inteiro de temperatura: ");
						scan.next();
					} 
				}
			}
	}

	@Override
	public String toString() {
		return "Temperaturas: " + listaTemp;
	}
	
	// Método para soma de temperaturas
	private Double somaTemp() {
		Iterator<Double> iterator = this.listaTemp.iterator();
		Double soma = 0d;
		while (iterator.hasNext()){
			Double next = iterator.next();
			soma += next;
		}
		return soma;
	}
	
	// Método para cálculo da média de temperaturas
	public Double mediaTemp() {
		return (somaTemp()/listaTemp.size());
	}
	
	// Método para filtrar os meses acima da média de temperatura
	public List<String> mesesAcima(List<String> meses) {
		List<String> auxList = new ArrayList<String>();
		// Sobrar apenas índice dos meses acima da média
		Double media = mediaTemp();
		for (int i = 0; i <= listaTemp.size()-1; i++) {
			if (listaTemp.get(i) > media) {
				auxList.add(meses.get(i));
			}
		}
		return auxList;
	}
}

class Meses{
	private List<String> nomes = new ArrayList<>() {{
		add("Janeiro");
		add("Fevereiro");
		add("Março");
		add("Abril");
		add("Maio");
		add("Junho");
		add("Julho");
		add("Agosto");
		add("Setembro");
		add("Outubro");
		add("Novembro");
		add("Dezembro");				
	}};

	public List<String> getNomes() {
		return nomes;
	}	
	
}