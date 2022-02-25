import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.text.DecimalFormat;
import java.io.IOException;
import java.util.StringTokenizer;


public class MinhaPrimeiraClasse {
	  public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    //DecimalFormat df = new DecimalFormat("0.00");
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int valor1 = Integer.parseInt(st.nextToken());

	    st = new StringTokenizer(br.readLine());
	    int valor2 = Integer.parseInt(st.nextToken());

	    st = new StringTokenizer(br.readLine());
	    double valor3 = Double.parseDouble(st.nextToken());
	    
	    System.out.println("NUMBER = " + valor1);
	    
	    Double output = (valor2*valor3);
	    
	    System.out.printf("SALARY = U$ %.2f", output);    
	    
	  }
}