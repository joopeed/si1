package lab1;

public class NumeroPorExtenso {

	private static String[][] extensos = {{"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove", "vinte"}, 
		{"vinte", "trinta", "quarenta", "cinquenta", "sessenta","setenta", "oitenta", "noventa" },
		{"cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"}};
	
	
	public static String converte(int i) {
		if (i > 100 && i < 1000) 
			return extensos[2][i/100-1] + " e "+ extensos[1][i%100/10-2] + " e " + extensos[0][i%10];
		else if (i > 20 && i < 100)
			return extensos[1][i/10-2] + " e " + extensos[0][i%10];
		else return extensos[0][i];
	}

}
