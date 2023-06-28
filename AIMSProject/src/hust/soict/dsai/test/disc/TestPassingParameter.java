package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.exception.DataConstraintsException;
import hust.soict.dsai.aims.media.*;

public class TestPassingParameter {

	public static void main(String[] args) throws DataConstraintsException {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Ciderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
	public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2) throws DataConstraintsException {
		DigitalVideoDisc tmp = new DigitalVideoDisc(o1.getTitle(), o1.getCategory(), o1.getDirector(), o1.getLength(), o1.getCost());
		o1.setTitle(o2.getTitle());
		o1.setCategory(o2.getCategory());
		o1.setDirector(o1.getDirector());
		o1.setLength(o1.getLength());
		o1.setCost(o1.getCost());
		o2.setTitle(tmp.getTitle());
		o2.setCategory(tmp.getCategory());
		o2.setDirector(tmp.getDirector());
		o2.setLength(tmp.getLength());
		o2.setCost(tmp.getCost());
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) throws DataConstraintsException {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}

}
