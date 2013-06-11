package sisea.view.habilidade;

import sisea.model.Habilidade;

public class HabilidadeIncBean {

	private Habilidade habilidade;

	public String iniciarPagina() {
		inicializar();
		return "IR_PARA_HABILIDADE_INC";
	}

	public void inicializar() {
		setHabilidade(new Habilidade());
	}

	public Habilidade getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(Habilidade habilidade) {
		this.habilidade = habilidade;
	}
	
	

}
