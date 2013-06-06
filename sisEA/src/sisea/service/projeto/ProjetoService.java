package sisea.service.projeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sisea.conexao.Conexao;
import sisea.model.Projeto;

public class ProjetoService {
	private Connection conexao;
	
	public List<Projeto> listarProjetos(){
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM tb_projeto";
		List<Projeto> listaRetorno = new ArrayList<Projeto>();
		try {
			conexao = new Conexao().getConexao();
			ps = conexao.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Projeto projeto = new Projeto();
				projeto.setIdProjeto(rs.getString("idProjeto"));
				projeto.setNome(rs.getString("nome"));
				projeto.setCliente(rs.getString("cliente"));
				listaRetorno.add(projeto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexao.fecharConexoes(rs, conexao, ps);
		}
		
		return listaRetorno;
	}

}
