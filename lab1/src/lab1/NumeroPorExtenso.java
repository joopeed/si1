package lab1;

public class NumeroPorExtenso {

	private static String[][] extensos = {{"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove", "vinte"}, 
		{"", "dez", "vinte", "trinta", "quarenta", "cinquenta", "sessenta","setenta", "oitenta", "noventa" },
		{"", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"},
		{"mil"}, 
		{"mil"},
		{"mil"}, 
		{"milhão", "milhões"}};
	
	
	public static String converte(int i) throws Exception {
		if(i < 0) throw new Exception("Negativos nao suportados");
		if(i > 1000000000) throw new Exception("Numero muito grande");
		if(i == 0) return "zero";
		else {
			int casas = calculaCasas(i);
			return converteRecursivo(i, casas);
		}
	}


	private static int calculaCasas(int i) {
		int casas = 8;
		while(i/(int) Math.pow(10, casas) == 0)
			casas--;
		return casas;
	}


	private static String converteRecursivo(int i, int casasTotais) {
		String result = "";
		if (i==0) return "";
		if (i==100) return "cem";
		if (i==1000000000) return "um bilhão";
		if (i < 20 && i>0) return extensos[0][i];
		if (i/(int) Math.pow(10, casasTotais) == 0){
			if(i%(int) Math.pow(10, casasTotais) == 0) return "";
			else return converteRecursivo(i%(int) Math.pow(10, casasTotais), casasTotais-1);
		} else if (i < 1000){
			result = extensos[casasTotais][i/(int) Math.pow(10, casasTotais)];
			String adicao = converteRecursivo(i%(int) Math.pow(10, casasTotais), casasTotais-1);
			if(!adicao.equals("")) result+=" e " +adicao;
			return result;
		} else {
			if(casasTotais>=6){
				if(i/(int) Math.pow(10, 6) > 1)
				result = converteRecursivo(i/(int) Math.pow(10, 6), casasTotais-6) +" milhões";
				else 
				result = converteRecursivo(i/(int) Math.pow(10, 6), casasTotais-6) +" milhão";
				String adicao = converteRecursivo(i%(int) Math.pow(10, 6), 6);
				if(!adicao.equals("") && i%(int) Math.pow(10, casasTotais) > 100) result+=" " +adicao;
				else if(!adicao.equals("")) result+=" e " +adicao;
				return result;
				
			} else{
				result = converteRecursivo(i/(int) Math.pow(10, 3), casasTotais-3) +" mil";
				String adicao = converteRecursivo(i%(int) Math.pow(10, 3), 3);
				if(!adicao.equals("") && i%(int) Math.pow(10, casasTotais) > 100) result+=" " +adicao;
				else if(!adicao.equals("")) result+=" e " +adicao;
				return result;
			}
				
		}
		
		
	}

}
