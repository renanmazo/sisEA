package sisea.service.funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sisea.conexao.Conexao;

import sisea.model.Funcionario;
import sisea.model.Habilidade;

public class FuncionarioService {

	private Connection conexao;

	public Funcionario listarFuncionario(int idFuncionario) {
		String query = "SELECT * FROM tb_funcionario WHERE idFuncionario = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Funcionario funcionario = new Funcionario();
		try {
			conexao = new Conexao().getConexao();
			ps = conexao.prepareStatement(query);
			ps.setInt(1, idFuncionario);
			rs = ps.executeQuery();
			funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
			funcionario.setNome(rs.getString("nome"));
			funcionario.setSobrenome(rs.getString("sobrenome"));
			funcionario.setStatus(rs.getString("status"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.fecharConexoes(rs, conexao, ps);
		}

		return funcionario;
	}

	public List<Funcionario> buscarFuncionarioLivre() {
		String query = "SELECT * FROM tb_funcionario WHERE status = 'LIVRE'";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Funcionario> listaRetorno = new ArrayList<Funcionario>();
		try {
			conexao = new Conexao().getConexao();
			ps = conexao.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setSobrenome(rs.getString("sobrenome"));
				funcionario.setStatus(rs.getString("status"));
				listaRetorno.add(funcionario);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.fecharConexoes(conexao, ps);
		}

		return listaRetorno;
	}

	public List<Funcionario> buscarFuncionarioHabilidadeLivre() {
		String query = "SELECT f.idFuncionario, f.nome, f.sobrenome, f.status, h.idHabilidade, h.descricao FROM tb_funcionario f, "
				+ "tb_habilidade h, rel_funcionariohabilidade r WHERE f.idFuncionario = r.idFuncionario AND "
				+ "h.idHabilidade = r.idHabilidade AND status = 'LIVRE' ORDER BY f.idFuncionario";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Funcionario> listaRetorno = new ArrayList<Funcionario>();
		try {
			conexao = new Conexao().getConexao();
			ps = conexao.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				Habilidade habilidade = new Habilidade();
				if (listaRetorno.size() == 0) {
					funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
					funcionario.setNome(rs.getString("nome"));
					funcionario.setSobrenome(rs.getString("sobrenome"));
					funcionario.setStatus(rs.getString("status"));
					habilidade.setIdHabilidade(rs.getInt("idHabilidade"));
					habilidade.setDescricao(rs.getString("descricao"));
					funcionario.getHabilidades().add(habilidade);
					listaRetorno.add(funcionario);
				} else {
					if (rs.getInt("idFuncionario") != listaRetorno.get(
							(listaRetorno.size() - 1)).getIdFuncionario()) {
						funcionario
								.setIdFuncionario(rs.getInt("idFuncionario"));
						funcionario.setNome(rs.getString("nome"));
						funcionario.setSobrenome(rs.getString("sobrenome"));
						funcionario.setStatus(rs.getString("status"));
						habilidade.setIdHabilidade(rs.getInt("idHabilidade"));
						habilidade.setDescricao(rs.getString("descricao"));
						funcionario.getHabilidades().add(habilidade);
						listaRetorno.add(funcionario);
					} else {

						habilidade.setIdHabilidade(rs.getInt("idHabilidade"));
						habilidade.setDescricao(rs.getString("descricao"));
						listaRetorno.get((listaRetorno.size() - 1))
								.getHabilidades().add(habilidade);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.fecharConexoes(conexao, ps);
		}

		return listaRetorno;
	}
}
