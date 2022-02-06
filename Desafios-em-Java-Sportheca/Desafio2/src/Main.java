/*Desafio
Os meses de Junho e Julho s�o tradicionalmente conhecidos por 
todo Brasil por suas festas t�picas, e para o grupo de amigos 
da Marlene n�o � diferente, toda segunda quinzena do m�s de 
Julho ela e seus amigos se reunem para tradicional mandiocada! 
Na festiva sempre se re�nem na casa da Marlene, o Chico, o Beto, 
o Bernardo, a Marina e a Iara. E como n�o poderia ser diferente 
o prato principal dessa reuni�o � a mandioca. Cada um deles 
come de uma a dez por��es de mandioca e eles sempre avisam a 
Marlene com anteced�ncia a respeito de quantas por��es ir�o 
comer nesse dia. O tamanho da por��o de cada um � diferente, 
mas sempre s�o os mesmos. As por��es s�o as seguintes (em gramas):
O Chico come 300
O Bento come 1500
O Bernardo come 600
A Marina 1000
A Iara come 150
Marlene por sua vez sempre come 225 gramas de mandioca. Cansada 
de todo ano ter que calcular quanta mandioca preparar ela te 
desafiou para escrever um programa que informe quanta mandioca 
deve ser preparada em gramas.

Entrada
A entrada consiste de 5 inteiros cada um representando 
as por��es que os convidados de dona Chica v�o consumir. 
O primeiro inteiro representa as por��es do Chico, o 
segundo do Bento, o terceiro do Bernardo, o quarto da Marina 
e o quinto a da Iara.

Sa�da
A sa�da consiste de um �nico inteiro que representa 
quanta mandioca Marlene deve preparar em gramas.*/

import java.io.IOException;
import java.util.Scanner;
 
public class Main  {
   
    public static final int[] porcoes = { 300, 1500, 600, 1000, 150 };
 
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
    
        int quantidade = 225;  
        for (Integer porcao : porcoes) {
			int numPorcoes = leitor.nextInt();
			quantidade += numPorcoes*porcao;
		}
        System.out.println(quantidade);

        }
        


}
