package _07_fortune_teller;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

public class FortuneTellerRunner {
    public static void main(String[] args) throws Exception {
      	 SwingUtilities.invokeLater(new FortuneTeller());
      	 begin();
       }
    
    static void begin() {
    	JOptionPane.showMessageDialog(null, "Welcome player, the answer is the middle of ACT plus the end of CANDLE plus the end of CAN plus the beginning "
    			+ "of TOOL plus the middle of TEE plus the end of CAR.");
      	 // Welcome the user. Give them a hint for the secret location.

    }
}
