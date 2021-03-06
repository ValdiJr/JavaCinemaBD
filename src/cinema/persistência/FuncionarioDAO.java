package cinema.persistência;

import java.sql.*;
import java.util.ArrayList;

import cinema.controllers.FuncionarioController;
import cinema.dominio.Funcionario;

public class FuncionarioDAO {
	public static void Create(Funcionario funcionario){
		PreparedStatement pst=null;
		//Inserção de funcionarios a partir do Objeto funcionario.
		String sql = ("INSERT INTO FUNCIONARIO (CPF, NOME_FUNCIONARIO, NUM_CARTEIRA_TRABALHO, RUA, BAIRRO, NUMERO, COD_CINEMA, SENHA) VALUES ('"+funcionario.getCpf()+"', '"+funcionario.getNome()+"', '"+funcionario.getNct()+"', '"+funcionario.getRua()+"', '"+funcionario.getBairro()+"', '"+funcionario.getNumero()+"', '"+funcionario.getCod_cinema()+"', '"+funcionario.getSenha()+"')");
		Conecta.ExecuteQuery(sql);
	}
	
	public static void Delete(String cpf){
		PreparedStatement pst=null;
		//Deleta funcionario a partir do seu CPF
		String sql=("DELETE [cinema].[dbo].[FUNCIONARIO] WHERE CPF = "+cpf);
		Conecta.ExecuteQuery(sql);
	}
	
	public static Funcionario Busca(String cpf){
		Funcionario funcionario = new Funcionario();
		String sql=("SELECT * FROM [cinema].[dbo].[FUNCIONARIO] WHERE CPF = '"+cpf+"'");
		ResultSet rs = null;
		try {
			rs = Conecta.GetResultQuery(sql);
			while(rs.next()){
				funcionario.setNome(rs.getString("NOME_FUNCIONARIO"));
				funcionario.setCpf(rs.getString("CPF"));
				funcionario.setNct(rs.getString("NUM_CARTEIRA_TRABALHO"));
				funcionario.setRua(rs.getString("RUA"));
				funcionario.setBairro(rs.getString("BAIRRO"));
				funcionario.setNumero(rs.getString("NUMERO"));
				funcionario.setCod_cinema(rs.getString("COD_CINEMA"));
				funcionario.setSenha(rs.getString("SENHA"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
		}
		return funcionario;
	}
	public static void Update(Funcionario funcionario){
		String sql = ("UPDATE [cinema].[dbo].[FUNCIONARIO] "
				+ "SET NOME_FUNCIONARIO = '"+funcionario.getNome()+"', NUM_CARTEIRA_TRABALHO = '"+funcionario.getNct()+"', RUA = '"+funcionario.getRua()+"', BAIRRO = '"+funcionario.getBairro()+"', NUMERO = "+funcionario.getNumero()+", COD_CINEMA = '"+funcionario.getCod_cinema()+"', SENHA = '"+funcionario.getSenha()
				+"' WHERE CPF = '"+funcionario.getCpf()+"'");
		Conecta.ExecuteQuery(sql);
	}
	public static ArrayList<String> Listar(){
		ArrayList<String> dados = new ArrayList<String>();
		ResultSet rs = null;
		String sql=("SELECT * FROM [cinema].[dbo].[FUNCIONARIO]");
		
		try {
			rs = Conecta.GetResultQuery(sql);
			while (rs.next()){
				dados.add(rs.getString("CPF")+";"+rs.getString("NOME_FUNCIONARIO")+";"+rs.getString("COD_CINEMA"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch(Exception e) {}
		}
		
		return dados;
	}
}
