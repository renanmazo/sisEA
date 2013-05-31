package sisea.service.combos;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

public class CombosService {
	
	public List<SelectItem> carregarComboPrioridades(){
		List<SelectItem> listaRetorno = new ArrayList<SelectItem>();
		
		listaRetorno.add(new SelectItem("0", "Selecione"));
		listaRetorno.add(new SelectItem("1", "Alt�ssima"));
		listaRetorno.add(new SelectItem("2", "Alta"));
		listaRetorno.add(new SelectItem("3", "M�dia"));
		listaRetorno.add(new SelectItem("4", "Baixa"));
		listaRetorno.add(new SelectItem("5", "Baix�ssima"));
		return listaRetorno;
	}
	
}
