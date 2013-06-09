package sisea.view.habilidade;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.primefaces.model.DualListModel;

import sisea.model.Atividade;
import sisea.model.Habilidade;
import sisea.service.combos.CombosService;
import sisea.service.funcionario.FuncionarioService;
import sisea.service.habilidade.HabilidadeService;

public class HabilidadeIncBean {
	private CombosService combosService = new CombosService();
	private HabilidadeService habilidadeService = new HabilidadeService();

	private Atividade atividade;
	private List<SelectItem> comboPrioridade;
	private List<SelectItem> comboProjeto;
	private List<SelectItem> comboStatus;
	private DualListModel<Habilidade> habilidades;

	public String iniciarPagina() {
		inicializar();
		carregaComboPrioridade();
		carregaComboProjeto();
		carregaComboStatus();
		carregaPickListHabilidades();
		return "atividadeInc.xhtml?faces-redirect=true";
	}

	public void inicializar() {
		setAtividade(new Atividade());
		setComboPrioridade(new ArrayList<SelectItem>());
		setComboProjeto(new ArrayList<SelectItem>());
		setComboStatus(new ArrayList<SelectItem>());
	}
	
	public void carregaPickListHabilidades(){
		List<Habilidade> habilidadesExistentes = new ArrayList<Habilidade>();
		List<Habilidade> habilidadesAtividade = new ArrayList<Habilidade>();
		habilidadesExistentes = getHabilidadeService().listarHabilidades();

		setHabilidades(new DualListModel<Habilidade>(habilidadesExistentes, habilidadesAtividade));
	}

	public void carregaComboPrioridade() {
		setComboPrioridade(getCombosService().carregarComboPrioridades());
	}

	public void carregaComboProjeto() {
		setComboProjeto(getCombosService().carregaComboProjeto());
	}

	public void carregaComboStatus() {
		setComboStatus(getCombosService().carregaComboStatus());
	}

	public CombosService getCombosService() {
		return combosService;
	}

	public void setCombosService(CombosService combosService) {
		this.combosService = combosService;
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
		return this.comboProjeto;
	}

	public void setComboProjeto(List<SelectItem> comboProjeto) {
		this.comboProjeto = comboProjeto;
	}
	
	public void setComboStatus(List<SelectItem> comboStatus) {
		this.comboStatus = comboStatus;
	}

	public List<SelectItem> getComboStatus() {
		return this.comboStatus;
	}	

	public HabilidadeService getHabilidadeService() {
		return habilidadeService;
	}

	public void setHabilidadeService(HabilidadeService habilidadeService) {
		this.habilidadeService = habilidadeService;
	}

	public DualListModel<Habilidade> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(DualListModel<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}

}
