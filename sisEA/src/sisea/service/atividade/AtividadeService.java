package sisea.service.atividade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sisea.conexao.Conexao;
import sisea.model.Projeto;
import sisea.model.Atividade;
import sisea.service.funcionario.FuncionarioService;
import sisea.service.habilidade.HabilidadeService;

public class AtividadeService {
	
	private Connection conexao;
	private FuncionarioService funcionarioService= new FuncionarioService();
	private HabilidadeService habilidadeService= new HabilidadeService();
	
	public List<Atividade> listarAtividades() {
		String query = "SELECT *, p.nome AS nomeProjeto FROM tb_tarefa t JOIN tb_projeto p ON t.idProjeto = p.idProjeto ORDER BY t.idTarefa";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Atividade> listaRetorno = new ArrayList<Atividade>();
		try {
			conexao = new Conexao().getConexao();
			ps = conexao.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Atividade atividade = new Atividade();
				Projeto projeto = new Projeto();
				
				atividade.setIdTarefa(rs.getInt("idTarefa"));
				atividade.setNome(rs.getString("nome"));
				atividade.setDescricao(rs.getString("descricao"));
				atividade.setPrioridade(rs.getInt("prioridade"));
				atividade.setStatus(rs.getString("status"));
				projeto.setIdProjeto(rs.getInt("idProjeto"));
				projeto.setNome(rs.getString("nomeProjeto"));
				atividade.setProjeto(projeto);
				atividade.setHabilidades(habilidadeService.listarHabilidadesTarefa(atividade.getIdTarefa()));
				if(rs.getInt("idFuncionario") != 0){
					atividade.setFuncionario(funcionarioService.listarFuncionario(rs.getInt("idFuncionario")));
				}
				
				listaRetorno.add(atividade);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.fecharConexoes(rs, conexao, ps);
		}

		return listaRetorno;
	}

	public List<Atividade> buscarTarefaNova() {
		String query = "SELECT t.idTarefa, t.nome, t.descricao, t.prioridade, t.idProjeto, t.status, p.nome nomeProjeto FROM " +
				"tb_tarefa t, tb_projeto p WHERE t.idProjeto = p.idProjeto AND status = 'NOVA' ORDER BY t.prioridade DESC";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Atividade> listaRetorno = new ArrayList<Atividade>();
		try {
			conexao = new Conexao().getConexao();
			ps = conexao.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Atividade tarefa = new Atividade();
				Projeto projeto = new Projeto();
				
				tarefa.setIdTarefa(rs.getInt("idTarefa"));
				tarefa.setNome(rs.getString("nome"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setPrioridade(rs.getInt("prioridade"));
				tarefa.setStatus(rs.getString("status"));
				projeto.setIdProjeto(rs.getInt("idProjeto"));
				projeto.setNome(rs.getString("nomeProjeto"));
				tarefa.setProjeto(projeto);
				
				listaRetorno.add(tarefa);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.fecharConexoes(conexao, ps);
		}

		return listaRetorno;
	}


}
