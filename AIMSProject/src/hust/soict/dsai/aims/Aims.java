package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.exception.DataConstraintsException;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.*; 
import hust.soict.dsai.aims.screen.*;

import java.util.*;

public class Aims {

	private static Cart cart = new Cart();
	private static Store store = new Store();
	private static Scanner input = new Scanner(System.in);
	
	public static void showMenu() throws LimitExceededException, PlayerException, DataConstraintsException {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See the current cart");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		
		int n = input.nextInt();
		input.nextLine();
		if(n == 1) {
			storeMenu();
		}
		else if (n == 2) {
			updateStore();
		}
		else if (n == 3) {
			cartMenu();
		}
		else if (n == 0) {
			System.out.println("Successfully Exit");
		}
		else {
			System.out.println("Error!");
			showMenu();
		}
	}
	
	public static void storeMenu() throws LimitExceededException, PlayerException, DataConstraintsException {
		store.print();
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		
		int n = input.nextInt();
		input.nextLine();
		if (n == 1) {
			storeMenu1();
		}
		else if (n == 2) {
			storeMenu2();
		}
		else if (n == 3) {
			storeMenu3();
		}
		else if (n == 4) {
			cartMenu();
		}
		else if (n == 0) {
			showMenu();
		}
		else {
			System.out.println("Error!");
			showMenu();
		}
	}
	public static void updateStore() throws DataConstraintsException, LimitExceededException, PlayerException {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add media");
		System.out.println("2. Remove media");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		int n = input.nextInt();
		input.nextLine();
		if(n == 1) {
			updateStore1();
		}
		else if(n == 2) {
			updateStore2();
		}
		else if (n == 0) {
			System.out.println("Successfully Exit");
			showMenu();
		}
		else {
			System.out.println("Error!");
			showMenu();
		}
	}
	public static void updateStore1() throws DataConstraintsException, LimitExceededException, PlayerException {
		System.out.print("Enter title of the media: ");
		String title = input.nextLine();
		System.out.print("Enter category of the media: ");
		String category = input.nextLine();
		System.out.print("Enter cost of the media: ");
		float cost = input.nextFloat();
		input.nextLine();
		
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. DigitalVideoDisc");
		System.out.println("2. CompactDisc");
		System.out.println("3. Book");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		
		int n = input.nextInt();
		if (n == 1) {
			store.addMedia(new DigitalVideoDisc(title, category, cost));
			updateStore();
		}
		else if (n == 2) {
			store.addMedia(new CompactDisc(title, category, cost));
			updateStore();
		}
		else if (n == 3) {
			store.addMedia(new Book(title, category, cost));
			updateStore();
		}
		else if (n == 0) {
			System.out.println("Successfully Exit");
			updateStore();
		}
		else {
			System.out.println("Error!");
			showMenu();
		}
	}
	public static void updateStore2() throws DataConstraintsException, LimitExceededException, PlayerException {
		System.out.print("Enter the title of the media:");
		String title = input.nextLine();
		store.removeMedia(new DigitalVideoDisc(title));
		updateStore();
	}
	
	public static void storeMenu1() throws LimitExceededException, PlayerException, DataConstraintsException {
		System.out.println("Enter the title of the media");
		String title = input.nextLine();
		for(Media media: store.getItemsInStore()) {
			if(media.getTitle().equals(title)) {
				media.toString();
				mediaDetailsMenu(media);
				return ;
			}
		}
		System.out.println("Media not found");
		storeMenu();
	}
	public static void mediaDetailsMenu(Media media) throws LimitExceededException, PlayerException, DataConstraintsException {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		
		int n = input.nextInt();
		input.nextLine();
		if (n == 1) {
			cart.addMedia(media);
			storeMenu();
		}
		else if (n == 2) {
			if (media instanceof DigitalVideoDisc) {
				DigitalVideoDisc dvd = (DigitalVideoDisc) media;
				dvd.play();
			}
			else if (media instanceof CompactDisc) {
				CompactDisc cd = (CompactDisc) media;
				cd.play();
			}
			else if (media instanceof Book) {
				System.out.println("Can't be played");
			}
			System.out.println("Do you want to add to cart?");
			System.out.println("1. Yes");
			System.out.println("0. No");
			int opt = input.nextInt();
			input.nextLine();
			if(opt == 1) {
				cart.addMedia(media);
				storeMenu();
			}
			else if(opt == 0) {
				storeMenu();
			}
			else {
				System.out.println("Error!");
				showMenu();
			}
		}
		else if (n == 0) {
			storeMenu();
		}
		else {
			System.out.println("Error!");
			showMenu();
		}
	}
	
