package com.video.view;

import java.util.Scanner;

import com.video.project.UserBuilder;
import com.video.project.VideoBuilder;

public class Main {

	// Crear Scanner
	static Scanner scanner = new Scanner(System.in);

	
	public static void main(String[] args) {
		
		// Instanciar constructor d'usuaris
		UserBuilder userBuilder = new UserBuilder();

		// Menú principal
		System.out.println("Menú principal");
		boolean b;			
		int opcio;
		
		do {
			System.out.println();
			System.out.println("Tria una opció:");
			System.out.println("1: Iniciar sessió");
			System.out.println("2: Registrar nou usuari");
			System.out.println("3: Surt");
			
			try {
				// Comprovar que la resposta és int
				opcio = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e){
				opcio = 0;
				b = true;
			}
				
			switch(opcio) {
			case 1:
				// Comprovar usuari
				System.out.println("Inici sessió");
				userBuilder.checkUser(scanner);
				b = false;
				break;
			case 2:
				// Registrar usuari
				System.out.println("Nou registre");
				userBuilder.createUser(scanner);
				b = false;
				break;
			case 3:
				// Sortir del menú
				System.out.println("Tancant programa");
				System.out.println("--------------------------------------");
				b = false;
				break;
			default:
				// Tornar al menú
				System.out.println("\nLa resposta no és vàlida. Torna-ho a provar.");
				b = true;
				break;
			}			
			
		} while(b);

	}
	
	
	public static void menu(String user_name) {
		
		// Instanciar constructor de videos
		VideoBuilder videoBuilder = new VideoBuilder(user_name);
		
		// Menú personal
		System.out.println("Menú personal");
		System.out.println();

		boolean c;
		int option;
		
		do {
			System.out.println("Tria una opció:");
			System.out.println("1: Crear un nou video");
			System.out.println("2: Veure els meus videos");
			System.out.println("3: Tancar sessió");
			
			try {
				// Comprovar que la resposta és int
				option = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e){
				option = 0;
				c = true;
			}
			
		switch(option) {
		case 1:
			// Crear nou video
			System.out.println("Crear video");
			videoBuilder.createVideo(user_name, scanner);
			c = false;
			break;
		case 2:
			// Veure informació de tots els videos
			System.out.println("Llistat de videos:");
			videoBuilder.showVideosInfo(user_name);
			c = false;
			break;
		case 3:
			// Sortir del menú personal
			System.out.println("Tancant sessió");
			System.out.println("--------------------------------------");
			System.out.println();
			Main.main(null);
			c = false;
			break;
		default:
			// Tornar al menú personal
			System.out.println("\nLa resposta no és vàlida. Torna-ho a provar.");
			System.out.println("--------------------------------------");
			System.out.println();
			c = true;
			break;
		}		
			
		} while(c);
	}

}
