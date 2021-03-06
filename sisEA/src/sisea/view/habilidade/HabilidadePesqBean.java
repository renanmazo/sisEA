package sisea.view.habilidade;

import java.util.ArrayList;
import java.util.List;

import sisea.model.Habilidade;
import sisea.service.habilidade.HabilidadeService;
import sisea.service.combos.CombosService;
import sisea.util.SiteUtil;

public class HabilidadePesqBean {
	private HabilidadeIncBean habilidadeIncBean = (HabilidadeIncBean) SiteUtil.getBeanFromSession("habilidadeIncBean");
	private HabilidadeAltBean habilidadeAltBean = (HabilidadeAltBean) SiteUtil.getBeanFromSession("habilidadeAltBean");
	
	private CombosService combosService = new CombosService();
	private HabilidadeService habilidadeService = new HabilidadeService();
	
	private List<Habilidade> habilidades;
	private Habilidade habilidadeSelecionada;
	
	private String nome;
	
	public String iniciarPagina(){
		inicializar();
		return "IR_PARA_HABILIDADE_PESQ";
	}
	
	public void inicializar(){
		setHabilidades(new ArrayList<Habilidade>());
		setHabilidadeSelecionada(new Habilidade());
		setNome("");
	}
	
	public void botaoPesquisar(){
		setHabilidades(getHabilidadeService().listarHabilidades());
	}
	
	public String botaoIncluir(){
		return getHabilidadeIncBean().iniciarPagina();
	}
	
	public String botaoAlterar(){
		if(getHabilidadeSelecionada() != null){
			return habilidadeAltBean.iniciarPagina(getHabilidadeSelecionada());
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

	public Habilidade getHabilidadeSelecionada() {
		return habilidadeSelecionada;
	}

	public void setHabilidadeSelecionada(Habilidade habilidadeSelecionada) {
		this.habilidadeSelecionada = habilidadeSelecionada;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public HabilidadeService getHabilidadeService() {
		return habilidadeService;
	}

	public void setHabilidadeService(HabilidadeService habilidadeService) {
		this.habilidadeService = habilidadeService;
	}

	public HabilidadeIncBean getHabilidadeIncBean() {
		return habilidadeIncBean;
	}

	public void setHabilidadeIncBean(HabilidadeIncBean habilidadeIncBean) {
		this.habilidadeIncBean = habilidadeIncBean;
	}

	public HabilidadeAltBean getHabilidadeAltBean() {
		return habilidadeAltBean;
	}

	public void setHabilidadeAltBean(HabilidadeAltBean habilidadeAltBean) {
		this.habilidadeAltBean = habilidadeAltBean;
	}

	public List<Habilidade> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}

}
