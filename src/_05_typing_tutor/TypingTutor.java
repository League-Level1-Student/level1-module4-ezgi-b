package _05_typing_tutor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;



public class TypingTutor implements KeyListener {
	public static void main(String[] args) {
		new TypingTutor().createUI();
	}
	JFrame frame;
	char currentLetter;
	JLabel labelLetter;
	void createUI(){
		frame = new JFrame("Type or DIE");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		frame.addKeyListener(this);
		labelLetter = new JLabel();
		currentLetter =  generateRandomLetter();
		frame.add(labelLetter);
		labelLetter.setText(Character.toString(currentLetter));
		labelLetter.setFont(labelLetter.getFont().deriveFont(28.0f));
		labelLetter.setHorizontalAlignment(JLabel.CENTER);
		
		frame.pack();
	}
	char generateRandomLetter() {
		Random r = new Random();
		return (char) (r.nextInt(26) + 'a');
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("You typed a " + Character.toString(e.getKeyChar()) + ".");
		if(e.getKeyChar()==currentLetter) {
			System.out.println("Correct!");
			frame.setBackground(Color.GREEN);
		}else {
			System.out.println("Incorrect!");
			frame.setBackground(Color.RED);
		}
		currentLetter = generateRandomLetter();
		labelLetter.setText(Character.toString(currentLetter));
		frame.pack();
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
