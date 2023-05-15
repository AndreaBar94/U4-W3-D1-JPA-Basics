package application;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class main {
	static Connection conn = null;
	
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/dbIntro?useSSL=false";
		String username = "postgres";
		String password = "1234";
		
		try {
			System.out.println("Connecting to PG...");

			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connected ✅");
		} catch (Exception e) {
			System.out.println(e.getMessage());		}
		
		insertStudent("Mario", "Rossi", "M", 5, 1, 10);
		insertStudent("Maria", "Verdi", "F", 5, 1, 10);
		insertStudent("Pippo", "Bianco", "M", 5, 1, 10);
	}
	
	public static void insertStudent(String name, String lastname, String gender, int avg, int min_vote, int max_vote) {
		String sqlInsert = "INSERT INTO school_students (name ,lastname, gender, avg, min_vote, max_vote) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sqlInsert);
			stmt.setString(1, name);
			stmt.setString(2, lastname);
			stmt.setString(3, gender);
			stmt.setInt(4, avg);
			stmt.setInt(5, min_vote);
			stmt.setInt(6, max_vote);
			stmt.execute();
			System.out.println("Studente inserito!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateStudent(int id, HashMap<String, Object> s) {
		
	}
}
