package _07_fortune_teller;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

import java.applet.AudioClip;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FortuneTeller extends JPanel implements Runnable, MouseListener {

    JFrame frame = new JFrame();

    int frameWidth = 1280;
    int frameHeight = 940;
    

    FortuneTeller() throws Exception {
   	 // 1. Choose an image for your fortune teller and put it in your default package
   	 fortuneTellerImage = ImageIO.read(getClass().getResource("fortuneTeller.png"));
   	 // 2. Adjust the frameWidth and frameHeight variables to fit your image nicely (doesn’t need a new line of code)
     // 3. Complete the begin() method in the FortuneTellerRunner class
 	 // 4. add a mouse listener to the frame

    }



    @Override
    public void mousePressed(MouseEvent e) {
   	 int mouseX = e.getX();
   	 int mouseY = e.getY();
   	 System.out.println("("+mouseX+", "+mouseY+")");
   	 
   	 // 5. Print the mouseX variable

   	 // 6. Add the mouseY variable to the previous line so that it prints out too (no new line)
   	 // 7. Adjust your secret location co-ordinates here:
   	 int secretLocationX = 598;
   	 int secretLocationY = 460;
   	 /** If the mouse co-ordinates and secret location are close, we'll let them ask a question. */
   	 if (areClose(mouseX, secretLocationX) && areClose(mouseY, secretLocationY)) {
   		 JOptionPane.showInputDialog("What is your question?");
   		 AudioClip sound = JApplet.newAudioClip(getClass().getResource("creepy-noise.wav"));
   		 sound.play();
   		 pause(2);
   		 
   		 
   		int rand = new Random().nextInt(15);
		System.out.println(rand);
		if(rand==0) {
			JOptionPane.showMessageDialog(null, "You will have 9 children-three sets of identical triplets.");
		} else if(rand==1) {
			JOptionPane.showMessageDialog(null, "You will live long and prosper.");
		} else if(rand==2) {
			JOptionPane.showMessageDialog(null, "Maybe you should ask Google.");
		} else if(rand==3) {
			JOptionPane.showMessageDialog(null, "Why should I answer your question?");
		} else if(rand==4) {
			JOptionPane.showMessageDialog(null, "Neither can live while the other survives.");
		} else if(rand==5) {
			JOptionPane.showMessageDialog(null, "You're a Slytherin?");
		} else if(rand==6) {
			JOptionPane.showMessageDialog(null, ".....No Comment.....");
		} else if(rand==7) {
			JOptionPane.showMessageDialog(null, "What is your favorite color M&M?");
		} else if(rand==8) {
			JOptionPane.showMessageDialog(null, "Of course!");
		} else if(rand==9) {
			JOptionPane.showMessageDialog(null, "Do you wanna build a snowman? You seem lonely.");
		} else if(rand==10) {
			JOptionPane.showMessageDialog(null, "The ways of the fortuneteller are not for you to know!");
		} else if(rand==11) {
			JOptionPane.showMessageDialog(null, "YOU'VE BEEN CHEATING ON ME!");
		} else if(rand==12) {
			JOptionPane.showMessageDialog(null, "Have a nice day Tom Riddle.");
		} else if(rand==13) {
			JOptionPane.showMessageDialog(null, "The answer to that question is too complex for your simple mind.");
		} else if(rand==14) {
			JOptionPane.showMessageDialog(null, "It was alllll a drrrreeeeaaaammmmm.");
		}
		
		
   		 // 8. Get the user to enter a question for the fortune teller

   		 // 9. Find a spooky sound and put it in your default package (freesound.org)
   		 // AudioClip sound = JApplet.newAudioClip(getClass().getResource("creepy-noise.wav"));
   		 // 10. Play the sound

   		 // 11. Use the pause() method below to wait until your music has finished

   		 // 12. Insert your completed Magic 8 ball code here

   	 }

    }

    private boolean areClose(int mouseX, int secretLocationX) {
   	 return mouseX < secretLocationX + 15 && mouseX > secretLocationX - 15;
    }

    private void pause(int seconds) {
   	 try {
   		 Thread.sleep(1000 * seconds);
   	 } catch (InterruptedException e) {
   		 e.printStackTrace();
   	 }
    }
    
    /**************** don't worry about the stuff under here *******************/
    
    BufferedImage fortuneTellerImage;



    @Override
    public void run() {
   	 frame.add(this);
   	 setPreferredSize(new Dimension(frameWidth, frameHeight));
   	 frame.pack();
   	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	 frame.setResizable(false);
   	 frame.setVisible(true);
   	 frame.addMouseListener(this);
    }

private void showAnotherImage(String imageName) {
   	 try {
   		 fortuneTellerImage = ImageIO.read(getClass().getResource(imageName));
   	 } catch (Exception e) {
   		 System.err.println("Couldn't find this image: " + imageName);
   	 }
   	 repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
   	 g.drawImage(fortuneTellerImage, 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}

// Copyright The League, 2016




