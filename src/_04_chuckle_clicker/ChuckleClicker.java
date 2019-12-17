package _04_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	public static void main(String[] args) {
		new ChuckleClicker().makeButtons();
	}
	
	void makeButtons(){
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		JPanel panel = new JPanel();
		JButton joke = new JButton("Joke");
		joke.addActionListener(this);
		JButton punchline = new JButton("Punchline");
		punchline.addActionListener(this);
		panel.add(joke);
		panel.add(punchline);
		frame.add(panel);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
