package _08_calculator;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {
	Dimension d = new Dimension(80,20);
	void CreateUI(){
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		JPanel outside = new JPanel();
		outside.setLayout(new BoxLayout(outside, BoxLayout.Y_AXIS));
		JPanel input = new JPanel();
		JPanel buttons = new JPanel();
		JButton add = new JButton("+");
		JButton subtract = new JButton("-");
		JButton multiply = new JButton("*");
		JButton divide = new JButton("/");
		JTextField firstNumber = new JTextField();
		firstNumber.setPreferredSize(d);
		JTextField secondNumber = new JTextField();
		secondNumber.setPreferredSize(d);
		JLabel symbol = new JLabel();
		
		
		frame.add(outside);
		outside.add(input);
		outside.add(buttons);
		input.add(firstNumber);
		input.add(symbol);
		input.add(secondNumber);
		buttons.add(add);
		buttons.add(subtract);
		buttons.add(multiply);
		buttons.add(divide);
		frame.pack();
	}
	int add(int one, int two) {
		return one + two;
	}
	int subtract(int one, int two) {
		return one - two;
	}
	int multiply(int one, int two) {
		return one * two;
	}
	int divide(int one, int two) {
		return one / two;
	}
}
