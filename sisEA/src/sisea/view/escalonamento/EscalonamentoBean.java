package sisea.view.escalonamento;

import java.util.ArrayList;
import java.util.List;

import sisea.model.Atividade;
import sisea.model.Funcionario;
import sisea.model.Habilidade;
import sisea.service.atividade.AtividadeService;
import sisea.service.funcionario.FuncionarioService;
import sisea.util.ComparatorAtividadePorPrioridade;
import sisea.util.ComparatorFuncionarioPorNumeroHabilidades;

public class EscalonamentoBean {
	
	private FuncionarioService funcionarioService = new FuncionarioService();
	private AtividadeService atividadeService = new AtividadeService();
	
	private List<Funcionario> funcionariosLivres;
	private List<Atividade> atividadesNovas;
	private Funcionario funcionarioSelecionado;
	private Atividade atividadeSelecionada;
	private List<Atividade> atividadeEscalonada;
	
	List<Atividade> atividadesOrdenadas = new ArrayList<Atividade>();
	List<Funcionario> funcionariosOrdenados = new ArrayList<Funcionario>();
	
	public String iniciarPagina(){
		inicializar();
		carregaListaFuncionarioLivre();
		carregaListaAtividadesNovas();
		return "IR_PARA_ESCALONAMENTO";
	}
	
	public void inicializar(){
		funcionariosLivres = new ArrayList<Funcionario>();
		atividadesNovas = new ArrayList<Atividade>();
		atividadeEscalonada = new ArrayList<Atividade>();
		setFuncionarioSelecionado(new Funcionario());
		setAtividadeSelecionada(new Atividade());
	}
	
	
	public void carregaListaFuncionarioLivre(){
		setFuncionariosLivres(getFuncionarioService().buscarFuncionarioLivre());
	}
	
	public void carregaListaAtividadesNovas(){
		setAtividadesNovas(getAtividadeService().listarAtividadesNovas());
	}
	
	public void realizarEscalonamento(){
		setAtividadeEscalonada(new ArrayList<Atividade>());
		carregarListasOrdenadas();

		for(Atividade atividade : atividadesOrdenadas){
			int numeroHabilidadesCompativeis = 0;
			List<Habilidade> habilidadesNecessarias = atividade.getHabilidades();
			
			for(Funcionario funcionario : funcionariosOrdenados){
				List<Habilidade> habilidadesFuncionario = funcionario.getHabilidades();
				
				for(int i = 0; i < habilidadesNecessarias.size(); i++){
					for(int j = 0; j < habilidadesFuncionario.size(); j++){
						if(habilidadesNecessarias.get(i).getIdHabilidade() == habilidadesFuncionario.get(j).getIdHabilidade()){
							numeroHabilidadesCompativeis++;
						}
					}
				}
				if(numeroHabilidadesCompativeis == habilidadesNecessarias.size()){
					if(funcionario.getStatus() != "ALOCADO"){
						funcionario.setAtividade(atividade);
						funcionario.setStatus("ALOCADO");
						atividade.setFuncionario(funcionario);
						getAtividadeEscalonada().add(atividade);	
					}
				}
			}
		}
	}
	
	public void carregarListasOrdenadas(){
		atividadesOrdenadas = getAtividadeService().listarAtividadesNovas();
		atividadesOrdenadas = ComparatorAtividadePorPrioridade.ordenaPorPrioridade(atividadesOrdenadas);
		funcionariosOrdenados = getFuncionarioService().buscarFuncionarioLivre();
		funcionariosOrdenados = ComparatorFuncionarioPorNumeroHabilidades.ordenaPorNumeroHabilidades(funcionariosOrdenados);
	}

	public FuncionarioService getFuncionarioService() {
		return funcionarioService;
	}

	public void setFuncionarioService(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	public AtividadeService getAtividadeService() {
		return atividadeService;
	}

	public void setAtividadeService(AtividadeService atividadeService) {
		this.atividadeService = atividadeService;
	}

	public List<Funcionario> getFuncionariosLivres() {
		return funcionariosLivres;
	}

	public void setFuncionariosLivres(List<Funcionario> funcionariosLivres) {
		this.funcionariosLivres = funcionariosLivres;
	}

	public List<Atividade> getAtividadesNovas() {
		return atividadesNovas;
	}

	public void setAtividadesNovas(List<Atividade> atividadesNovas) {
		this.atividadesNovas = atividadesNovas;
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public Atividade getAtividadeSelecionada() {
		return atividadeSelecionada;
	}

	public void setAtividadeSelecionada(Atividade atividadeSelecionada) {
		this.atividadeSelecionada = atividadeSelecionada;
	}

	public List<Atividade> getAtividadeEscalonada() {
		return atividadeEscalonada;
	}

	public void setAtividadeEscalonada(List<Atividade> atividadeEscalonada) {
		this.atividadeEscalonada = atividadeEscalonada;
	}

}
