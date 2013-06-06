package sisea.view.atividade;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import sisea.model.Atividade;
import sisea.service.atividade.AtividadeService;
import sisea.service.combos.CombosService;

public class AtividadePesqBean {
	private AtividadeIncBean atividadeIncBean = new AtividadeIncBean();
	private AtividadeAltBean atividadeAltBean = new AtividadeAltBean();
	
	private CombosService combosService = new CombosService();
	private AtividadeService atividadeService = new AtividadeService();
	
	
	private List<Atividade> atividades;
	private Atividade atividadeSelecionada;
	
	private String nome;
	private List<SelectItem> comboPrioridade;
	private String prioridadeSelecionada;
	
	public String iniciarPagina(){
		inicializar();
		carregarComboPrioridade();
		return "IR_PARA_ATIVIDADE_PESQ";
	}
	
	public void inicializar(){
		setComboPrioridade(new ArrayList<SelectItem>());
		setAtividades(new ArrayList<Atividade>());
		setAtividadeSelecionada(new Atividade());
		setNome("");
		setPrioridadeSelecionada("0");
	}
	
	public void carregarComboPrioridade(){
		setComboPrioridade(getCombosService().carregarComboPrioridades());
	}
	
	public void botaoPesquisar(){
		setAtividades(getAtividadeService().listarAtividades());
	}
	
	public String botaoIncluir(){
		return getAtividadeIncBean().iniciarPagina();
	}
	
	public String botaoAlterar(){
		if(getAtividadeSelecionada() != null){
			return atividadeAltBean.iniciarPagina(getAtividadeSelecionada());
		}else
			return "";
	}
	
	public void botaoExcluir(){
		
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

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public Atividade getAtividadeSelecionada() {
		return atividadeSelecionada;
	}

	public void setAtividadeSelecionada(Atividade atividadeSelecionada) {
		this.atividadeSelecionada = atividadeSelecionada;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public AtividadeService getAtividadeService() {
		return atividadeService;
	}

	public void setAtividadeService(AtividadeService atividadeService) {
		this.atividadeService = atividadeService;
	}

	public AtividadeIncBean getAtividadeIncBean() {
		return atividadeIncBean;
	}

	public void setAtividadeIncBean(AtividadeIncBean atividadeIncBean) {
		this.atividadeIncBean = atividadeIncBean;
	}

	public AtividadeAltBean getAtividadeAltBean() {
		return atividadeAltBean;
	}

	public void setAtividadeAltBean(AtividadeAltBean atividadeAltBean) {
		this.atividadeAltBean = atividadeAltBean;
	}

}
