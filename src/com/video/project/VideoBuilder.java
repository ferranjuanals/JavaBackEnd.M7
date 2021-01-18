package com.video.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.video.view.Main;

public class VideoBuilder {

	// Instanciar el repositori de videos
	private VideoRepository vRepository = new VideoRepository();
	//private String user;
	
	// Constructor
	public VideoBuilder(String user) {
		//this.user = user;
	}
	
	// Demana la informació, crea un nou video i l'afegeix al repositori
	public void createVideo(String user, Scanner scanner) {
				
		String newUrl;
		// Demanar informació
		do {
			System.out.println("Introdueix la url del nou video:");
			newUrl = scanner.nextLine();
			// Comprovar si el video ja s'havia creat
			if(getAllUrls().contains(newUrl)) {
				System.out.println("El video que intenteu pujar ja està creat");
			}
		} while(getAllUrls().contains(newUrl));
		
		System.out.println("Introdueix el titol del nou video:");
		String newTitle = scanner.nextLine();
		
		List<String> newTags = new ArrayList<>();
		
		do {
			System.out.println("Introdueix les etiquetes del video separades per una coma:");
			String inputTags = scanner.nextLine();
			// Comprovar que almenys s'ha introduit una etiqueta i guardar-les a una llista
			if(inputTags.equals("")) {
				System.out.println("Heu d'introduir almenys una etiqueta.");
			} else {
				newTags = Arrays.asList(inputTags.split(","));
			}
		} while(newTags.isEmpty());
		
		try {
			// Crear nou video i guardar-lo al repositori
			Video newVideo = new Video(user, newUrl, newTitle, newTags);
			vRepository.addVideo(newVideo);
			System.out.println("Video creat");
			System.out.println("--------------------------------------");
			System.out.println();
			// Tornar al menú personal
			Main.menu(user);
		} catch(Exception e) {
			System.out.println("Heu introduït algun camp malament. Torneu-ho a provar");
			System.out.println("--------------------------------------");
			System.out.println();
			// Tornar al menú personal
			Main.menu(user);
		}
			
		
	}
	
	// Imprimeix un llistat de tots el videos de l'usuari
	public void showVideosInfo(String user) {
		List <Video> allVideos = vRepository.getAllVideos();
		int i = 1;
		for(Video v:allVideos) {
			// Selecciona només els videos de l'usuari
			if(v.getUser().equals(user)) {
				System.out.print(i + ".");
				System.out.println(v.videoInfo());
				i++;
			}			
		}
		System.out.println("--------------------------------------");
		System.out.println();
		Main.menu(user);
	}
	
	// Retorna una llista amb totes les urls del repositori
	private List<String> getAllUrls() {
		List<Video> allVideos = vRepository.getAllVideos();
		List<String> allUrls = new ArrayList<>();
		for(Video v:allVideos) {
			allUrls.add(v.getUrl());
		}
		return allUrls;
	}
	
}
