import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/* Fa�a um programa que receba a temperatura m�dia dos 6
primeiros meses do ano e armazene-as em uma lista.

Ap�s isto, calcule a m�dia semestral das temperaturas e
mostre todas as temperaturas acima desta m�dia, e em que
m�s elas ocorreram (mostrar o m�s por extenso: 1 � Janeiro, 2
� Fevereiro e etc).
 */
public class Main {

	public static void main(String[] args) {
		// Cria a lista de meses
		Meses listaMeses = new Meses();
		System.out.println("Meses: " + listaMeses.getNomes());
		
		// Recebe input de temperaturas no n�mero de meses selecionados
		int numMeses = 6;
		Temperaturas temperaturas = new Temperaturas();
		temperaturas.setListaTemp(listaMeses.getNomes(),numMeses);
		System.out.println(temperaturas);
		
		// Calcula a m�dia de temperaturas nos meses
		System.out.println("A m�dia de temperaturas �: "+ temperaturas.mediaTemp());
		
		// Verifica quais meses ficaram acima da m�dia
		List<String> mesesAcima = temperaturas.mesesAcima(listaMeses.getNomes());
		System.out.println("Os meses acima da m�dia s�o: "+ mesesAcima);
		
		
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

	// M�todo para entrada das temperaturas
	public void setListaTemp(List<String> meses, int mesesContagem) {
		Scanner scan = new Scanner(System.in);
			for (int i = 0; i < mesesContagem; i++) {
				System.out.println("Entre com a temperatura de " + meses.get(i) + ": ");
				// Verifica��o se o input � v�lido e cria��o da lista
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
	
	// M�todo para soma de temperaturas
	private Double somaTemp() {
		Iterator<Double> iterator = this.listaTemp.iterator();
		Double soma = 0d;
		while (iterator.hasNext()){
			Double next = iterator.next();
			soma += next;
		}
		return soma;
	}
	
	// M�todo para c�lculo da m�dia de temperaturas
	public Double mediaTemp() {
		return (somaTemp()/listaTemp.size());
	}
	
	// M�todo para filtrar os meses acima da m�dia de temperatura
	public List<String> mesesAcima(List<String> meses) {
		List<String> auxList = new ArrayList<String>();
		// Sobrar apenas �ndice dos meses acima da m�dia
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
		add("Mar�o");
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