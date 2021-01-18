package com.video.project;

import java.util.List;
import java.util.Scanner;

import com.video.view.Main;

import java.util.ArrayList;


public class UserBuilder {
	
	// Instanciar el repositori d'usuaris
	private UserRepository uRepository = new UserRepository();
	
	// Constructor
	public UserBuilder() {
		
	}
	
	// Crea un nou usuari i l'afegeix al repositori
	public void addUser(String user, String first_name, String last_name, String password) {
		
		try {
			User newUser = new User(user, first_name, last_name, password);
			uRepository.addMember(newUser);
		}catch(Exception e) {
			System.out.println("Algun dels camps està en blanc. Torna-ho a provar.");
			Main.main(null);
		}
	}
	
	// Demana la informació, crea un nou usuari, l'afegeix al repositori i va al menú personal
	public void createUser(Scanner scanner) {
		
		String newUser;
		// Demanar informació
		do {
			System.out.println("Introdueix el nom d'usuari:");
			newUser = scanner.nextLine();
			
			if(getAllUsers().contains(newUser)) {
				System.out.println("El nom d'usuari ja està agafat. Torna-ho a provar.");
			}
		} while(getAllUsers().contains(newUser));
		
		System.out.println("Introdueix el teu nom:");
		String newFirstName = scanner.nextLine();

		System.out.println("Introdueix el teu primer cognom:");
		String newLastName = scanner.nextLine();
		
		System.out.println("Introdueix la contrasenya:");
		String password1 = scanner.nextLine();
		
		System.out.println("Torna a introduir la contrasenya:");
		String password2 = scanner.nextLine();
		
		String newPassword = "";
		
		try {
			// Comprovar que els dos passwords coincideixen
			newPassword = confirmPassword(password1, password2);
			// Crear nou usuari i afegir-lo al repositori
			User new_member = new User(newUser, newFirstName, newLastName, newPassword);
			uRepository.addMember(new_member);
			
			System.out.println();
			System.out.println("Usuari creat. Benvingut " + new_member.fullName() + "!");
			System.out.println("--------------------------------------");
			System.out.println();
			// Anar al menú personal
			Main.menu(newUser);
			
		} catch(Exception e) {
			System.out.println("Heu introduit malament la contrasenya.");
			System.out.println("--------------------------------------");
			System.out.println();
			// Tornar al menú principal
			Main.main(null);
		}
				
	}
	
	// Comprova l'usuari i la contrasenya i va al menú personal
	public void checkUser(Scanner scanner) {
		
		//Demanar usuari i contrasenya		
		System.out.println("Introdueix el nom d'usuari:");
		String user = scanner.nextLine();
		
		System.out.println("Introdueix la contrasenya:");
		String password = scanner.nextLine();
		
		try {
			// Comprovar que l'usuari existeix i que la contrasenya és correcta
			checkPassword(user, password);
			System.out.println("Sessió iniciada");
			System.out.println("---------------------------------");
			System.out.println();
			// Anar al menú personal
			Main.menu(user);
			
		} catch(Exception e) {
			System.out.println("Usuari o contrasenya incorrectes.");
			System.out.println("---------------------------------");
			System.out.println();
			// Anar al menú principal
			Main.main(null);
		}
		
	}
	
	// Comprova que l'usuari existeix i que la contrasenya és correcta
	private void checkPassword(String user, String password) throws Exception {
		// L'usuari no pot estar buit
		if(user.equals("")) throw new Exception();
		// Comprova que l'usuari està al repositori
		if(!getAllUsers().contains(user)) throw new Exception();
		
		List<User> allMembers = uRepository.getAllMembers();
		String correctPassword = "";
		// Extreu la contrasenya de l'usuari
		for(User u:allMembers) {
			if(u.getUser().equals(user)) {
				correctPassword = u.getPassword();
			}
		}
		// Comprova que les contrasenyes son iguals
		if(!password.equals(correctPassword)) throw new Exception();
	}
	
	// Retorna la contrasenya si s'ha introduit correctament
	private String confirmPassword(String password1, String password2) throws Exception{
		if(!password1.equals(password2)) throw new Exception();
		return password1;
	}
	
	// Retorna una llista amb tots els usuaris del repositori
	private List<String> getAllUsers(){
		List<User> allMembers = uRepository.getAllMembers();
		List<String> allUsers = new ArrayList<>();
		for(User u:allMembers) {
			allUsers.add(u.getUser());
		}
		return allUsers;
	}
	
}
