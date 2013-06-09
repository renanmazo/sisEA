package sisea.view.projeto;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.primefaces.model.DualListModel;

import sisea.model.Atividade;
import sisea.model.Habilidade;
import sisea.service.combos.CombosService;
import sisea.service.funcionario.FuncionarioService;
import sisea.service.habilidade.HabilidadeService;
import sisea.service.projeto.ProjetoService;

public class ProjetoIncBean {
	private CombosService combosService = new CombosService();
	private ProjetoService projetoService = new ProjetoService();

	private Atividade atividade;
	private List<SelectItem> comboPrioridade;
	private List<SelectItem> comboProjeto;
	private List<SelectItem> comboStatus;
	private DualListModel<Habilidade> habilidades;

	public String iniciarPagina() {
		inicializar();
		carregaComboStatus();
		return "atividadeInc.xhtml?faces-redirect=true";
	}

	public void inicializar() {
		setAtividade(new Atividade());
		setComboStatus(new ArrayList<SelectItem>());
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

	public DualListModel<Habilidade> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(DualListModel<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}

}
