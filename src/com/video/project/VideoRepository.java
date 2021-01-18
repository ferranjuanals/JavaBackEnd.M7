package com.video.project;

import java.util.ArrayList;
import java.util.List;

public class VideoRepository {

	// Instanciar una llista
	private static List<Video> videos = new ArrayList<>();
	
	// Constructor
	public VideoRepository() {
		
	}
	
	// Retorna una llista amb tots els videos
	public List<Video> getAllVideos() {
		return new ArrayList<>(videos);
	}
	
	// Afegeix un video al repositori
	public void addVideo(Video video) throws Exception {
		if(video == null) throw new Exception();
		videos.add(video);
	}
}
