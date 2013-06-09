package sisea.view.projeto;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import sisea.model.Projeto;
import sisea.service.combos.CombosService;

public class ProjetoAltBean {
	private CombosService combosService = new CombosService();
	private Projeto projeto;
	private List<SelectItem> comboStatus;

	public String iniciarPagina(Projeto projeto){
		inicializar();
		carregarTela(projeto);
		return "IR_PARA_PROJETO_ALT";
	}
	
	public void inicializar(){
		setProjeto(new Projeto());
		setComboStatus(new ArrayList<SelectItem>());

	}
	
	public void carregarTela(Projeto projeto){
		setProjeto(projeto);
		carregaComboStatus();
	}

	
	public void carregaComboStatus(){
		setComboStatus(getCombosService().carregaComboStatus());
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<SelectItem> getComboStatus() {
		return comboStatus;
	}

	public void setComboStatus(List<SelectItem> comboStatus) {
		this.comboStatus = comboStatus;
	}


	public CombosService getCombosService() {
		return combosService;
	}

	public void setCombosService(CombosService combosService) {
		this.combosService = combosService;
	}

}
