package sisea.view.atividade;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.primefaces.model.DualListModel;

import sisea.model.Atividade;
import sisea.model.Habilidade;
import sisea.service.atividade.AtividadeService;
import sisea.service.combos.CombosService;
import sisea.service.habilidade.HabilidadeService;

public class AtividadeIncBean {
	private CombosService combosService = new CombosService();
	private HabilidadeService habilidadeService = new HabilidadeService();
	private AtividadeService atividadeService = new AtividadeService();

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
		getAtividade().setIdStatus("NOVA");
	}
	
	public void carregaPickListHabilidades(){
		List<Habilidade> habilidadesExistentes = new ArrayList<Habilidade>();
		habilidadesExistentes = getHabilidadeService().listarHabilidades();
		
		setHabilidades(new DualListModel<Habilidade>(habilidadesExistentes, getAtividade().getHabilidades()));
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
	
	public void botaoConfirmar(ActionEvent e){
		String idAtividade = getAtividadeService().listarAtividadesPorNome(getAtividade().getNome());
		if(idAtividade != null || idAtividade != ""){
			getAtividadeService().incluirAtividade(getAtividade());
			getAtividade().setIdAtividade(Integer.parseInt(getAtividadeService().listarAtividadesPorNome(getAtividade().getNome())));
			for(Habilidade habilidade : getAtividade().getHabilidades()){
				getAtividadeService().incluirHabilidadeAtividade(String.valueOf(getAtividade().getIdAtividade()), String.valueOf(habilidade.getIdHabilidade()));
			}
		}
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

	public AtividadeService getAtividadeService() {
		return atividadeService;
	}

	public void setAtividadeService(AtividadeService atividadeService) {
		this.atividadeService = atividadeService;
	}

}
