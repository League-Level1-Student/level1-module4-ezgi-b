package _10_pig_latin;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PigLatinTranslator implements ActionListener {
	public static void main(String[] args) {
		PigLatinTranslator piggy = new PigLatinTranslator();
		piggy.CreateUI();
	}
	
	Dimension textField = new Dimension(500,30);
	JTextField input;
	JTextField output;
	JFrame frame;
	
	void CreateUI() {
		frame = new JFrame("Pig Latin Translator");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		JPanel panel = new JPanel();
		input = new JTextField();
		input.setPreferredSize(textField);
		input.setToolTipText("input");
		JButton translate = new JButton("Translate");
		translate.addActionListener(this);
		output = new JTextField();
		output.setToolTipText("output");
		output.setPreferredSize(textField);
		
		frame.add(panel);
		panel.add(input);
		panel.add(translate);
		panel.add(output);
		frame.pack();
	}
	
	private static boolean isLetter(char c) {
        return ( (c >= 'A' && c <= 'Z') || (c >='a' && c <= 'z') );
	}
	
	private static String pigWord(String word) {
        int split = firstVowel(word);
        return word.substring(split)+"-"+word.substring(0, split)+"ay";
	}
	
	private static int firstVowel(String word) {
        word = word.toLowerCase();
        for (int i=0; i < word.length(); i++)
             if (word.charAt(i)=='a' || word.charAt(i)=='e' ||
                  word.charAt(i)=='i' || word.charAt(i)=='o' ||
                  word.charAt(i)=='u')
                  return i;
             return 0;
	}
	
	public String translate(String s) {
        String latin = "";
        int i = 0;
        while (i < s.length()) {

   // Take care of punctuation and spaces
        while (i < s.length() && !isLetter(s.charAt(i))) {
             latin = latin + s.charAt(i);
             i++;
        }

   // If there aren't any words left, stop.
        if (i>=s.length()) break;

   // Otherwise we're at the beginning of a word.
        int begin = i;
        while (i < s.length() && isLetter(s.charAt(i))) {
             i++;
        }
   // Now we're at the end of a word, so translate it.
        int end = i;
        latin = latin + pigWord(s.substring(begin, end));
        }
        return latin;
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		output.setText(translate(input.getText()));
	}

}
