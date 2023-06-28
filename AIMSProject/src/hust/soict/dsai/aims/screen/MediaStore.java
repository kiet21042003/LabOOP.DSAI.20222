package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.exception.PlayerException;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MediaStore extends JPanel{
	private Media media;
	private JButton playButton = new JButton("Play");
	private JButton addToCart = new JButton("Add to cart");
	
	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		container.add(addToCart);
		if(media instanceof Playable) {
			container.add(playButton);
			playButton.addActionListener(new ActionListener( ) {
				@Override
				public void actionPerformed(ActionEvent e) {
					JDialog d = new JDialog();
					d.setLayout(new FlowLayout());
					d.setTitle(media.toString());
					try {
						((Playable)media).play();
					} catch (PlayerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JLabel l = new JLabel("Playing");
					d.add(l);
					JButton b = new JButton("Cancel");
					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							d.dispose();
						}
					});
					d.add(b);
					d.setSize(100,100);
					d.setVisible(true);
				}
			});
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	public Media getMedia() {
		return media;
	}

	public JButton getAddToCart() {
		return addToCart;
	}

}
