package sisea.util;

public final class SiteUtil {
	
	public static boolean isEmptyOrNull(Object object) {
		return object == null || object.toString().trim().equals("");
	}
	
	public static boolean isEmptyOrNullOrZero(Object valor) {
		return isEmptyOrNull(valor)
				|| valor.toString().equals(String.valueOf(0));
	}
	
	public static String prioridadeLiteral(String prioridade){
		switch (Integer.parseInt(prioridade)) {
		case 1:
			return "Altíssima";
		case 2:
			return "Alta";
		case 3:
			return "Média";
		case 4:
			return "Baixa";
		case 5:
			return "Baixíssima";
		default:
			return "";
		}
		
	}


}
