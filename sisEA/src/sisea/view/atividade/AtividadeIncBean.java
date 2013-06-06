package sisea.view.atividade;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import sisea.model.Atividade;
import sisea.service.combos.CombosService;

public class AtividadeIncBean {
	private CombosService combosService = new CombosService();
	
	private Atividade atividade;
	private List<SelectItem> comboPrioridade;
	private List<SelectItem> comboProjeto;
	
	public String iniciarPagina(){
		inicializar();
		carregaComboPrioridade();
		carregaComboProjeto();
		return "atividadeInc.xhtml?faces-redirect=true";
	}
	
	public void inicializar(){
		setAtividade(new Atividade());
		setComboPrioridade(new ArrayList<SelectItem>());
		setComboProjeto(new ArrayList<SelectItem>());
	}
	
	public void carregaComboPrioridade(){
		setComboPrioridade(getCombosService().carregarComboPrioridades());
		getComboPrioridade();
	}
	
	public void carregaComboProjeto(){
		setComboProjeto(getCombosService().carregaComboProjeto());
		getComboProjeto();
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public List<SelectItem> getComboPrioridade() {
		return comboPrioridade;
	}

	public void setComboPrioridade(List<SelectItem> comboPrioridade) {
		this.comboPrioridade = comboPrioridade;
	}

	public List<SelectItem> getComboProjeto() {
		return comboProjeto;
	}

	public void setComboProjeto(List<SelectItem> comboProjeto) {
		this.comboProjeto = comboProjeto;
	}

	public CombosService getCombosService() {
		return combosService;
	}

	public void setCombosService(CombosService combosService) {
		this.combosService = combosService;
	}

}
