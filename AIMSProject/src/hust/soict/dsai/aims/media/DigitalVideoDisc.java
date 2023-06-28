package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.DataConstraintsException;
import hust.soict.dsai.aims.exception.PlayerException;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

public class DigitalVideoDisc extends Disc implements Playable{
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) throws DataConstraintsException {
		super(title, category, director, length, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) throws DataConstraintsException {
		super(title, category, director, 0, cost);
	}
	public DigitalVideoDisc(String title, String category, float cost) throws DataConstraintsException {
		super(title, category, null, 0, cost);
	}
	public DigitalVideoDisc(String title) throws DataConstraintsException {
		super(title, null, null, 0, 0.0f);
	}
	
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("p");
		} else {
			System.err.println("The DVD has negative length!");
			PlayerException e = new PlayerException("ERROR: DVD length is non-positive!");
			JDialog d = new JDialog();
            d.setLayout(new BoxLayout(d.getContentPane(), BoxLayout.Y_AXIS));
            d.setTitle("The DVD has negative length!");
            JLabel info = new JLabel(this.toString());
            d.add(info);
            JLabel m = new JLabel(e.getMessage());
            d.add(m);
            JButton b = new JButton("OK");  
            b.addActionListener (new ActionListener(){
                public void actionPerformed(ActionEvent e)  
                {  
                    d.dispose();  
                }
            });
            JPanel p = new JPanel();
            p.setLayout(new FlowLayout());
            p.add(b);
            d.add(Box.createVerticalGlue());
            d.add(p);
            d.setSize(500, 500);
            d.setVisible(true);
            throw e;
		}
	}
	
	public String toString() {
		return String.format("DVD - %s - %s - %s - %d: %.2f$", this.getTitle(), this.getCategory(), 
							  this.getDirector(), this.getLength(), this.getCost());
	}
}
