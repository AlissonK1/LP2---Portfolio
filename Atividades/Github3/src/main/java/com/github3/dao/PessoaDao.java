package com.github3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github3.beans.Pessoa;

public class PessoaDao {

public static Connection getConnection() throws SQLException {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/github3", "root", "Fortnite1$");
			System.out.println("Conectado");
		}catch(Exception e) {
			System.out.println("Não Conectado");
			System.out.println(e);
		}
		return con;
	}


public static int salvarPessoa(Pessoa p) {
	int status = 0;
	
	try {
		Connection con = getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO pessoa(nome, civil, sexo) VALUES (?, ?, ?)");
		ps.setString(1, p.getNome());
		ps.setString(2, p.getCivil());
		ps.setString(3, p.getSexo());
		status = ps.executeUpdate();
	}catch(Exception e) {
		System.out.println(e);
	}
	return status;
}

public static int deletarPessoa(Pessoa p) {
	int status = 0;
	
	try {
		Connection con = getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM pessoa WHERE id=?");
		ps.setInt(1, p.getId());
		status = ps.executeUpdate();
	}catch(Exception e) {
		System.out.println(e);
	}
	return status;	
}


public static Pessoa getRegistroById(int id) {
    Pessoa pessoa = null;

    try {
        Connection con = getConnection();
        PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM pessoa WHERE id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
        	pessoa = new Pessoa();
        	pessoa.setId(rs.getInt("id"));
        	pessoa.setNome(rs.getString("nome"));
        	pessoa.setCivil(rs.getString("civil"));
        	pessoa.setSexo(rs.getString("sexo"));
        }
    } catch(Exception e ) {
        System.out.println(e);
    }

    return pessoa;
}

public static int updatePessoa(Pessoa p) {
    int status = 0;

    try {
        Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE pessoa SET nome=?, civil=?, sexo=? WHERE id=?");
        ps.setString(1, p.getNome());
        ps.setString(2, p.getCivil());
        ps.setString(3, p.getSexo());
        ps.setInt(4, p.getId());
        status = ps.executeUpdate();
    } catch(Exception e) {
        System.out.println(e);
    }
    return status;
}

public static List<Pessoa> getAllPessoas(){
	List<Pessoa> list = new ArrayList<Pessoa>();
	
	try {
		Connection con = getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM pessoa");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Pessoa pessoa = new Pessoa();
			pessoa.setId(rs.getInt("id"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setCivil(rs.getString("civil"));
			pessoa.setSexo(rs.getString("sexo"));
			
			list.add(pessoa);
		}
	}catch(Exception e) {
		System.out.println(e);
	}
	
	return list;
}
}
