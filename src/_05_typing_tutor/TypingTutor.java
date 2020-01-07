package _05_typing_tutor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class TypingTutor implements KeyListener {
	public static void main(String[] args) {
		new TypingTutor().createUI();
	}
	Date timeAtStart = new Date();
	int correctCharCount=0;
	int incorrectCharCount=0;
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
		if(correctCharCount<60) {
			System.out.println("You typed a " + Character.toString(e.getKeyChar()) + ".");
			if(e.getKeyChar()==currentLetter) {
				System.out.println("Correct!");
				frame.setBackground(Color.GREEN);
				correctCharCount++;
			}else {
				System.out.println("Incorrect!");
				frame.setBackground(Color.RED);
				incorrectCharCount++;
			}
			currentLetter = generateRandomLetter();
			labelLetter.setText(Character.toString(currentLetter));
			frame.pack();
		}else {
			JOptionPane.showMessageDialog(null, "The typing tutor is over, you have typed " + correctCharCount + " correct characters and " + incorrectCharCount + " incorrect characters.");
			showTypingSpeed(correctCharCount,"correct");
			showTypingSpeed(incorrectCharCount,"incorrect");
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void showTypingSpeed(int numberOfCorrectCharactersTyped, String incorrectOrCorrect) {
	      Date timeAtEnd = new Date();
	      long gameDuration = timeAtEnd.getTime() - timeAtStart.getTime();
	      long gameInSeconds = (gameDuration / 1000) % 60;
	      double charactersPerSecond = ((double) numberOfCorrectCharactersTyped / (double) gameInSeconds);
	      int charactersPerMinute = (int) (charactersPerSecond * 60);
	      JOptionPane.showMessageDialog(null, "Your typing speed is " + charactersPerMinute + " " + incorrectOrCorrect + " characters per minute.");
	}
	
}
