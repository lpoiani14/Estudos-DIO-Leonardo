import java.io.IOException;
import java.util.Scanner;

/*	A primeira linha da entrada cont�m dois n�meros inteiros V (0 <= V <= 100) 
 	e T (0 <= T <= 1000), que indicam, respectivamente, 
  	o volume inicial e o n�mero de trocas de volume.

	A segunda linha cont�m T n�meros inteiros Ai (-100 <= Ai <= 100) 
	que mostram as modifica��es de volume realizadas, na ordem em que estas
 	modifica��es foram feitas. O primeiro n�mero indica a primeira modifica��o 
 	de volume, o segundo n�mero indica a segunda modifica��o, e assim por diante.
  	Para cada modifica��o, um n�mero maior do que zero significa quantas vezes
   	Bruno pressionou o bot�o de aumentar o som; um n�mero menor do que zero 
   	significa quantas vezes ele pressionou o bot�o de diminuir o som. Ou seja,
    se o n�mero � igual a 5, significa que nessa modifica��o ele pressionou 
    cinco vezes o bot�o de aumentar o som; se o n�mero � igual a -3, significa
    que nessa modifica��o ele pressionou o bot�o de diminuir o som tr�s vezes.
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