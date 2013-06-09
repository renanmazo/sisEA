package sisea.view.funcionario;

import sisea.model.Funcionario;
import sisea.service.combos.CombosService;
import sisea.service.funcionario.FuncionarioService;

public class FuncionarioAltBean {
	private CombosService combosService = new CombosService();
	private FuncionarioService funcionarioService = new FuncionarioService();
	
	private Funcionario funcionario;
	
	public String iniciarPagina(Funcionario funcionario){
		inicializar();
		//IMPLEMENTAR COMBO DE HABILIDADES
		carregarTela(funcionario);
		return "IR_PARA_FUNCIONARIO_ALT";
	}
	
	public void inicializar(){
		setFuncionario(new Funcionario());
	}
	
	public void carregarTela(Funcionario funcionario){
		setFuncionario(funcionario);
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public CombosService getCombosService() {
		return combosService;
	}

	public void setCombosService(CombosService combosService) {
		this.combosService = combosService;
	}

	public FuncionarioService getHabilidadeService() {
		return funcionarioService;
	}

	public void setFuncionarioService(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

}
