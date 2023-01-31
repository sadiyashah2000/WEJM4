package com.java.MultiplayerJdbc.Songs;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class playSong {
	private static Connection connection;
	private static FileReader fileReader;
	private static Properties properties;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultset;
	private static String filepath = "C:\\Advance Java\\MultiplayerJDBC\\resources\\songdata_info.properties";
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		playSpecified();
	}
	
//	For Play All Songs
	public static void playAll(){
		opendbConnection();
		
		try {
			opendbConnection();

			preparedStatement = connection.prepareStatement(properties.getProperty("displaySong"));

			resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				System.out.println(resultset.getInt(1) + " " + resultset.getString(2)
				+ " is now playing");
				
				Thread.sleep(3000);
			}
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		} finally {
			closedbConnection();
		}
	}
	
	
	
//	For Repeat All Songs
	public static void repeatAll(){
		playAll();
		System.out.println("1 Repeat all songs again"
				+ "\n2 Go to Main Menu");
		
		int choice = scanner.nextInt();
		
		if (choice == 1) {
			repeatAll();
		}
		 if (choice != 2) {
			 System.out.println("Invalid Choice. "
						+ "\nPlease enter valid choice");
				repeatAll();
		}
	}
	
	
//	For Display All Songs
	public static void diplaySongs() {

		try {
			opendbConnection();

			preparedStatement = connection.prepareStatement(properties.getProperty("displaySong"));

			resultset = preparedStatement.executeQuery();

			while (resultset.next()) {

				System.out.println(resultset.getInt(1) + " " + resultset.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closedbConnection();
		}
	}
	
	
	
//	For Play Specified Song
	public static void playSpecified() {
		
		
		try {	
			diplaySongs();
			opendbConnection();
			
			preparedStatement = connection.prepareStatement(properties.getProperty("playSpecified"));
			
			System.out.println("Enter the number of song you have to play: ");
			int number = scanner.nextInt();
			preparedStatement.setInt(1, number);
			
			resultset = preparedStatement.executeQuery();
			
			while (resultset.next()) {				
				System.out.println(resultset.getInt(1) + " "
						+ resultset.getString(2) + " is now playing");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closedbConnection();
		}
	}
	
//	For Open the Database Connections
	public static void opendbConnection() {
		try {
			fileReader = new FileReader(filepath);
			properties = new Properties();
			properties.load(fileReader);

			Class.forName(properties.getProperty("driver"));
			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);
		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	
//	For Close the Database Connections
	public static void closedbConnection() {
		try {
			if (connection != null) {
				connection.close();
			}

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (resultset != null) {
				resultset.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

}
