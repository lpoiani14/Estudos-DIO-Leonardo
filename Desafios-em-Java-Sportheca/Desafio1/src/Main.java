import java.io.IOException;
import java.util.Scanner;

/*	A primeira linha da entrada contém dois números inteiros V (0 <= V <= 100) 
 	e T (0 <= T <= 1000), que indicam, respectivamente, 
  	o volume inicial e o número de trocas de volume.

	A segunda linha contém T números inteiros Ai (-100 <= Ai <= 100) 
	que mostram as modificações de volume realizadas, na ordem em que estas
 	modificações foram feitas. O primeiro número indica a primeira modificação 
 	de volume, o segundo número indica a segunda modificação, e assim por diante.
  	Para cada modificação, um número maior do que zero significa quantas vezes
   	Bruno pressionou o botão de aumentar o som; um número menor do que zero 
   	significa quantas vezes ele pressionou o botão de diminuir o som. Ou seja,
    se o número é igual a 5, significa que nessa modificação ele pressionou 
    cinco vezes o botão de aumentar o som; se o número é igual a -3, significa
    que nessa modificação ele pressionou o botão de diminuir o som três vezes.
*/
public class Main  {
 
    public static void main(String[] args) throws IOException {
        @SuppressWarnings("resource")
		Scanner leitor = new Scanner(System.in);
        int V = leitor.nextInt();
        int T = leitor.nextInt();
        for (int i = 0; i < T; i++) {
        	int vol = leitor.nextInt();
            if((V + vol) > 100) {
            	V = 100;
            } 
            else if((V + vol) < 0) {
            	V = 0;
            }
            else V += vol;
        }
        System.out.println(V);
    }
 
}