	public static void storeMenu2() throws LimitExceededException, PlayerException, DataConstraintsException {
		System.out.print("Enter the title of the media: ");
		String title = input.nextLine();
		for(Media media: store.getItemsInStore()) {
			if(media.getTitle().equals(title)) {
				cart.addMedia(media);
				storeMenu();
				return ;
			}
		}
		System.out.println("Media not found");
		storeMenu();
	}
	public static void storeMenu3() throws PlayerException, LimitExceededException, DataConstraintsException {
		System.out.print("Enter the title of the media: ");
		String title = input.nextLine();
		for(Media media: store.getItemsInStore()) {
			if(media.getTitle().equals(title)) {
				if (media instanceof DigitalVideoDisc) {
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					dvd.play();
				}
				else if (media instanceof CompactDisc) {
					CompactDisc cd = (CompactDisc) media;
					cd.play();
				}
				else if (media instanceof Book) {
					System.out.println("Can't be played");
				}
				storeMenu();
				return ;
			}
		}
		System.out.println("Media not found");
		storeMenu();
	}
	
	public static void cartMenu() throws DataConstraintsException, PlayerException, LimitExceededException {
		cart.print();
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		int n = input.nextInt();
		input.nextLine();
		if (n == 1) {
			cartMenu1();
		}
		else if (n == 2) {
			cartMenu2();
		}
		else if (n == 3) {
			cartMenu3();
		}
		else if (n == 4) {
			cartMenu4();
		}
		else if (n == 5) {
			System.out.println("The order has been created");
			cart.getItemsOrdered().clear();
			cart.print();
		}
		else if (n == 0) {
			showMenu();
		}
		else {
			System.out.println("Error!");
			showMenu();
		}
	}
	
	public static void cartMenu1() throws DataConstraintsException, PlayerException, LimitExceededException {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter by id");
		System.out.println("2. Filter by title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		int n = input.nextInt();
		input.nextLine();
		if(n == 1) {
			System.out.print("Enter id: ");
			int id = input.nextInt();
			input.nextLine();
			cart.search(id);
			cartMenu();
		}
		else if(n == 2) {
			System.out.print("Enter title: ");
			String title = input.nextLine();
			cart.search(title);
			cartMenu();
		}
		else if(n == 0) {
			cartMenu();
		}
		else {
			System.out.println("Error!");
			cartMenu();
		}
	}
	public static void cartMenu2() throws DataConstraintsException, PlayerException, LimitExceededException {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		int n = input.nextInt();
		input.nextLine();
		if (n == 1) {
			Collections.sort(cart.getItemsOrdered(),Media.COMPARE_BY_TITLE_COST);
			cart.print();
			cartMenu();
		}
		if (n == 2) {
			Collections.sort(cart.getItemsOrdered(),Media.COMPARE_BY_TITLE_COST);
			cart.print();
			cartMenu();
		}
		if (n == 0) {
			cartMenu();
		}
		else {
			System.out.println("Error!");
			cartMenu();
		}
	}
	public static void cartMenu3() throws DataConstraintsException, PlayerException, LimitExceededException {
		System.out.print("Enter the title of the media to remove: ");
		String title = input.nextLine();
		cart.removeMedia(new DigitalVideoDisc(title));
		cartMenu();
	}
	public static void cartMenu4() throws PlayerException, DataConstraintsException, LimitExceededException {
		System.out.print("Enter the title of the media to play: ");
		String title = input.nextLine();
		for (Media media: store.getItemsInStore()) {
			if (media.getTitle().equals(title)) {
				if (media instanceof CompactDisc){
					CompactDisc cd = (CompactDisc) media;
					cd.play();
					cartMenu();
					return;
				} else if (media instanceof DigitalVideoDisc){
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					dvd.play();
					cartMenu();
					return;
				} else if (media instanceof Book) {
					System.out.println("Can't be played");
					cartMenu();
					return ;
				}
			}
		}
		System.out.println("Media does not exist!");
		cartMenu();
	}
	
	public static void main(String[] args) throws DataConstraintsException, LimitExceededException, PlayerException {
		
		DigitalVideoDisc dvd = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 90, 2.5f);
		CompactDisc cd = new CompactDisc("Forrest Gump", "Drama", "Robert Zemeckis", 60, "Winston Groom", 3);
		Track track1 = new Track("Shape Of You", 3);
		Track track2 = new Track("My Heart Will Go On", -2);
		cd.addTrack(track1);
		cd.addTrack(track2);
		Book book = new Book("Sherlock Holmes", "Thriller", 10);
		
		Store mystore = new Store();
		mystore.addMedia(dvd);
		mystore.addMedia(cd);
		mystore.addMedia(book);
//		for (int i = 0; i < 12; i++) {
//			mystore.addMedia(new DigitalVideoDisc(UUID.randomUUID().toString(), UUID.randomUUID().toString(), new Random().nextInt(1000)));	
//		}
		
		new StoreScreen(mystore);
	}
}
