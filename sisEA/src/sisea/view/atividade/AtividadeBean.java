package sisea.view.atividade;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import sisea.service.combos.CombosService;

public class AtividadeBean {
	private CombosService combosService = new CombosService();
	
	private List<SelectItem> comboPrioridade;
	private String prioridadeSelecionada;
	
	public String iniciarPagina(){
		carregarComboPrioridade();
		return "IR_PARA_ATIVIDADE";
	}
	
	public void inicializar(){
		setComboPrioridade(new ArrayList<SelectItem>());
		setPrioridadeSelecionada("0");
	}
	
	public void carregarComboPrioridade(){
		setComboPrioridade(getCombosService().carregarComboPrioridades());
	}

	public List<SelectItem> getComboPrioridade() {
		return comboPrioridade;
	}

	public void setComboPrioridade(List<SelectItem> comboPrioridade) {
		this.comboPrioridade = comboPrioridade;
	}

	public CombosService getCombosService() {
		return combosService;
	}

	public void setCombosService(CombosService combosService) {
		this.combosService = combosService;
	}

	public String getPrioridadeSelecionada() {
		return prioridadeSelecionada;
	}

	public void setPrioridadeSelecionada(String prioridadeSelecionada) {
		this.prioridadeSelecionada = prioridadeSelecionada;
	}

}
