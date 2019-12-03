package _01_nasty_surprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySurprise implements ActionListener {
	private void showPictureFromTheInternet(String imageUrl) {
	     try {
	          URL url = new URL(imageUrl);
	          Icon icon = new ImageIcon(url);
	          JLabel imageLabel = new JLabel(icon);
	          JFrame frame = new JFrame();
	          frame.add(imageLabel);
	          frame.setVisible(true);
	          frame.setDefaultCloseOperation(1);
	          frame.pack();
	     } catch (MalformedURLException e) {
	          e.printStackTrace();
	     }
	}
	JButton treat;
	JButton trick;
	public void CreateUI() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		JPanel panel = new JPanel();
		trick = new JButton("Trick");
		trick.addActionListener(this);
		treat = new JButton("Treat");
		treat.addActionListener(this);
		frame.add(panel);
		panel.add(trick);
		panel.add(treat);
		frame.pack();
	}
	
	public static void main(String[] args) {
		NastySurprise tricktreat = new NastySurprise();
		tricktreat.CreateUI();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==treat) {
			
			showPictureFromTheInternet("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2Is8sGPkK19Jj3m4L2Hvu0WuY-rsxmGFL8_NTQ8f_HyOI1-1r&s");
		}
		if(e.getSource()==trick) {
			
			showPictureFromTheInternet("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTN4xanuvbvsz3DqZSfj4mfaZUlqfC3nELHfaegM88tHmszZX3g&s");
		}
		
	}

}




