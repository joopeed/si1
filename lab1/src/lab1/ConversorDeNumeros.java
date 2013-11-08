package lab1;

import java.util.Scanner;

public class ConversorDeNumeros {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = "";
        while (true) {
        		String resultado = "";
                System.out.printf("Digite um numero: ");
                entrada = sc.nextLine();
                try {
                        resultado = NumeroPorExtenso.converte(Integer.valueOf(entrada));
                        System.out.println(resultado);
                        break;
                } catch (Exception e) {
                        if(e.getMessage().equals("Negativos nao suportados")) System.out.println("Digite um numero positivo");
                        else if(e.getMessage().equals("Numero muito grande")) System.out.println("Digite um numero menor que 1 bilhão");
                        else if(e instanceof NumberFormatException) System.out.println("Numero invalido. Digite novamente"); 
                } 
        }
        
        sc.close();
}
	
	
}
