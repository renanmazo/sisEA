package sisea.view.habilidade;

import sisea.model.Habilidade;
import sisea.service.combos.CombosService;
import sisea.service.funcionario.FuncionarioService;
import sisea.service.habilidade.HabilidadeService;

public class HabilidadeAltBean {
	private CombosService combosService = new CombosService();
	private HabilidadeService habilidadeService = new HabilidadeService();
	
	private Habilidade habilidade;
	
	public String iniciarPagina(Habilidade habilidade){
		inicializar();
		carregarTela(habilidade);
		return "IR_PARA_HABILIDADE_ALT";
	}
	
	public void inicializar(){
		setHabilidade(new Habilidade());
	}
	
	public void carregarTela(Habilidade habilidade){
		setHabilidade(habilidade);
	}

	public Habilidade getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(Habilidade habilidade) {
		this.habilidade = habilidade;
	}

	public CombosService getCombosService() {
		return combosService;
	}

	public void setCombosService(CombosService combosService) {
		this.combosService = combosService;
	}

	public HabilidadeService getHabilidadeService() {
		return habilidadeService;
	}

	public void setHabilidadeService(HabilidadeService habilidadeService) {
		this.habilidadeService = habilidadeService;
	}

}
