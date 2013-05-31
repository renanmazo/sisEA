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
		String query = "SELECT *, p.nome AS nomeProjeto FROM tb_atividade t JOIN tb_projeto p ON t.idProjeto = p.idProjeto ORDER BY t.idAtividade";
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
				
				atividade.setIdAtividade(rs.getInt("idAtividade"));
				atividade.setNome(rs.getString("nome"));
				atividade.setDescricao(rs.getString("descricao"));
				atividade.setPrioridade(rs.getInt("prioridade"));
				atividade.setStatus(rs.getString("status"));
				projeto.setIdProjeto(rs.getInt("idProjeto"));
				projeto.setNome(rs.getString("nomeProjeto"));
				atividade.setProjeto(projeto);
				atividade.setHabilidades(habilidadeService.listarHabilidadesAtividade(atividade.getIdAtividade()));
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

	public List<Atividade> listarAtividadesNovas() {
		String query = "SELECT *, p.nome AS nomeProjeto FROM tb_atividade t JOIN tb_projeto p ON t.idProjeto = p.idProjeto WHERE status = 'NOVA' ORDER BY t.idAtividade";
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
				
				atividade.setIdAtividade(rs.getInt("idAtividade"));
				atividade.setNome(rs.getString("nome"));
				atividade.setDescricao(rs.getString("descricao"));
				atividade.setPrioridade(rs.getInt("prioridade"));
				atividade.setStatus(rs.getString("status"));
				projeto.setIdProjeto(rs.getInt("idProjeto"));
				projeto.setNome(rs.getString("nomeProjeto"));
				atividade.setProjeto(projeto);
				atividade.setHabilidades(habilidadeService.listarHabilidadesAtividade(atividade.getIdAtividade()));
				listaRetorno.add(atividade);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.fecharConexoes(rs, conexao, ps);
		}
		return listaRetorno;
	}
}
