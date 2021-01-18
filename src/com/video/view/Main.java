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

		// Men� principal
		System.out.println("Men� principal");
		boolean b;			
		int opcio;
		
		do {
			System.out.println();
			System.out.println("Tria una opci�:");
			System.out.println("1: Iniciar sessi�");
			System.out.println("2: Registrar nou usuari");
			System.out.println("3: Surt");
			
			try {
				// Comprovar que la resposta �s int
				opcio = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e){
				opcio = 0;
				b = true;
			}
				
			switch(opcio) {
			case 1:
				// Comprovar usuari
				System.out.println("Inici sessi�");
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
				// Sortir del men�
				System.out.println("Tancant programa");
				System.out.println("--------------------------------------");
				b = false;
				break;
			default:
				// Tornar al men�
				System.out.println("\nLa resposta no �s v�lida. Torna-ho a provar.");
				b = true;
				break;
			}			
			
		} while(b);

	}
	
	
	public static void menu(String user_name) {
		
		// Instanciar constructor de videos
		VideoBuilder videoBuilder = new VideoBuilder(user_name);
		
		// Men� personal
		System.out.println("Men� personal");
		System.out.println();

		boolean c;
		int option;
		
		do {
			System.out.println("Tria una opci�:");
			System.out.println("1: Crear un nou video");
			System.out.println("2: Veure els meus videos");
			System.out.println("3: Tancar sessi�");
			
			try {
				// Comprovar que la resposta �s int
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
			// Veure informaci� de tots els videos
			System.out.println("Llistat de videos:");
			videoBuilder.showVideosInfo(user_name);
			c = false;
			break;
		case 3:
			// Sortir del men� personal
			System.out.println("Tancant sessi�");
			System.out.println("--------------------------------------");
			System.out.println();
			Main.main(null);
			c = false;
			break;
		default:
			// Tornar al men� personal
			System.out.println("\nLa resposta no �s v�lida. Torna-ho a provar.");
			System.out.println("--------------------------------------");
			System.out.println();
			c = true;
			break;
		}		
			
		} while(c);
	}

}
