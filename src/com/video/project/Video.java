package com.video.project;

import java.time.*;
import java.util.List;

public class Video {

	// Atributs
	private String user;
	private String url;
	private String title;
	private List<String> tags;
	private LocalDateTime uploadDateTime;
	
	// Constructor
	public Video(String user, String url, String title, List<String> tags) throws Exception{
		if(user.equals("") || url.equals("") || title.equals("")) throw new Exception();
		if(tags.size() == 0) throw new Exception();
		
		this.user = user;
		this.url = url;
		this.title = title;
		this.tags = tags;
		uploadDateTime = LocalDateTime.now();
	}

	// Retorna l'usuari que ha creat el video
	public String getUser() {
		return user;
	}
	
	// Retorna la url del video
	public String getUrl() {
		return url;
	}
	
	// Retorna l'estat del video
	public String uploadStatus() {
		String uploadStatus;
		// Calcula la diferencia de temps entre el moment actual i el de pujada del video
		Duration duration = Duration.between(uploadDateTime, LocalDateTime.now());
		// Si la diferència és menor a un minut retorna Uploading
		if(duration.compareTo(Duration.parse("PT1M")) == -1) {
			uploadStatus = "Uploading";
		// Si la diferència és entre un i tres minuts retorna Verifying
		}else if(duration.compareTo(Duration.parse("PT3M")) == -1) {
			uploadStatus = "Verifying";
		// Si la diferència és major a tres minuts retorna Public
		}else {
			uploadStatus = "Public";
		}
		return uploadStatus;
	}
	
	// Retorna l'informació del video
	public String videoInfo() {
		String videoInfo = "Títol: " + title + "\nTags: " + tags.toString() +  "\nData de pujada: " + uploadDateTime.toLocalDate() + "\nEstat del video: " + uploadStatus();
		return videoInfo;
	}
}
