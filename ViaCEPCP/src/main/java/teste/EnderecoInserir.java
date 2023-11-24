package teste;

import java.io.IOException;
import java.sql.Connection;

import javax.swing.JOptionPane;

import conexao.Conexao;
import dao.EnderecoDAO;
import model.Endereco;
import service.ViacepService;

public class EnderecoInserir {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		
		Endereco endereco = new Endereco();
		EnderecoDAO enderecodao = new EnderecoDAO(con);
		ViacepService viacepservice = new ViacepService();
		
		try {
		
			endereco = viacepservice.getEndereco(JOptionPane.showInputDialog("Digite o CEP"));
			
			String recebeCep = endereco.getCep();
			String recebeLogradouro = endereco.getLogradouro();
			String recebeComplemento = endereco.getComplemento();
			String recebeBairro = endereco.getBairro();
			String recebeLocalidade = endereco.getLocalidade();
			String recebeUf = endereco.getUf();
			String recebeIbge = endereco.getIbge();
			String recebeGia = endereco.getGia();
			String recebeDdd = endereco.getDdd();
			String recebeSiafi = endereco.getSiafi();
			
			endereco.setBairro(recebeBairro);
			endereco.setCep(recebeCep);
			endereco.setComplemento(recebeComplemento);
			endereco.setDdd(recebeDdd);
			endereco.setGia(recebeGia);
			endereco.setIbge(recebeIbge);
			endereco.setLocalidade(recebeLocalidade);
			endereco.setLogradouro(recebeLogradouro);
			endereco.setSiafi(recebeSiafi);
			endereco.setUf(recebeUf);
			System.out.println(enderecodao.inserir(endereco));
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Conexao.fecharConexao(con);
	}

}
