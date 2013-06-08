package sisea.util;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

public final class SiteUtil {

	public static boolean isEmptyOrNull(Object object) {
		return object == null || object.toString().trim().equals("");
	}

	public static boolean isEmptyOrNullOrZero(Object valor) {
		return isEmptyOrNull(valor)
				|| valor.toString().equals(String.valueOf(0));
	}

	public static String prioridadeLiteral(String prioridade) {
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
	
	public static String statusLiteral(String status){
		if(status.equals("NOVA")){
			return "Nova";
		}else if(status.equals("PAUSADA")){
			return "Pausada";
		}else if(status.equals("EM ANDAMENTO")){
			return "Em andamento";
		}else if(status.equals("FINALIZADA")){
			return "Finalizada";   
		}else if(status.equals("CANCELADA")){
			return "Cancelada";
		}else
			return "";
	}

	public static Object getBeanFromSession(String nomeDoBean) {
		Object bean = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		ELContext elContext = ctx.getELContext();
		ELResolver resolver = elContext.getELResolver();
		bean = resolver.getValue(elContext, null, nomeDoBean);
		return bean;
	}

}
