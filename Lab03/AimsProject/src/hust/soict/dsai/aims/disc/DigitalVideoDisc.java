package hust.soict.dsai.aims.disc;
public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;

    private static int nbDigitalVideoDiscs = 0;
    public int id = 0;
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}

    public void setTitle(String title) {
        this.title = title;
    }

	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
	}

    public boolean equal(DigitalVideoDisc disc) {
        if ((category == disc.getCategory())
        && (director == disc.getDirector()) && (length == disc.getLength())
        && (title == disc.getTitle())) {
            return true;
         } else {
        return false;
        }
    }
}
