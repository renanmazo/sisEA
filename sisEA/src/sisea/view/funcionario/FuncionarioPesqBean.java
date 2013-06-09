package sisea.view.funcionario;

import java.util.ArrayList;
import java.util.List;

import sisea.model.Funcionario;
import sisea.service.funcionario.FuncionarioService;
import sisea.service.combos.CombosService;
import sisea.util.SiteUtil;

public class FuncionarioPesqBean {
	private FuncionarioIncBean funcionarioIncBean = (FuncionarioIncBean) SiteUtil.getBeanFromSession("funcionarioIncBean");
	private FuncionarioAltBean funcionarioAltBean = (FuncionarioAltBean) SiteUtil.getBeanFromSession("funcionarioAltBean");
	
	private CombosService combosService = new CombosService();
	private FuncionarioService funcionarioService = new FuncionarioService();
	
	private List<Funcionario> funcionarios;
	private Funcionario funcionarioSelecionado;
	
	private String nome;
	
	public String iniciarPagina(){
		inicializar();
		return "IR_PARA_FUNCIONARIO_PESQ";
	}
	
	public void inicializar(){
		setFuncionarios(new ArrayList<Funcionario>());
		setFuncionarioSelecionado(new Funcionario());
		setNome("");
	}
	
	public void botaoPesquisar(){
		setFuncionarios(getFuncionarioService().listarFuncionarios());
	}
	
	public String botaoIncluir(){
		return getFuncionarioIncBean().iniciarPagina();
	}
	
	public String botaoAlterar(){
		if(getFuncionarioSelecionado() != null){
			return funcionarioAltBean.iniciarPagina(getFuncionarioSelecionado());
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

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public FuncionarioService getFuncionarioService() {
		return funcionarioService;
	}

	public void setHabilidadeService(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	public FuncionarioIncBean getFuncionarioIncBean() {
		return funcionarioIncBean;
	}

	public void setFuncionarioIncBean(FuncionarioIncBean funcionarioIncBean) {
		this.funcionarioIncBean = funcionarioIncBean;
	}

	public FuncionarioAltBean getFuncionarioAltBean() {
		return funcionarioAltBean;
	}

	public void setFuncionarioAltBean(FuncionarioAltBean funcionarioAltBean) {
		this.funcionarioAltBean = funcionarioAltBean;
	}

}
