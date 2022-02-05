import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/*Crie uma classe LinguagemFavorita que possua os atributos
nome, anoDeCriacao e ide. Em seguida, crie um conjunto com
3 linguagens e faça um programa que ordene esse conjunto
por:
Ordem de Inserção
Ordem Natural (nome)
IDE
Ano de criação e nome
Nome, ano de criacao e IDE
Ao final, exiba as linguagens no console, um abaixo da outra.*/

public class Main {

	public static void main(String[] args) {
		
		Set<LinguagemFavorita> linguagens = new LinkedHashSet<>() {{
			add(new LinguagemFavorita("Python", 1990, "Spyder"));
			add(new LinguagemFavorita("VBA", 1993, "Visual Basic Editor"));
			add(new LinguagemFavorita("Java", 1991, "Eclipse"));
		}};
		
		System.out.println("Ordem de Inserção: " + linguagens);
		
		Set<LinguagemFavorita> treeLinguagens = new TreeSet<LinguagemFavorita>(linguagens);
		System.out.println("Ordem Natural (nome): " + treeLinguagens);
		
		Set<LinguagemFavorita> treeLinguagensIDE = new TreeSet<LinguagemFavorita>(new ComparaIDE());
		treeLinguagensIDE.addAll(treeLinguagens);
		System.out.println("IDE: " + treeLinguagensIDE);
		
		Set<LinguagemFavorita> treeLinguagensAnoNome = new TreeSet<LinguagemFavorita>(new ComparaAnoNome());
		treeLinguagensAnoNome.addAll(treeLinguagens);
		System.out.println("Ano de criação e nome: " + treeLinguagensAnoNome);
		
		Set<LinguagemFavorita> treeLinguagensNomeAnoIDE = new TreeSet<LinguagemFavorita>(new ComparaNomeAnoIDE());
		treeLinguagensNomeAnoIDE.addAll(treeLinguagens);
		System.out.println("Nome, ano de criacao e IDE: " + treeLinguagensNomeAnoIDE);
	}

}

class LinguagemFavorita implements Comparable<LinguagemFavorita>{
	String nome;
	int anoDeCriacao;
	String IDE;
	
	public LinguagemFavorita(String nome, int anoDeCriacao, String iDE) {
		super();
		this.nome = nome;
		this.anoDeCriacao = anoDeCriacao;
		this.IDE = iDE;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnoDeCriacao() {
		return anoDeCriacao;
	}
	public void setAnoDeCriacao(int anoDeCriacao) {
		this.anoDeCriacao = anoDeCriacao;
	}
	public String getIDE() {
		return IDE;
	}
	public void setIDE(String iDE) {
		IDE = iDE;
	}
	@Override
	public int hashCode() {
		return Objects.hash(IDE, anoDeCriacao, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinguagemFavorita other = (LinguagemFavorita) obj;
		return Objects.equals(IDE, other.IDE) && anoDeCriacao == other.anoDeCriacao && Objects.equals(nome, other.nome);
	}
	@Override
	public String toString() {
		return nome + " - " + anoDeCriacao + " - " + IDE;
	}
	@Override
	public int compareTo(LinguagemFavorita linguagem) {
		int nome = this.getNome().compareTo(linguagem.getNome());
		return nome;
	}
	
}

// Comparators
class ComparaIDE implements Comparator<LinguagemFavorita>{

	@Override
	public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
		int iDE = o1.getIDE().compareTo(o2.getIDE());
		return iDE;
	}
	
}

class ComparaAnoNome implements Comparator<LinguagemFavorita>{

	@Override
	public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
		int ano = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
		if(ano != 0) return ano;
		
		int nome = o1.getNome().compareTo(o2.getNome());
		return nome;
	}
	
}

class ComparaNomeAnoIDE implements Comparator<LinguagemFavorita>{
	@Override
	public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
		int nome = o1.getNome().compareTo(o2.getNome());
		if(nome != 0) return nome;
		
		int ano = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
		if(ano != 0) return ano;
		
		return o1.getIDE().compareTo(o2.getIDE());
	}
}
