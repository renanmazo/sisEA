package sisea.service.combos;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import sisea.model.Projeto;
import sisea.service.projeto.ProjetoService;

public class CombosService {
	private ProjetoService projetoService = new ProjetoService();
	
	public List<SelectItem> carregarComboPrioridades(){
		List<SelectItem> listaRetorno = new ArrayList<SelectItem>();
		
		listaRetorno.add(new SelectItem("0", "Selecione"));
		listaRetorno.add(new SelectItem("1", "Altíssima"));
		listaRetorno.add(new SelectItem("2", "Alta"));
		listaRetorno.add(new SelectItem("3", "Média"));
		listaRetorno.add(new SelectItem("4", "Baixa"));
		listaRetorno.add(new SelectItem("5", "Baixíssima"));
		
		return listaRetorno;
	}
	
	public List<SelectItem> carregaComboProjeto(){
		List<SelectItem> listaRetorno = new ArrayList<SelectItem>();
		List<Projeto> projetos = getProjetoService().listarProjetos();
		
		listaRetorno.add(new SelectItem("0", "Selecione"));
		for (Projeto projeto : projetos) {
			listaRetorno.add(new SelectItem(projeto.getIdProjeto(), projeto.getNome()));			
		}
		
		return listaRetorno;
	}
	
	public List<SelectItem> carregaComboStatus(){
		List<SelectItem> listaRetorno = new ArrayList<SelectItem>();
		
		listaRetorno.add(new SelectItem("0", "Selecione"));
		listaRetorno.add(new SelectItem("NOVA", "Nova"));
		listaRetorno.add(new SelectItem("PAUSADA", "Pausada"));
		listaRetorno.add(new SelectItem("EM ANDAMENTO", "Em andamento"));
		listaRetorno.add(new SelectItem("FINALIZADA", "Finalizada"));
		listaRetorno.add(new SelectItem("CANCELADA", "Cancelada"));
		
		return listaRetorno;
	}

	public ProjetoService getProjetoService() {
		return projetoService;
	}

	public void setProjetoService(ProjetoService projetoService) {
		this.projetoService = projetoService;
	}
	
}
