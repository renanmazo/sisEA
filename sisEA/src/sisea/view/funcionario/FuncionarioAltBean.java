package sisea.view.funcionario;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.DualListModel;

import sisea.model.Funcionario;
import sisea.model.Habilidade;
import sisea.service.combos.CombosService;
import sisea.service.funcionario.FuncionarioService;
import sisea.service.habilidade.HabilidadeService;

public class FuncionarioAltBean {
	private CombosService combosService = new CombosService();
	private FuncionarioService funcionarioService = new FuncionarioService();
	private HabilidadeService habilidadeService = new HabilidadeService();
	
	private Funcionario funcionario;
	private DualListModel<Habilidade> habilidades;
	
	public String iniciarPagina(Funcionario funcionario){
		inicializar();
		carregarTela(funcionario);
		carregaPickListHabilidades();
		return "IR_PARA_FUNCIONARIO_ALT";
	}
	
	public void inicializar(){
		setFuncionario(new Funcionario());
		setHabilidades(new DualListModel<Habilidade>());
	}
	
	public void carregarTela(Funcionario funcionario){
		setFuncionario(funcionario);
	}
	
	public void carregaPickListHabilidades(){
		List<Habilidade> habilidadesExistentes = new ArrayList<Habilidade>();
		List<Habilidade> habilidadesAtividade = new ArrayList<Habilidade>();
		habilidadesExistentes = getHabilidadeService().listarHabilidades();
		setHabilidades(new DualListModel<Habilidade>(habilidadesExistentes, habilidadesAtividade));
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

	public DualListModel<Habilidade> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(DualListModel<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}

	public FuncionarioService getFuncionarioService() {
		return funcionarioService;
	}

	public void setFuncionarioService(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	public HabilidadeService getHabilidadeService() {
		return habilidadeService;
	}

	public void setHabilidadeService(HabilidadeService habilidadeService) {
		this.habilidadeService = habilidadeService;
	}

}
