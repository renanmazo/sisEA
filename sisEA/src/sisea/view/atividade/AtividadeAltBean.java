package sisea.view.atividade;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.primefaces.model.DualListModel;

import sisea.model.Atividade;
import sisea.model.Habilidade;
import sisea.service.combos.CombosService;
import sisea.service.habilidade.HabilidadeService;

public class AtividadeAltBean {
	private CombosService combosService = new CombosService();
	private HabilidadeService habilidadeService = new HabilidadeService();

	private Atividade atividade;
	private List<SelectItem> comboPrioridade;
	private List<SelectItem> comboStatus;
	private List<SelectItem> comboProjeto;
	private DualListModel<Habilidade> habilidades;

	public String iniciarPagina(Atividade atividade) {
		inicializar();
		carregarTela(atividade);
		return "IR_PARA_ATIVIDADE_ALT";
	}

	public void inicializar() {
		setAtividade(new Atividade());
		setComboPrioridade(new ArrayList<SelectItem>());
		setComboProjeto(new ArrayList<SelectItem>());
		setComboStatus(new ArrayList<SelectItem>());
		setHabilidades(new DualListModel<Habilidade>());
	}

	public void carregarTela(Atividade atividade) {
		setAtividade(atividade);
		carregaComboPrioridade();
		carregaComboProjeto();
		carregaComboStatus();
		carregaPickListHabilidades();
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

	public void carregaPickListHabilidades() {
		List<Habilidade> habilidadesExistentes = new ArrayList<Habilidade>();
		List<Habilidade> habilidadesAtividade = new ArrayList<Habilidade>();
		List<Habilidade> habilidadesRestantes = new ArrayList<Habilidade>();
		int contador = 0;
		habilidadesAtividade = getAtividade().getHabilidades();
		habilidadesExistentes = getHabilidadeService().listarHabilidades();
		for (Habilidade habilidadeExistente : habilidadesExistentes) {
			for (Habilidade habilidadeAtividade : habilidadesAtividade) {
				if (habilidadeExistente.getIdHabilidade() == habilidadeAtividade
						.getIdHabilidade()) {
					contador++;
				}
			}
			if(contador == 0){
				habilidadesRestantes.add(habilidadeExistente);
			}else{
				contador = 0;
			}
		}
		setHabilidades(new DualListModel<Habilidade>(habilidadesRestantes,
				habilidadesAtividade));
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

	public List<SelectItem> getComboStatus() {
		return comboStatus;
	}

	public void setComboStatus(List<SelectItem> comboStatus) {
		this.comboStatus = comboStatus;
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

	public DualListModel<Habilidade> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(DualListModel<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}

	public HabilidadeService getHabilidadeService() {
		return habilidadeService;
	}

	public void setHabilidadeService(HabilidadeService habilidadeService) {
		this.habilidadeService = habilidadeService;
	}

}
