import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
Utilizando listas, faça um programa que faça 5 perguntas para uma
pessoa sobre um crime. As perguntas são:
	"Telefonou para a vítima?"
	"Esteve no local do crime?"
	"Mora perto da vítima?"
	"Devia para a vítima?"
	"Já trabalhou com a vítima?"
Se a pessoa responder positivamente a 2 questões ela deve ser
classificada como "Suspeita", entre 3 e 4 como "Cúmplice" e 5 como
"Assassina". Caso contrário, ela será classificado como "Inocente".
*/

public class Main {

	public static void main(String[] args) {
		// Input de perguntas
		Perguntas perguntas = new Perguntas();
		System.out.println(perguntas);
		// Leitura das respostas
		Respostas respostas = new Respostas();
		respostas.setRespostas(perguntas.getPerguntas());
		
		// Classificação
		Classificacao classificacao = new Classificacao();
		
		// Output do resultado
		classificacao.calculaClassificacao(respostas.getRespostas());
	}

}

class Perguntas{
	private List<String> perguntas = new ArrayList<String>(){{
		add("Telefonou para a vítima?");
		add("Esteve no local do crime?");
		add("Mora perto da vítima?");
		add("Devia para a vítima?");
		add("Já trabalhou com a vítima?");
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
						throw new ErroResposta("As respostas válidas são y / n.");
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
		 * Se a pessoa responder positivamente a 2 questões ela deve ser classificada
		 * como "Suspeita", entre 3 e 4 como "Cúmplice" e 5 como "Assassina". Caso
		 * contrário, ela será classificado como "Inocente".
		 */
		int numYes = 0;
		for (String resposta : respostas) {
			if (resposta.equals("y"))
				numYes++;
		}
		if (numYes == 2) {
			this.classificacao = "Suspeita";
		} else if (numYes == 3 || numYes == 4) {
			this.classificacao = "Cúmplice";
		} else if (numYes == 5) {
			this.classificacao = "Assassina";
		} else {
			this.classificacao = "Inocente";
		}

		System.out.println("A pessoa é: " + classificacao + "!");

	}

}