package sisea.view.escalonamento;

import java.util.ArrayList;
import java.util.List;

import sisea.model.Atividade;
import sisea.model.Funcionario;
import sisea.model.Habilidade;
import sisea.service.atividade.AtividadeService;
import sisea.service.funcionario.FuncionarioService;

public class EscalonamentoBean {
	
	private FuncionarioService funcionarioService;
	private AtividadeService atividadeService;
	private List<Funcionario> funcionarios;
	private List<Atividade> atividades;
	private Funcionario funcionarioSelecionado;
	private Atividade atividadeSelecionada;
	private List<Atividade> atividadeEscalonada;

	
	public String iniciarPagina(){
		inicializar();
		carregaListaFuncionarioLivre();
		carregaListaAtividades();
		return "IR_PARA_ESCALONAMENTO";
	}
	
	
	public void carregaListaFuncionarioLivre(){
		setFuncionarios(getFuncionarioService().buscarFuncionarioHabilidadeLivre());
	}
	
	public void carregaListaAtividades(){
		setAtividades(getAtividadeService().listarAtividades());
	}
	
	public void realizarEscalonamento(){
		
		for(Atividade atividade : getAtividades()){
			int numeroHabilidadesCompativeis = 0;
			List<Habilidade> habilidadesNecessarias = atividade.getHabilidades();
			
			for(Funcionario funcionario : getFuncionarios()){
				List<Habilidade> habilidadesFuncionario = funcionario.getHabilidades();
				
				for(int i = 0; i < habilidadesNecessarias.size(); i++){
					for(int j = 0; j < habilidadesFuncionario.size(); j++){
						if(habilidadesNecessarias.get(i).getIdHabilidade() == habilidadesFuncionario.get(j).getIdHabilidade()){
							numeroHabilidadesCompativeis++;
						}
					}
				}
				if(numeroHabilidadesCompativeis == habilidadesNecessarias.size()){
					funcionario.setTarefa(atividade);
					atividade.setFuncionario(funcionario);
					getAtividadeEscalonada().add(atividade);
				}
			}
		}
	}
	
	public void inicializar(){
		funcionarioService = new FuncionarioService();
		atividadeService = new AtividadeService();
		funcionarios = new ArrayList<Funcionario>();
		atividades = new ArrayList<Atividade>();
		atividadeEscalonada = new ArrayList<Atividade>();
	}


	public FuncionarioService getFuncionarioService() {
		return funcionarioService;
	}

	public void setFuncionarioService(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
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


	public AtividadeService getAtividadeService() {
		return atividadeService;
	}


	public void setAtividadeService(AtividadeService atividadeService) {
		this.atividadeService = atividadeService;
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


	public List<Atividade> getAtividadeEscalonada() {
		return atividadeEscalonada;
	}


	public void setAtividadeEscalonada(List<Atividade> atividadeEscalonada) {
		this.atividadeEscalonada = atividadeEscalonada;
	}
	
	

}
