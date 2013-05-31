package sisea.service.funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sisea.conexao.Conexao;

import sisea.model.Funcionario;
import sisea.service.habilidade.HabilidadeService;

public class FuncionarioService {

	private Connection conexao;
	private HabilidadeService habilidadeService= new HabilidadeService();

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
				funcionario.setHabilidades(habilidadeService.listarHabilidadesFuncionario(funcionario.getIdFuncionario()));
				listaRetorno.add(funcionario);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.fecharConexoes(rs, conexao, ps);
		}

		return listaRetorno;
	}
}
