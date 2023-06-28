package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, 0, cost);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, null, 0, cost);
	}
	public DigitalVideoDisc(String title) {
		super(title, null, null, 0, 0.0f);
	}
	
	public void play() {
		System.out.println("p");
	}
	
	public String toString() {
		return String.format("DVD - %s - %s - %s - %d: %.2f$", this.getTitle(), this.getCategory(), 
							  this.getDirector(), this.getLength(), this.getCost());
	}
}