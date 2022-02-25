import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class minhaClasse {

	public static void main(String[] args) {
           Scanner scr = new Scanner(System.in);
           int valores = scr.nextInt();
           Map<Integer, Integer> numeros = new HashMap<>();

    //declare as variaveis corretamente e continue a sua solução

        for (int i = 0; i < valores; i++) {
            var numero = scr.nextInt();
    
            if(numeros.containsKey(numero)) {
                int count = numeros.get(numero);
            	numeros.put(numero, count+1);
            } else {
            	numeros.put(numero, 1);
            }
        }

        numeros.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(e.getKey() + " aparece " + e.getValue() + " vez(es)"));
    }
}