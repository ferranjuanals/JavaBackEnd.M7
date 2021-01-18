package com.video.project;

import java.time.LocalDate;

public class User {
	
	// Atributs
	private String user;
	private String first_name;
	private String last_name;
	private String password;
	private LocalDate registration_date;
	
	// Constructor
	public User(String user, String first_name, String last_name, String password) throws Exception {
		// Els camps no poden estar buits
		if(user.equals("") ||first_name.equals("") || last_name.equals("") || password.equals("")) throw new Exception();
		
		this.user = user;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		registration_date = LocalDate.now();
	}
	
	// Retorna el nom d'usuari
	public String getUser() {
		return user;
	}
	
	// Retorna el password
	public String getPassword() {
		return password;
	}
	
	// Retorna el nom complert
	public String fullName() {
		String full_name = first_name + " " + last_name;
		return full_name;
	}
	
	// Retorna la informació de l'usuari
	public String userInfo() {
		String user_info = "Nom: " + fullName() + "\nData de registre: " + registration_date;
		return user_info;
	}
}
