package _12_slot_machine;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	public static void main(String[] args) {
		SlotMachine BB8 = new SlotMachine();
		BB8.CreateUI();
	}
	Dimension d = new Dimension(1100,400);
	String[] s;
	JFrame frame;
	JPanel panel;
	JLabel one;
	JLabel two;
	JLabel three;
	JLabel dollars;
	double dollarAmount;
	JButton goSlot;
	void CreateUI() {
		frame = new JFrame();
		frame.setPreferredSize(d);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		panel = new JPanel();
		try {
			one = createLabelImage("Avocado.jpg");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			two = createLabelImage("Cherry.jpg");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			three = createLabelImage("Strawberry.jpg");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		goSlot = new JButton("Spin");
		goSlot.addActionListener(this);
		
		dollarAmount = 0.05;
		dollars = new JLabel("$" + String.format("%.2f", dollarAmount));
		
		
		frame.add(panel);
		panel.add(one);
		panel.add(two);
		panel.add(three);
		panel.add(goSlot);
		panel.add(dollars);
		frame.pack();
		s = new String[3];
		s[0] = "Avocado.jpg";
		s[1] = "Cherry.jpg";
		s[2] = "Strawberry.jpg";
		
	}
	void spin() {
		if(dollarAmount<=0) {
			frame.dispose();
			JOptionPane.showMessageDialog(null, "You ran out of money :(");
		}else{
			dollarAmount-=0.01;
			panel.removeAll();
			int slotOneRandom = new Random().nextInt(3);
			try {
				one = createLabelImage(s[slotOneRandom]);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int slotTwoRandom = new Random().nextInt(3);
			try {
				two = createLabelImage(s[slotTwoRandom]);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int slotThreeRandom = new Random().nextInt(3);
			try {
				three = createLabelImage(s[slotThreeRandom]);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			panel.add(one);
			panel.add(two);
			panel.add(three);
			panel.add(goSlot);
			panel.add(dollars);
			dollars.setText("$" + String.format("%.2f", dollarAmount));
			if(slotOneRandom==slotTwoRandom&&slotTwoRandom==slotThreeRandom) {
				dollarAmount+=0.05;
				JOptionPane.showMessageDialog(null, "You won 5 cents!");
			}
			if(dollarAmount<0.001) {
				dollars.setText("$0.00");
			}else {
				dollars.setText("$" + String.format("%.2f", dollarAmount));
			}
			frame.pack();
		
		}
		
			
		
	}
	
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		spin();
	}
    
}
