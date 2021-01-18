package com.video.project;

import java.util.List;

public class Video {

	// Atributs
	private String user;
	private String url;
	private String title;
	private List<String> tags;
	
	// Constructor
	public Video(String user, String url, String title, List<String> tags) throws Exception{
		if(user.equals("") || url.equals("") || title.equals("")) throw new Exception();
		if(tags.size() == 0) throw new Exception();
		
		this.user = user;
		this.url = url;
		this.title = title;
		this.tags = tags;
	}

	// Retorna l'usuari que ha creat el video
	public String getUser() {
		return user;
	}
	
	// Retorna la url del video
	public String getUrl() {
		return url;
	}
	
	// Retorna l'informació del video
	public String videoInfo() {
		String videoInfo = "Títol: " + title + "\nTags: " + tags.toString();
		return videoInfo;
	}
}
