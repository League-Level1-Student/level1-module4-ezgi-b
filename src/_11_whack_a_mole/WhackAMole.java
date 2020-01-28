package _11_whack_a_mole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	public static void main(String[] args) {
		WhackAMole mole = new WhackAMole();
		mole.CreateUI();
	}
	
	void CreateUI(){
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		drawButtons(frame);
	}
	
	void drawButtons(JFrame JF) {
		JPanel xAxis = new JPanel();
		JPanel yOne = new JPanel();
		yOne.setLayout(new BoxLayout(yOne, BoxLayout.Y_AXIS));
		JPanel yTwo = new JPanel();
		yTwo.setLayout(new BoxLayout(yTwo, BoxLayout.Y_AXIS));
		JPanel yThree= new JPanel();
		yThree.setLayout(new BoxLayout(yThree, BoxLayout.Y_AXIS));
		
		JF.add(xAxis);
		xAxis.add(yOne);
		xAxis.add(yTwo);
		xAxis.add(yThree);
		for(int i=0; i<8; i++) {
			int num = i+1;
			JButton jb = new JButton();
			yOne.add(jb);
			jb.setToolTipText("Button" + num);
			jb.addActionListener(this);
			jb.setName("Button" + num);
		}
		for(int i=0; i<8; i++) {
			int num = i+9;
			JButton jb = new JButton();
			yTwo.add(jb);
			jb.setToolTipText("Button" + num);
			jb.addActionListener(this);
			jb.setName("Button" + num);
		}
		for(int i=0; i<8; i++) {
			int num = i+17;
			JButton jb = new JButton();
			yThree.add(jb);
			jb.setToolTipText("Button" + num);
			jb.addActionListener(this);
			jb.setName("Button" + num);
		}
		JF.pack();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("pressed");
		
	}
	
	
}
