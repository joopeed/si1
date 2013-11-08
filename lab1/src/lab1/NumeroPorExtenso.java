package lab1;

public class NumeroPorExtenso {

	private static String[][] extensos = {{"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove", "vinte"}, 
		{"", "dez", "vinte", "trinta", "quarenta", "cinquenta", "sessenta","setenta", "oitenta", "noventa" },
		{"", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"},
		{"mil"}, 
		{"mil"},
		{"mil"}, 
		{"milhão", "milhões"}};
	
	
	public static String converte(int i) {
		if(i == 0) return "zero";
		else {
			int casas = 8;
			while(i/(int) Math.pow(10, casas) == 0)
				casas--;
			System.out.println(casas + " "+ i);
			return converteRecursivo(i, casas);
		}
	}


	private static String converteRecursivo(int i, int casasTotais) {
		String result = "";
		if (i==0) return "";
		if (i==100) return "cem";
		if (i==100000) return "cem mil";
		if (i==100000000) return "um milhão";
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
			result = extensos[0][i/(int) Math.pow(10, casasTotais)] + " "+extensos[casasTotais][0] ;
			String adicao = converteRecursivo(i%(int) Math.pow(10, casasTotais), casasTotais-1);
			if(!adicao.equals("") && i%(int) Math.pow(10, casasTotais) > 100) result+=" " +adicao;
			else if(!adicao.equals("")) result+=" e " +adicao;
			return result;
		}
		
		/*if (i >= 1000 && i < 10000) {
			result =  extensos[0][i/1000] + " mil"; 
			if (i%1000/100!=0)
				result+= " "+extensos[2][i%1000/100] ;
			if (i%100/10!=0)
				result+= " e "+ extensos[1][i%100/10-2] ;
			if(!extensos[0][i%10].equals("zero"))
				result+= " e " + extensos[0][i%10];
		}
		else if (i > 100 && i < 1000) {
			 result =  extensos[2][i/100]; 
			if (i%100/10!=0)
			result+= " e "+ extensos[1][i%100/10-2] ;
			if(!extensos[0][i%10].equals("zero"))
				result+= " e " + extensos[0][i%10];
			}
		else if (i > 20 && i < 100)
			result =  extensos[1][i/10-2] + " e " + extensos[0][i%10];
		else result =  extensos[0][i];*/
	}

}
