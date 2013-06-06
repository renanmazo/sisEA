package sisea.model;

public class Projeto {
	private String idProjeto;
	private String nome;
	private String cliente;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getIdProjeto() {
		return idProjeto;
	}
	public void setIdProjeto(String idProjeto) {
		this.idProjeto = idProjeto;
	}

}
