import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*Crie um conjunto contendo as cores do arco-íris e:
Exiba todas as cores uma abaixo da outra
A quantidade de cores que o arco-íris tem
Exiba as cores em ordem alfabética
Exiba as cores na ordem inversa da que foi informada
Exiba todas as cores que começam com a letra ”v”
Remova todas as cores que não começam com a letra “v”
Limpe o conjunto
Confira se o conjunto está vazio*/

public class Main {

	public static void main(String[] args) {
		
		Set<String> arcoiris = new LinkedHashSet<String>(Arrays.asList("Vermelho", "Laranja", "Amarelo",
				"Verde", "Azul", "Anil", "Violeta"));
		
		System.out.println("A. Exiba todas as cores uma abaixo da outra: ");
		Iterator<String> iterator = arcoiris.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("B. A quantidade de cores que o arco-íris tem: "+ arcoiris.size());
		
		Set<String> arcoirisAlfabetico = new TreeSet<String>(arcoiris);
		System.out.println("C. Exiba as cores em ordem alfabética: " + arcoirisAlfabetico);
		
		List<String> lista = new ArrayList<>(arcoiris);
		Collections.reverse(lista);
		System.out.println("D. Exiba as cores na ordem inversa da que foi informada: " + lista);
		
		System.out.println("E. Exiba todas as cores que começam com a letra ”v”: ");
		arcoirisAlfabetico.forEach(cor -> {if(cor.startsWith("V")) System.out.print(cor + " ");});
		
		System.out.println("F. Remova todas as cores que não começam com a letra “v”: ");
		arcoirisAlfabetico.forEach(cor -> {if(!cor.startsWith("V")) arcoiris.remove(cor);});
		System.out.println(arcoiris);
		
		System.out.println("G. Limpe o conjunto: " );
		arcoiris.clear();
		System.out.println(arcoiris);
		
		System.out.println("H. Confira se o conjunto está vazio: ");
		System.out.println(arcoiris.isEmpty());
		
		
	}

}
