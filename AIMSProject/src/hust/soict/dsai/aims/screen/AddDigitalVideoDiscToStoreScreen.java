package hust.soict.dsai.aims.screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.DataConstraintsException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
	private JTextField title;
    private JTextField category;
    private JTextField cost;
    private JTextField length;
    private JTextField director;
    
    JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		Store store = this.getStore();
		Cart cart = this.getCart();
		
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBookScreen = new JMenuItem("Add Book");
		addBookScreen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddBookToStoreScreen(store, cart);
				dispose();
			}			
		});
		smUpdateStore.add(addBookScreen);
		JMenuItem addCDScreen = new JMenuItem("Add CD");
		addCDScreen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddCompactDiscToStoreScreen(store, cart);
				dispose();
			}			
		});
		smUpdateStore.add(addCDScreen);
		JMenuItem addDVDScreen = new JMenuItem("Add DVD");
		addDVDScreen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddDigitalVideoDiscToStoreScreen(store, cart);
				dispose();
			}			
		});
		smUpdateStore.add(addDVDScreen);
		
		menu.add(smUpdateStore);
		JMenuItem viewStoreScreen = new JMenuItem("View Store");
		viewStoreScreen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new StoreScreen(store, cart);
				dispose();
			}			
		});
		menu.add(viewStoreScreen);
		JMenuItem viewCartScreen = new JMenuItem("View Cart");
		viewCartScreen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CartScreen(store, cart);
				dispose();
			}			
		});
		menu.add(viewCartScreen);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("ADD DVD");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.RED);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		
		return header;
	}
	
	JPanel createEast() {
		JButton addToStoreButton = new JButton("Add to Store");
        addToStoreButton.setFont(new Font(addToStoreButton.getFont().getName(), Font.PLAIN, 24));
        addToStoreButton.setBackground(Color.RED);
        addToStoreButton.setForeground(Color.WHITE);
        Store store = this.getStore();
        addToStoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add to store button action
            	String addtitle = title.getText();
            	String addcategory = category.getText();
            	Float addcost = 0.0f;
            	try {
            		addcost = Float.parseFloat(cost.getText());
            	} catch (Exception ex) {
            		JDialog d = new JDialog();
                    d.setLayout(new FlowLayout());
                    d.setTitle("Error");
                    JLabel l = new JLabel("Invalid cost.");
                    d.add(l);
                    JButton b = new JButton("OK");  
                    b.addActionListener (new ActionListener(){
                        public void actionPerformed(ActionEvent e)  
                        {  
                            d.dispose();  
                        }  
                    });
                    d.add(b);   
                    d.setSize(100, 100);
                    d.setVisible(true);
                	title.setText("");
                	category.setText("");
                	cost.setText("");
                    return;
            	}
            	int addlength = 0;
            	try {
            		addlength = Integer.parseInt(length.getText());
            	} catch (Exception ex) {
            		JDialog d = new JDialog();
                    d.setLayout(new FlowLayout());
                    d.setTitle("Error");
                    JLabel l = new JLabel("Invalid length.");
                    d.add(l);
                    JButton b = new JButton("OK");  
                    b.addActionListener (new ActionListener(){
                        public void actionPerformed(ActionEvent e)  
                        {  
                            d.dispose();  
                        }  
                    });
                    d.add(b);   
                    d.setSize(100, 100);
                    d.setVisible(true);
                	title.setText("");
                	category.setText("");
                	cost.setText("");
                	length.setText("");
                	director.setText("");  
                    return;
            	}
            	String adddirector = director.getText();
            	title.setText("");
            	category.setText("");
            	cost.setText("");
            	length.setText("");
            	director.setText("");            	
            	DigitalVideoDisc addDVD = null;
				try {
					addDVD = new DigitalVideoDisc(addtitle, addcategory, addcost);
				} catch (DataConstraintsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	addDVD.setLength(addlength);
            	addDVD.setDirector(adddirector);
            	store.addMedia(addDVD);
            }
        });

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.add(addToStoreButton);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(50, 30, 0, 30));
        
        return rightPanel;
	}
    
	JPanel createCenter() {
		JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(1000, 400));
