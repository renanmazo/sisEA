package sisea.model;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
	private int idFuncionario;
	private String nome;
	private String sobrenome;
	private String status;
	private Atividade tarefa;
	private List<Habilidade> habilidades = new ArrayList<Habilidade>();
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Atividade getTarefa() {
		return tarefa;
	}
	public void setTarefa(Atividade tarefa) {
		this.tarefa = tarefa;
	}
	public List<Habilidade> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(List<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}

}
