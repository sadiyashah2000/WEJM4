package com.java.MultiplayerJdbc.Songs;

import java.util.Scanner;

public class SongMain {
	private static boolean loop = true;
	private static int choice;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		musicPlayer();

	}

	private static void musicPlayer() {

		while (loop) {
			System.out.println("==========MENU==========");
			System.out.println("1. Add/Remove Song\n" + "2. Play Song\n" + "3. Edit Song\n" + "4. Exit");

			choice = scanner.nextInt();

			switch (choice) {

			case 1:
				System.out.println("==========MENU==========");
				System.out.println("1. Add a Song\n" + "2. Remove a song\n" + "3. Go Back");

				choice = scanner.nextInt();

				switch (choice) {
				case 1:
					AddRemoveSong.addSong();
					break;

				case 2:
					AddRemoveSong.removeSong();
					break;

				case 3:
					musicPlayer();
					break;

				default:
					System.out.println("Invalid choice. Try again...!!!");
					break;
				}

				break;

			case 2:
				System.out.println("==========MENU==========");
				System.out.println("1. Play all songs\n" + "2. Repeat all songs\n"
						+ "3. Select a song\n" + "4. Go Back");

				choice = scanner.nextInt();

				switch (choice) {
				case 1:
					playSong.playAll();
					break;

				case 2:
					playSong.repeatAll();
					break;

				case 3:
					playSong.playSpecified();
					break;
					
				case 4:
					musicPlayer();
					break;

				default:
					System.out.println("Invalid choice. Try again...!!!");
					break;
				}

				break;

			case 3:

				break;

			case 4:
				System.out.println("Thank you...!!!");
				loop = false;
				break;

			default:
				System.out.println("Invalid choice. Try again...!!!");
				break;
			}
		}
	}

}
