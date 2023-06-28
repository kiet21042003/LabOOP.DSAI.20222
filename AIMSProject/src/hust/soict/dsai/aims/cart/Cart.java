package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Cart {
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	private static int MAX_NUMBER_ORDERED = 20;
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void setItemsOrdered(ObservableList<Media> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}

	public void addMedia(Media disc) throws LimitExceededException{
		if (itemsOrdered.size() < MAX_NUMBER_ORDERED) {
			if (itemsOrdered.contains(disc)) {
				System.out.println("The disc's already there");
				return;
			}
			itemsOrdered.add(disc);
			System.out.println("Successfully added");
		}
		else {
			throw new LimitExceededException("ERROR: the number of media has reached its limit");
		}
	}
	
	public void addMedia(Media[] dvdList) {
		for (Media d: dvdList) {
			if (!itemsOrdered.contains(d)) {
				itemsOrdered.add(d);				
			}
		}
		System.out.println("Successfully added");
	}
	
	public void addMedia(Media dvd1, Media dvd2) throws LimitExceededException{
		addMedia(dvd1);
		addMedia(dvd2);
	}
	
	public void removeMedia(Media disc) {
		if (itemsOrdered.contains(disc)) {
			itemsOrdered.remove(disc);			
			System.out.println("Successfully removed");
			return;
		}
		System.out.println("Disc not found.");
	}
	
	public double totalCost() {
		double ret = 0;
		for (Media d: itemsOrdered) {
			ret += d.getCost();
		}
		return ret;
	}
	
	public void print() {
		System.out.println("***********************CART***********************\n" + "Ordered Items:");
		int i = 0;
		for (Media d: itemsOrdered) {
			System.out.println(String.format("%d. %s", ++i, d));
		}
		System.out.println(String.format("Total cost: %.2f\n***************************************************",
										 this.totalCost()));
	}
	
	public boolean search(int ID) {
		for (Media d: itemsOrdered) {
			if (d == null) {break;}
			if (d.getId() ==  ID) {
				System.out.println(d);
				return true;
			}
		}
		System.out.println("No match is found.");
		return false;		
	}
	
	public boolean search(String title) {
		for (Media d: itemsOrdered) {
			if (d == null) {break;}
			if (d.getTitle() ==  title) {
				System.out.println(d);
				return true;
			}
		}
		System.out.println("No match is found.");
		return false;
	}
}
