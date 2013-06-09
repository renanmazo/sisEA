package sisea.view.projeto;

import java.util.ArrayList;
import java.util.List;

import sisea.model.Projeto;
import sisea.service.projeto.ProjetoService;
import sisea.service.combos.CombosService;
import sisea.util.SiteUtil;

public class ProjetoPesqBean {
	private ProjetoIncBean projetoIncBean = (ProjetoIncBean) SiteUtil.getBeanFromSession("projetoIncBean");
	private ProjetoAltBean projetoAltBean = (ProjetoAltBean) SiteUtil.getBeanFromSession("projetoAltBean");
	
	private CombosService combosService = new CombosService();
	private ProjetoService projetoService = new ProjetoService();
	
	
	private List<Projeto> projetos;
	private Projeto projetoSelecionado;
	
	private String nome;
	
	public String iniciarPagina(){
		inicializar();
		return "IR_PARA_PROJETO_PESQ";
	}
	
	public void inicializar(){
		setProjetos(new ArrayList<Projeto>());
		setProjetoSelecionado(new Projeto());
		setNome("");
	}

	public void botaoPesquisar(){
		setProjetos(getProjetoService().listarProjetos());
	}
	
	public String botaoIncluir(){
		return getProjetoIncBean().iniciarPagina();
	}
	
	public String botaoAlterar(){
		if(getProjetoSelecionado() != null){
			return projetoAltBean.iniciarPagina(getProjetoSelecionado());
		}else
			return "";
	}
	
	public void botaoExcluir(){
		
	}

	public CombosService getCombosService() {
		return combosService;
	}

	public void setCombosService(CombosService combosService) {
		this.combosService = combosService;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public Projeto getProjetoSelecionado() {
		return projetoSelecionado;
	}

	public void setProjetoSelecionado(Projeto projetoSelecionado) {
		this.projetoSelecionado = projetoSelecionado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ProjetoService getProjetoService() {
		return projetoService;
	}

	public void setProjetoService(ProjetoService projetoService) {
		this.projetoService = projetoService;
	}

	public ProjetoIncBean getProjetoIncBean() {
		return projetoIncBean;
	}

	public void setProjetoIncBean(ProjetoIncBean projetoIncBean) {
		this.projetoIncBean = projetoIncBean;
	}

	public ProjetoAltBean getProjetoAltBean() {
		return projetoAltBean;
	}

	public void setProjetoAltBean(ProjetoAltBean projetoAltBean) {
		this.projetoAltBean = projetoAltBean;
	}

}
