package sisea.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import sisea.model.Funcionario;

public final class ComparatorFuncionarioPorNumeroHabilidades implements Comparator<Funcionario>{

	@Override
	public int compare(Funcionario primeiro, Funcionario segundo) {
		return String.valueOf(primeiro.getHabilidades().size()).compareTo(String.valueOf(segundo.getHabilidades().size()));
	}
	
	public static List<Funcionario> ordenaPorNumeroHabilidades(List<Funcionario> lista){
		Collections.sort(lista, new ComparatorFuncionarioPorNumeroHabilidades());
		return lista;
	}

}
