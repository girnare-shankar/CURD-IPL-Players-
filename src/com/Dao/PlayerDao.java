package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.entity.Player;

public class PlayerDao {

	List<Player> allplayerlist = new ArrayList<Player>();

	String path = "com.mysql.cj.jdbc.Driver";

	String url = "jdbc:mysql://localhost:3306/iplteams";
	String uname = "root";
	String pwd = "shiv";

	Connection con = null;
	Statement stmt = null;
	ResultSet eq = null;

	String query = "SELECT * FROM iplteams.players";

//	String insertquery = "INSERT INTO iplteams.players VALUES (33, 'Shiv Patil', 250, 5, 'MI')";

	public List<Player> getAllPlayer() { // GET ALL PLAYERS DATA USING THIS METHOD

		try {
			Class.forName(path);
//			System.out.println(1);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(url, uname, pwd);
//			System.out.println(2);

			stmt = con.createStatement();
//			System.out.println(3);

			eq = stmt.executeQuery(query);
//			System.out.println(4);

			while (eq.next()) {
				int jcnum = eq.getInt("jcnum");
				String pname = eq.getString("name");
				int runs = eq.getInt("runs");
				int wicket = eq.getInt("wickets");
				String tname = eq.getString("tname");

				Player p1 = new Player(jcnum, pname, runs, wicket, tname);
				allplayerlist.add(p1);

//				System.out.printf("Player jc num: %s, Player name: %s, Player Runs: %s, Player Wickets: %s, Player Team: %s\n",jcnum, pname, runs,wicket,tname);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return allplayerlist;
	}

	public void insertPlayerData() { // INSERT PLAYER DATA USING THIS METHOD

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter jeresey Num: ");
		int jcnum = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Player Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Total Runs: ");
		int runs = sc.nextInt();

		System.out.print("Enter Total Wickets: ");
		int wickets = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter Team Name: ");

		String tname = sc.nextLine();

		String insertquery = String.format(
				"INSERT INTO Players (jcnum, name, runs, wickets, tname) VALUES ('%d','%s', %d, %d, '%s')", jcnum, name,
				runs, wickets, tname);

		try

		{
			Class.forName(path);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(url, uname, pwd);

			stmt = con.createStatement();
			int ack = stmt.executeUpdate(insertquery);

			if (ack == 1) {
				System.out.println("Data Insert Successfully");
			} else {
				System.out.println("Something went wrong");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} 
		sc.close();
	}

	public void updatePlayer() { // Update data from player table...

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Jersey Number of the player to update: ");
		int jcnum = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter new Player Name: ");
		String name = sc.nextLine();

		System.out.print("Enter new Total Runs: ");
		int runs = sc.nextInt();

		System.out.print("Enter new Total Wickets: ");
		int wickets = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter new Team Name: ");
		String tname = sc.nextLine();

		String updateQuery = String.format(
				"UPDATE Players SET name = '%s', runs = %d, wickets = %d, tname = '%s' WHERE jcnum = %d", name, runs,
				wickets, tname, jcnum);

		try {
			Class.forName(path);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

		try {
			con = DriverManager.getConnection(url, uname, pwd);
			stmt = con.createStatement();
			int ack = stmt.executeUpdate(updateQuery);

			if (ack == 1) {
				System.out.println("Data Updated Successfully");
			} else {
				System.out.println("No player found with the specified jersey number");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}

	public void deletePlayerData() { // Delete data from player table...

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Jersey Number of the player to delete: ");
		int jcnum = sc.nextInt();
		sc.nextLine();

		String deleteQuery = String.format("DELETE FROM Players WHERE jcnum = %d", jcnum);

		try {
			Class.forName(path);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		}

		try {
			con = DriverManager.getConnection(url, uname, pwd);
			stmt = con.createStatement();
			int ack = stmt.executeUpdate(deleteQuery);

			if (ack == 1) {
				System.out.println("Data Deleted Successfully");
			} else {
				System.out.println("No player found with the specified jersey number");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
