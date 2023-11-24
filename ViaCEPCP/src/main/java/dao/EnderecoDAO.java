package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Endereco;

public class EnderecoDAO {

	private Connection con = null;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public EnderecoDAO(Connection con) {
		setCon(con);
	}
	
	public String inserir(Endereco endereco) {
		String sql = "insert into endereco(bairro, cep, complemento, ddd, gia, ibge, localidade, logradouro, siafi, uf) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, endereco.getBairro());
			ps.setString(2, endereco.getCep());
			ps.setString(3, endereco.getComplemento());
			ps.setString(4, endereco.getDdd());
			ps.setString(5, endereco.getGia());
			ps.setString(6, endereco.getIbge());
			ps.setString(7, endereco.getLocalidade());
			ps.setString(8, endereco.getLogradouro());
			ps.setString(9, endereco.getSiafi());
			ps.setString(10, endereco.getUf());
			
			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
}
