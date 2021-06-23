package digytal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import digytal.jdbc.connection.FabricaConexao;
import digytal.model.Cadastro;

public class CadastroDao {
	private Connection cnn;
	
	public CadastroDao() {
		FabricaConexao fc = new FabricaConexao();
		cnn = fc.criarConexao();
	}
	public void incluir(Cadastro cadastro) {
		try {
			String sql= "INSERT INTO public.tab_cadastro (nome,telefone) VALUES (?,?);";
			PreparedStatement st = cnn.prepareStatement(sql);
			st.setString(1, cadastro.getNome());
			st.setLong(2, cadastro.getTelefone());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void alterar() {
		
	}
	
}
