package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Utilisateur;

public class base {
	 private Connection connexion;
	 
	 public void loaddatabase (){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e){	
		}
		try{
			connexion=DriverManager.getConnection("jdbc:mysql://localhost/mapfe","root","");
			System.out.println("cc");
		}catch(SQLException e){
			System.out.println("vg");
			e.printStackTrace();
		}
	}
	 
	 public void ajoututilisateur(Utilisateur utilisateur){
			loaddatabase();
			try {
				
				PreparedStatement prepare=connexion.prepareStatement("INSERT INTO noms(nom,prenom) VALUES(?,?)");
				prepare.setString(1, utilisateur.getNom());
				prepare.setString(2, utilisateur.getPrenom());
				prepare.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	
}