//        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel compulsoryLabel = new JLabel("*compulsory");
        compulsoryLabel.setFont(new Font(compulsoryLabel.getFont().getName(), Font.PLAIN, 24));
        compulsoryLabel.setForeground(Color.RED);
//        compulsoryLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        centerPanel.add(compulsoryLabel);

        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.X_AXIS));
//        fieldsPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        JPanel titlePanel = new JPanel();
        titlePanel.setPreferredSize(new Dimension(200, 100));
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        JLabel titleLabel = new JLabel("Title");
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 24));

        title = new JTextField();

        titlePanel.add(titleLabel);
        titlePanel.add(title);

        JPanel categoryPanel = new JPanel();
        categoryPanel.setPreferredSize(new Dimension(200, 100));
        categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.Y_AXIS));
        categoryPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        JLabel categoryLabel = new JLabel("Category");
        categoryLabel.setFont(new Font(categoryLabel.getFont().getName(), Font.PLAIN, 24));

        category = new JTextField();

        categoryPanel.add(categoryLabel);
        categoryPanel.add(category);

        JPanel costPanel = new JPanel();
        costPanel.setPreferredSize(new Dimension(200, 100));
        costPanel.setLayout(new BoxLayout(costPanel, BoxLayout.Y_AXIS));
        costPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        JLabel costLabel = new JLabel("Cost");
        costLabel.setFont(new Font(costLabel.getFont().getName(), Font.PLAIN, 24));

        cost = new JTextField();

        costPanel.add(costLabel);
        costPanel.add(cost);

        fieldsPanel.add(titlePanel);
        fieldsPanel.add(categoryPanel);
        fieldsPanel.add(costPanel);

        centerPanel.add(fieldsPanel);

        JLabel optionalLabel = new JLabel("*optional");
        optionalLabel.setFont(new Font(optionalLabel.getFont().getName(), Font.PLAIN, 24));
        optionalLabel.setForeground(Color.RED);
//        optionalLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));

        centerPanel.add(optionalLabel);

        JPanel optionalFieldsPanel = new JPanel();
        optionalFieldsPanel.setLayout(new BoxLayout(optionalFieldsPanel, BoxLayout.X_AXIS));
//        optionalFieldsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JPanel lengthPanel = new JPanel();
        lengthPanel.setPreferredSize(new Dimension(200, 100));
        lengthPanel.setLayout(new BoxLayout(lengthPanel, BoxLayout.Y_AXIS));
        lengthPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        JLabel lengthLabel = new JLabel("Length");
        lengthLabel.setFont(new Font(lengthLabel.getFont().getName(), Font.PLAIN, 24));

        length = new JTextField();

        lengthPanel.add(lengthLabel);
        lengthPanel.add(length);
        
        JPanel directorPanel = new JPanel();
        directorPanel.setPreferredSize(new Dimension(200, 100));
        directorPanel.setLayout(new BoxLayout(directorPanel, BoxLayout.Y_AXIS));
        directorPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        JLabel directorLabel = new JLabel("Director");
        directorLabel.setFont(new Font(directorLabel.getFont().getName(), Font.PLAIN, 24));

        director = new JTextField();

        directorPanel.add(directorLabel);
        directorPanel.add(director);

        optionalFieldsPanel.add(lengthPanel);
        optionalFieldsPanel.add(directorPanel);
        optionalFieldsPanel.add(Box.createHorizontalGlue());

        centerPanel.add(optionalFieldsPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(200, 200)));
        
        return centerPanel;
	}
	
	public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
		super(store, cart);
		
		setTitle("Add DVD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLayout(new BorderLayout());

        add(createNorth(), BorderLayout.NORTH);
        add(createCenter(), BorderLayout.CENTER);
        add(createEast(), BorderLayout.EAST);

        setVisible(true);
    }
}
