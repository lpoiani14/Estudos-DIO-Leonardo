import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*Dada a população estimada de alguns estados do NE brasileiro, faça:
Estado = PE - População = 9.616.621
Estado = AL - População = 3.351.543
Estado = CE - População = 9.187.103
Estado = RN - População = 3.534.265

Crie um dicionário e relacione os estados e suas populações;
Substitua a população do estado do RN por 3.534.165;
Confira se o estado PB está no dicionário, caso não adicione: PB -
4.039.277;
Exiba a população PE;
Exiba todos os estados e suas populações na ordem que foi
informado;
Exiba os estados e suas populações em ordem alfabética;
Exiba o estado com o menor população e sua quantidade;
Exiba o estado com a maior população e sua quantidade;
Exiba a soma da população desses estados;
Exiba a média da população deste dicionário de estados;
Remova os estados com a população menor que 4.000.000;
Apague o dicionário de estados;
Confira se o dicionário está vazio.
*/
public class Main {

	public static void main(String[] args) {
		System.out.println("Crie um dicionário e relacione os estados e suas populações;");
		Map<String, Integer> estados = new LinkedHashMap<>() {
			{
				put("PE", 9616621);
				put("AL", 3351543);
				put("CE", 9187103);
				put("RN", 3534265);
			}
		};
		System.out.println(estados);

		System.out.println("Substitua a população do estado do RN por 3.534.165;");
		estados.put("RN", 3534165);
		System.out.println(estados.get("RN"));

		System.out.println("Confira se o estado PB está no dicionário, caso não adicione: PB - 4.039.277;");
		if (estados.containsKey("PB") == false)
			estados.put("PB", 4039277);
		System.out.println(estados.get("PB"));

		System.out.println("Exiba a população PE;");
		System.out.println(estados.get("PE"));

		System.out.println("Exiba todos os estados e suas populações na ordem que foi informado;");
		System.out.println(estados);

		System.out.println("Exiba os estados e suas populações em ordem alfabética;");
		Map<String, Integer> estados2 = new TreeMap<>(estados);
		System.out.println(estados2);

		System.out.println("Exiba o estado com o menor população e sua quantidade;");
		int min = Collections.min(estados2.values());
		for (Map.Entry<String, Integer> estado : estados2.entrySet()) {
			if (estado.getValue() == min)
				System.out.println(estado);
		}

		System.out.println("Exiba o estado com a maior população e sua quantidade;");
		int max = Collections.max(estados2.values());
		for (Map.Entry<String, Integer> estado : estados2.entrySet()) {
			if (estado.getValue() == max)
				System.out.println(estado);
		}

		System.out.println("Exiba a soma da população desses estados;");
		Iterator<Integer> iterator = estados2.values().iterator();
		int soma = 0;
		while (iterator.hasNext()) {
			soma += iterator.next();
		}
		System.out.println(soma);

		System.out.println("Exiba a média da população deste dicionário de estados;");
		System.out.println(soma / estados2.size());

		System.out.println("Remova os estados com a população menor que 4.000.000;");
		Iterator<Integer> iterator1 = estados2.values().iterator();
		while (iterator1.hasNext()) {
			if (iterator1.next() < 4000000)
				iterator1.remove();
		}
		System.out.println(estados2);

		System.out.println("Apague o dicionário de estados;");
		estados2.clear();
		System.out.println(estados2);

		System.out.println("Confira se o dicionário está vazio.");
		System.out.println(estados2.isEmpty());

	}
}
