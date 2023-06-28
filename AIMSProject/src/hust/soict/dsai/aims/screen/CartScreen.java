package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.io.IOException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

import javafx.embed.swing.JFXPanel;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {

	private Cart cart;
	private Store store;
	
	public CartScreen(Store store, Cart cart) {
		super();

		this.cart = cart;
		this.store = store;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		Platform.runLater(() -> {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
				CartScreenController controller = new CartScreenController(store, cart);
				controller.setWindow(SwingUtilities.getWindowAncestor(fxPanel));
				loader.setController(controller);
				Parent root = loader.load();
				fxPanel.setScene(new Scene(root));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});	}
	
}
