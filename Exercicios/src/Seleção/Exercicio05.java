package Sele��o;

import java.util.Scanner;

public class Exercicio05 {

	private static Scanner t;
	
	public static void main(String[] args) {
		t = new Scanner(System.in);
		float valor;
		
		System.out.print("Digite um valor: ");
		valor = t.nextFloat();
		
		if (valor < 0 )
			System.out.println("Negativo !");
		else
			System.out.println("Positivo !");
	}

}
