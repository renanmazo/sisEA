package sisea.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import sisea.model.Atividade;

public class ComparatorAtividadePorPrioridade implements Comparator<Atividade>{
	
	@Override
	public int compare(Atividade primeiro, Atividade segundo) {
		return String.valueOf(primeiro.getPrioridade()).compareTo(String.valueOf(segundo.getPrioridade()));
	}
	
	public List<Atividade> ordenaPorPrioridade(List<Atividade> lista){
		Collections.sort(lista, new ComparatorAtividadePorPrioridade());
		return lista;
	}

}
