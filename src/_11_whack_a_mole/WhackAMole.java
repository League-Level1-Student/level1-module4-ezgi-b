package _11_whack_a_mole;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	public static void main(String[] args) {
		WhackAMole mole = new WhackAMole();
		mole.CreateUI();
	}
	Date timeAtStart = new Date();
	int wrong = 0;
	int right = 0;
	JFrame frame;
	JButton mole;
	Dimension F = new Dimension(150,230);
	Dimension B = new Dimension(40,20);
	void CreateUI(){
		frame = new JFrame();
		frame.setVisible(true);
		frame.setPreferredSize(F);
		frame.setDefaultCloseOperation(3);
		drawButtons(frame);
	}
	
	void drawButtons(JFrame JF) {
		
		JPanel panel = new JPanel();
		JF.add(panel);
		
		int moleRandom = new Random().nextInt(24);
		for(int i=0; i<24; i++) {
			int num = i+1;
			if(i==moleRandom) {
				mole = new JButton("MOLE");
				panel.add(mole);
				mole.addActionListener(this);
				mole.setToolTipText("MOLE");
				mole.setPreferredSize(B);
			}else {
			JButton jb = new JButton();
			panel.add(jb);
			jb.addActionListener(this);
			jb.setToolTipText("Button " + num);
			jb.setPreferredSize(B);
			}
		}
		JF.pack();
		
	}
	
	void speak(String words) {
	     try {
	          Runtime.getRuntime().exec("say " + words).waitFor();
	     } catch (Exception e) {
	          e.printStackTrace();
	     }
	}
	
	private void endGame(Date timeAtStart, int molesWhacked) {
	     Date timeAtEnd = new Date();
	     JOptionPane.showMessageDialog(null, "Your whack rate is "
	          + (molesWhacked/((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00))
	          + " moles per second.");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(mole)) {
			speak("You got it!");
			frame.dispose();
			right++;
			if(right==10) {
				speak("You win!");
				endGame(timeAtStart,10);
			}else {
				CreateUI();
			}
			
			
		}else {
			wrong++;
			int prevWrong = wrong-1;
			if(wrong==1) {
			speak("You did not hit the mole!");
			}else if(wrong==2) {
				speak("You missed. Shameful, since you've already missed before.");
			}else {
				speak("You missed. Shameful, since you've already missed " + prevWrong + " times before.");
			}
			if(wrong==5) {
				speak("You lose!");
				frame.dispose();
			}
			
		}
		System.out.println("pressed");
		
	}
	
	
}
