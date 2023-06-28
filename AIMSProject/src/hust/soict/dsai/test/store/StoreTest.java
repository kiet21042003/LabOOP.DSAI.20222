package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.store.*;
import hust.soict.dsai.aims.exception.DataConstraintsException;
import hust.soict.dsai.aims.media.*;

public class StoreTest {

	public static void main(String[] args) throws DataConstraintsException {
		// TODO Auto-generated method stub
		//Create a new store
		Store myStore = new Store();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		myStore.addMedia(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		myStore.addMedia(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		myStore.addMedia(dvd3);
		
		//Remove dvd objects from the current cart
		myStore.removeMedia(dvd1);

		myStore.removeMedia(dvd3);	
	}

}
