package com.video.project;

import java.util.ArrayList;
import java.util.List;


public class UserRepository {

	// Instanciar una llista 
	private static List<User> members=new ArrayList<>();
		
	// Constructor
	public UserRepository(){
			
	}
		
	// Retorna una llista amb tots els usuaris
	public List<User> getAllMembers(){
		return new ArrayList<>(members);
	}
		
	// Afegeix un usuari a la llista
	public void addMember(User member) throws Exception{
		if(member==null) throw new Exception();
		members.add(member);
	}
		
		
}