package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.*;

import javafx.fxml.FXML;

import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;

import javafx.event.ActionEvent;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar.ButtonData;

import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.*;

import javafx.scene.control.MenuBar;
import javafx.scene.control.Label;
import javafx.scene.control.Dialog;
import javafx.scene.control.MenuItem;

import java.awt.Window;

public class CartScreenController {

	private Store store;
	private Cart cart;
	
	private Window window;
	
	@FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
	@FXML
	private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediaTitle;
	
	@FXML
	private TableColumn<Media, String> colMediacategory;
	
	@FXML
	private TableColumn<Media, Float> colMediaCost;
	
	public CartScreenController (Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}
	
	@FXML
	private MenuBar menuBar;
	
	@FXML
	private Label totalCost;
	
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(
				new PropertyValueFactory<Media, String>("title"));
		colMediacategory.setCellValueFactory(
				new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(
				new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {
					
					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue,
							Media newValue) {
						if(newValue != null) {
							updateButtonBar(newValue);
						}
					}
				}
			);
		totalCost.setText(cart.totalCost()+"$");
	}
	
	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
		}
	}
	
	@FXML
	void btnRemovePressed(ActionEvent e) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		totalCost.setText(cart.totalCost()+"$");
	}
	
	@FXML
	void btnPlaceOrderPressed(ActionEvent e) {
		Dialog<String> order = new Dialog<>();
		order.setTitle("Place Order");
		order.setContentText("Order Successfully Placed");
		ButtonType done = new ButtonType("Ok", ButtonData.OK_DONE);
		order.getDialogPane().getButtonTypes().add(done);
		order.show();
	}
	
	@FXML
	void btnPlayPressed(ActionEvent e) throws PlayerException {
		Dialog<String> mediaplay = new Dialog<>();
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		mediaplay.setTitle(media.toString());
		mediaplay.setContentText("Playing");
		ButtonType done = new ButtonType("Cancel", ButtonData.OK_DONE);
		mediaplay.getDialogPane().getButtonTypes().add(done);
		mediaplay.show();
		if (media instanceof Playable) {
			((Playable) media).play();
		}
	}
	
	@FXML
	void menuItemPressed(ActionEvent e) {
		MenuItem m = (MenuItem)e.getSource();
		if (m.getText().equals("Add Book")) {
			new AddBookToStoreScreen(store, cart);
			window.dispose();
		}
		else if (m.getText().equals("Add CD")) {
			new AddCompactDiscToStoreScreen(store, cart);
			window.dispose();
		}
		else if (m.getText().equals("Add DVD")) {
			new AddDigitalVideoDiscToStoreScreen(store, cart);
			window.dispose();
		}
		else if (m.getText().equals("View Store")) {
			new StoreScreen(store, cart);
			window.dispose();
		}
		else if (m.getText().equals("View Cart")) {
			new CartScreen(store,cart);
			window.dispose();
		}
	}
	
	public void setWindow(Window window) {
		this.window = window;
	}
}
