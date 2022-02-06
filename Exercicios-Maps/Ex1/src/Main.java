import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*Dada a popula��o estimada de alguns estados do NE brasileiro, fa�a:
Estado = PE - Popula��o = 9.616.621
Estado = AL - Popula��o = 3.351.543
Estado = CE - Popula��o = 9.187.103
Estado = RN - Popula��o = 3.534.265

Crie um dicion�rio e relacione os estados e suas popula��es;
Substitua a popula��o do estado do RN por 3.534.165;
Confira se o estado PB est� no dicion�rio, caso n�o adicione: PB -
4.039.277;
Exiba a popula��o PE;
Exiba todos os estados e suas popula��es na ordem que foi
informado;
Exiba os estados e suas popula��es em ordem alfab�tica;
Exiba o estado com o menor popula��o e sua quantidade;
Exiba o estado com a maior popula��o e sua quantidade;
Exiba a soma da popula��o desses estados;
Exiba a m�dia da popula��o deste dicion�rio de estados;
Remova os estados com a popula��o menor que 4.000.000;
Apague o dicion�rio de estados;
Confira se o dicion�rio est� vazio.
*/
public class Main {

	public static void main(String[] args) {
		System.out.println("Crie um dicion�rio e relacione os estados e suas popula��es;");
		Map<String, Integer> estados = new LinkedHashMap<>() {
			{
				put("PE", 9616621);
				put("AL", 3351543);
				put("CE", 9187103);
				put("RN", 3534265);
			}
		};
		System.out.println(estados);

		System.out.println("Substitua a popula��o do estado do RN por 3.534.165;");
		estados.put("RN", 3534165);
		System.out.println(estados.get("RN"));

		System.out.println("Confira se o estado PB est� no dicion�rio, caso n�o adicione: PB - 4.039.277;");
		if (estados.containsKey("PB") == false)
			estados.put("PB", 4039277);
		System.out.println(estados.get("PB"));

		System.out.println("Exiba a popula��o PE;");
		System.out.println(estados.get("PE"));

		System.out.println("Exiba todos os estados e suas popula��es na ordem que foi informado;");
		System.out.println(estados);

		System.out.println("Exiba os estados e suas popula��es em ordem alfab�tica;");
		Map<String, Integer> estados2 = new TreeMap<>(estados);
		System.out.println(estados2);

		System.out.println("Exiba o estado com o menor popula��o e sua quantidade;");
		int min = Collections.min(estados2.values());
		for (Map.Entry<String, Integer> estado : estados2.entrySet()) {
			if (estado.getValue() == min)
				System.out.println(estado);
		}

		System.out.println("Exiba o estado com a maior popula��o e sua quantidade;");
		int max = Collections.max(estados2.values());
		for (Map.Entry<String, Integer> estado : estados2.entrySet()) {
			if (estado.getValue() == max)
				System.out.println(estado);
		}

		System.out.println("Exiba a soma da popula��o desses estados;");
		Iterator<Integer> iterator = estados2.values().iterator();
		int soma = 0;
		while (iterator.hasNext()) {
			soma += iterator.next();
		}
		System.out.println(soma);

		System.out.println("Exiba a m�dia da popula��o deste dicion�rio de estados;");
		System.out.println(soma / estados2.size());

		System.out.println("Remova os estados com a popula��o menor que 4.000.000;");
		Iterator<Integer> iterator1 = estados2.values().iterator();
		while (iterator1.hasNext()) {
			if (iterator1.next() < 4000000)
				iterator1.remove();
		}
		System.out.println(estados2);

		System.out.println("Apague o dicion�rio de estados;");
		estados2.clear();
		System.out.println(estados2);

		System.out.println("Confira se o dicion�rio est� vazio.");
		System.out.println(estados2.isEmpty());

	}
}
