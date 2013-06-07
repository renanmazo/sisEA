package sisea.view.atividade;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.primefaces.model.DualListModel;

import sisea.model.Atividade;
import sisea.service.combos.CombosService;

public class AtividadeIncBean {
	private CombosService combosService = new CombosService();

	private Atividade atividade;
	private List<SelectItem> comboPrioridade;
	private List<SelectItem> comboProjeto;
	private List<SelectItem> comboStatus;
	private DualListModel<String> cities;

	public DualListModel<String> getCities() {
		return cities;
	}

	public void setCities(DualListModel<String> cities) {
		this.cities = cities;
	}

	public AtividadeIncBean() {
		List<String> citiesSource = new ArrayList<String>();
		List<String> citiesTarget = new ArrayList<String>();
		citiesSource.add("Istanbul");
		citiesSource.add("Ankara");
		citiesSource.add("Izmir");
		citiesSource.add("Antalya");
		citiesSource.add("Bursa");

		cities = new DualListModel<String>(citiesSource, citiesTarget);
	}

	public String iniciarPagina() {
		inicializar();
		carregaComboPrioridade();
		carregaComboProjeto();
		carregaComboStatus();
		return "atividadeInc.xhtml?faces-redirect=true";
	}

	public void inicializar() {
		setAtividade(new Atividade());
		setComboPrioridade(new ArrayList<SelectItem>());
		setComboProjeto(new ArrayList<SelectItem>());
	}

	// COMBO DE ATIVIDADES
	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	// COMBO dE PRIORIDADES
	public List<SelectItem> getComboPrioridade() {
		return comboPrioridade;
	}

	public void setComboPrioridade(List<SelectItem> comboPrioridade) {
		this.comboPrioridade = comboPrioridade;
	}

	public void carregaComboPrioridade() {
		setComboPrioridade(getCombosService().carregarComboPrioridades());
	}

	// COMBO DE PROJETOS
	public List<SelectItem> getComboProjeto() {
		return this.comboProjeto;
	}

	public void setComboProjeto(List<SelectItem> comboProjeto) {
		this.comboProjeto = comboProjeto;
	}

	public void carregaComboProjeto() {
		setComboProjeto(getCombosService().carregaComboProjeto());
	}

	// COMBO DE STATUS
	public void setComboStatus(List<SelectItem> comboStatus) {
		this.comboStatus = comboStatus;
	}

	public List<SelectItem> getComboStatus() {
		return this.comboStatus;
	}

	public void carregaComboStatus() {
		setComboStatus(getCombosService().carregaComboStatus());
	}

	// SERVICE
	public CombosService getCombosService() {
		return combosService;
	}

	public void setCombosService(CombosService combosService) {
		this.combosService = combosService;
	}

}
