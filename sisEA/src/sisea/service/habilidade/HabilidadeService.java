package sisea.service.habilidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sisea.conexao.Conexao;
import sisea.model.Habilidade;

public class HabilidadeService {
	
	private Connection conexao;
	
	public List<Habilidade> listarHabilidadesAtividade(int idAtividade){
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM rel_atividadehabilidade a JOIN tb_habilidade b ON a.idHabilidade = b.idHabilidade WHERE idAtividade = ?";
		List<Habilidade> listaRetorno = new ArrayList<Habilidade>();
		try {
			conexao = new Conexao().getConexao();
			ps = conexao.prepareStatement(query);
			ps.setInt(1, idAtividade);
			rs = ps.executeQuery();
			while (rs.next()) {
				Habilidade habilidade = new Habilidade();
				habilidade.setDescricao(rs.getString("descricao"));
				habilidade.setIdHabilidade(rs.getInt("idHabilidade"));
				listaRetorno.add(habilidade);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.fecharConexoes(rs, conexao, ps);
		}
		
		return listaRetorno;
	}
	
	public List<Habilidade> listarHabilidadesFuncionario(int idFuncionario){
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM rel_funcionariohabilidade a JOIN tb_funcionario b ON a.idHabilidade = b.idHabilidade WHERE idFuncionario = ?";
		List<Habilidade> listaRetorno = new ArrayList<Habilidade>();
		try {
			conexao = new Conexao().getConexao();
			ps = conexao.prepareStatement(query);
			ps.setInt(1, idFuncionario);
			rs = ps.executeQuery();
			while (rs.next()) {
				Habilidade habilidade = new Habilidade();
				habilidade.setDescricao(rs.getString("descricao"));
				habilidade.setIdHabilidade(rs.getInt("idHabilidade"));
				listaRetorno.add(habilidade);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.fecharConexoes(rs, conexao, ps);
		}
		
		return listaRetorno;
	}
	

}
