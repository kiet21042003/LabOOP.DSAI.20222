package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.DataConstraintsException;
import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(String title, String category, String director, int length, String artist, float cost) throws DataConstraintsException {
		super(title, category, director, length, cost);
		this.artist = artist;
	}
	
	public CompactDisc(String title, String category, float cost) throws DataConstraintsException {
		super(title, category, null, 0, 0.0f);
	}
	
	public ArrayList<Track> getTracks() {
		return tracks;
	}

	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}

	public void addTrack(Track aTrack) {
		if (tracks.contains(aTrack)) {
			System.out.println("The track's already there.");
			return;
		}
		tracks.add(aTrack);
		System.out.println("Successfully added");
	}
	
	public void removeTrack(Track aTrack) {
		if (tracks.contains(aTrack)) {
			tracks.remove(aTrack);
			System.out.println("Successfully removed");
			return;		
		}
		System.out.println("Track not found");
	}
	
	public int getLength() {
		int sum = 0;
		for (Track t: tracks) {
			sum += t.getLength();
		}
		return sum;
	}
	
	public void play() throws PlayerException {
		System.out.println(String.format("CD %s from artist %s\nThis CD contains %dtracks",
										  this.getTitle(), this.artist, this.tracks.size()));
		if (this.getLength() > 0) {
			for (Track t: tracks) {
				try {
					t.play();
				} catch (PlayerException e) {
					throw e;
				}
			}
		}
		else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
	}
	
	public String toString() {
		return String.format("CD - %s - %s - %s - %d: %.2f$", this.getTitle(), this.getCategory(),
							  this.getDirector(), this.getLength(), this.getCost());
	}
}
