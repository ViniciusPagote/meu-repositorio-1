package digytal;

import digytal.dao.CadastroDao;
import digytal.model.Cadastro;

public class JDBCApplication {
	public static void main(String[] args) {
		CadastroDao dao = new CadastroDao();
		
		
		Cadastro cadastro = new Cadastro();
		cadastro.setNome("TOMAS");
		cadastro.setTelefone(98098976543l);
		dao.incluir(cadastro);
	}
}
