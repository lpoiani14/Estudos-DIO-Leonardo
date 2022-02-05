import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
Utilizando listas, fa�a um programa que fa�a 5 perguntas para uma
pessoa sobre um crime. As perguntas s�o:
	"Telefonou para a v�tima?"
	"Esteve no local do crime?"
	"Mora perto da v�tima?"
	"Devia para a v�tima?"
	"J� trabalhou com a v�tima?"
Se a pessoa responder positivamente a 2 quest�es ela deve ser
classificada como "Suspeita", entre 3 e 4 como "C�mplice" e 5 como
"Assassina". Caso contr�rio, ela ser� classificado como "Inocente".
*/

public class Main {

	public static void main(String[] args) {
		// Input de perguntas
		Perguntas perguntas = new Perguntas();
		System.out.println(perguntas);
		// Leitura das respostas
		Respostas respostas = new Respostas();
		respostas.setRespostas(perguntas.getPerguntas());
		
		// Classifica��o
		Classificacao classificacao = new Classificacao();
		
		// Output do resultado
		classificacao.calculaClassificacao(respostas.getRespostas());
	}

}

class Perguntas{
	private List<String> perguntas = new ArrayList<String>(){{
		add("Telefonou para a v�tima?");
		add("Esteve no local do crime?");
		add("Mora perto da v�tima?");
		add("Devia para a v�tima?");
		add("J� trabalhou com a v�tima?");
	}};

	public List<String> getPerguntas() {
		return perguntas;
	}

	@Override
	public String toString() {
		return "Perguntas [perguntas=" + perguntas + "]";
	}
		
}

class Respostas{
	private List<String> respostas = new ArrayList<String>();

	public List<String> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<String> perguntas) {
		// Printa as perguntas e recebe as respostas
		Scanner scan = new Scanner(System.in);
		for (String pergunta : perguntas) {
			System.out.println(pergunta);
			do {
				try {
					String aux = scan.next();
					if (aux.equals("y") || aux.equals("n")) {
						this.respostas.add(aux);
						break;
					} else {
						throw new ErroResposta("As respostas v�lidas s�o y / n.");
					}
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
				}
			} while (true);

		}
		this.respostas = respostas;
	}

}

class ErroResposta extends InputMismatchException {
	Exception ErroResposta = new InputMismatchException();
	public ErroResposta(String errorMessage) {
		super(errorMessage);
	}
}

class Classificacao{
	String classificacao;

	public void calculaClassificacao(List<String> respostas) {
		/*
		 * Se a pessoa responder positivamente a 2 quest�es ela deve ser classificada
		 * como "Suspeita", entre 3 e 4 como "C�mplice" e 5 como "Assassina". Caso
		 * contr�rio, ela ser� classificado como "Inocente".
		 */
		int numYes = 0;
		for (String resposta : respostas) {
			if (resposta.equals("y"))
				numYes++;
		}
		if (numYes == 2) {
			this.classificacao = "Suspeita";
		} else if (numYes == 3 || numYes == 4) {
			this.classificacao = "C�mplice";
		} else if (numYes == 5) {
			this.classificacao = "Assassina";
		} else {
			this.classificacao = "Inocente";
		}

		System.out.println("A pessoa �: " + classificacao + "!");

	}

}