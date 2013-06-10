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
import sisea.util.SiteUtil;

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
				atividade.setIdPrioridade(rs.getString("prioridade"));
				atividade.setPrioridade(SiteUtil.prioridadeLiteral(atividade.getIdPrioridade()));
				atividade.setIdStatus(rs.getString("status"));
				atividade.setStatus(SiteUtil.statusLiteral(atividade.getIdStatus()));
				projeto.setIdProjeto(rs.getString("idProjeto"));
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
				atividade.setIdPrioridade(rs.getString("prioridade"));
				atividade.setPrioridade(SiteUtil.prioridadeLiteral(atividade.getIdPrioridade()));
				atividade.setStatus(rs.getString("status"));
				projeto.setIdProjeto(rs.getString("idProjeto"));
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
	
	public void incluirAtividade(Atividade atividade){
		String query = "INSERT INTO tb_atividade (nome, descricao, prioridade, idProjeto, status) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		try {
			conexao = new Conexao().getConexao();
			ps = conexao.prepareStatement(query);
			ps.setString(1, atividade.getNome());
			ps.setString(2, atividade.getDescricao());
			ps.setString(3, atividade.getIdPrioridade());
			ps.setString(4, atividade.getProjeto().getIdProjeto());
			ps.setString(5, atividade.getIdStatus());
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.fecharConexoes(conexao, ps);
		}
	}
	
	public String listarAtividadesPorNome(String nome) {
		String query = "SELECT * FROM tb_atividade WHERE nome = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		String retorno = "";
		try {
			conexao = new Conexao().getConexao();
			ps = conexao.prepareStatement(query);
			ps.setString(1, nome);
			rs = ps.executeQuery();
			while (rs.next()) {
				retorno = String.valueOf(rs.getInt("idAtividade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.fecharConexoes(rs, conexao, ps);
		}
		return retorno;
	}
	
	public void incluirHabilidadeAtividade(String idAtividade, String idHabilidade){
		String query = "INSERT INTO rel_atividadehabilidade (idAtividade, idHabilidade) VALUES (?, ?)";
		PreparedStatement ps = null;
		try {
			conexao = new Conexao().getConexao();
			ps = conexao.prepareStatement(query);
			ps.setString(1, idAtividade);
			ps.setString(2, idHabilidade);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.fecharConexoes(conexao, ps);
		}
	}
}
