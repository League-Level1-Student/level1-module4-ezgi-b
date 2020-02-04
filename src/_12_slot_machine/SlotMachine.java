package _12_slot_machine;


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

public class SlotMachine implements ActionListener {
	public static void main(String[] args) {
		SlotMachine BB8 = new SlotMachine();
		BB8.CreateUI();
	}
	JFrame frame;
	JPanel panel;
	JLabel one;
	JLabel two;
	JLabel three;
	void CreateUI() {
		frame = new JFrame();
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
		JButton goSlot = new JButton("Spin");
		goSlot.addActionListener(this);
		
		frame.add(panel);
		panel.add(one);
		panel.add(two);
		panel.add(three);
		panel.add(goSlot);
		frame.pack();
		
	}
	void spin() {
		for(int i =0; i<10; i++) {
		
		
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
