package _04_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	public static void main(String[] args) {
		new ChuckleClicker().makeButtons();
	}
	JButton punchline;
	JButton joke;
	void makeButtons(){
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		JPanel panel = new JPanel();
		joke = new JButton("Joke");
		joke.addActionListener(this);
		punchline = new JButton("Punchline");
		punchline.addActionListener(this);
		panel.add(joke);
		panel.add(punchline);
		frame.add(panel);
		frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==joke) {
			JOptionPane.showMessageDialog(null, "Never criticize someone until you have walked a mile in their shoes.");
		}
		if(e.getSource()==punchline) {
		JOptionPane.showMessageDialog(null, "That way, when you criticize them, you'll be a mile away, and you'll have their shoes.");
		}
		
	}
}
