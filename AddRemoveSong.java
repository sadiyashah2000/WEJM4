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

public class AddRemoveSong {
	private static Connection connection;
	private static FileReader fileReader;
	private static Properties properties;
	private static int result;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultset;
	private static String filepath = "C:\\Advance Java\\MultiplayerJDBC\\resources\\songdata_info.properties";
	private static Scanner scanner = new Scanner(System.in);

	
//	For Adding The Songs
	public static void addSong() {
		try {
			opendbConnection();

			preparedStatement = connection.prepareStatement(properties.getProperty("addSong"));

			System.out.println("Enter the id of song: " + "\nNOTE:- Do not repeat the same id");
			int id = scanner.nextInt();
			preparedStatement.setInt(1, id);

			System.out.println("Enter the name of song: ");
			String name = scanner.next();
			preparedStatement.setString(2, name);

			System.out.println("Enter the album / movie of song: ");
			String album = scanner.next();
			preparedStatement.setString(3, album);

			System.out.println("Enter the singer of song: ");
			String singer = scanner.next();
			preparedStatement.setString(4, singer);

			System.out.println("Enter the duration of song: ");
			int duration = scanner.nextInt();
			preparedStatement.setInt(5, duration);

			System.out.println("Enter the lyricist of song: ");
			String lyricist = scanner.next();
			preparedStatement.setString(6, lyricist);

			result = preparedStatement.executeUpdate();
			if (result != 0) {
				System.out.println("The song: " + name + "is added successfully to playlist..!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closedbConnection();
		}
	}

	
//	For Delete The Song
	public static void removeSong() {
		try {
			diplaySongs();
			opendbConnection();
			
			preparedStatement = connection.prepareStatement(properties.getProperty("deleteSong"));

			System.out.println("Enter the number of song you want to delete: ");
			int id = scanner.nextInt();
			preparedStatement.setInt(1, id);

			result = preparedStatement.executeUpdate();
			if (result != 0) {
				System.out.println("The song is removed successfully from playlist..!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closedbConnection();

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
