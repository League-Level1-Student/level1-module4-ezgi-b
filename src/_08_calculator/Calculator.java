package _08_calculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	Dimension d = new Dimension(80,20);
	JButton add;
	JButton subtract;
	JButton multiply;
	JButton divide;
	JLabel answer;
	JTextField firstNumber;
	JTextField secondNumber;
	JFrame frame;
	void CreateUI(){
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);
		JPanel outside = new JPanel();
		outside.setLayout(new BoxLayout(outside, BoxLayout.Y_AXIS));
		JPanel input = new JPanel();
		JPanel buttons = new JPanel();
		add = new JButton("+");
		add.addActionListener(this);
		subtract = new JButton("-");
		subtract.addActionListener(this);
		multiply = new JButton("*");
		multiply.addActionListener(this);
		divide = new JButton("/");
		divide.addActionListener(this);
		answer = new JLabel();
		firstNumber = new JTextField();
		firstNumber.setPreferredSize(d);
		secondNumber = new JTextField();
		secondNumber.setPreferredSize(d);
		JLabel symbol = new JLabel();
		
		
		frame.add(outside);
		outside.add(input);
		outside.add(buttons);
		outside.add(answer);
		input.add(firstNumber);
		input.add(symbol);
		input.add(secondNumber);
		buttons.add(add);
		buttons.add(subtract);
		buttons.add(multiply);
		buttons.add(divide);
		frame.pack();
	}
	void add(int one, int two) {
		answer.setText(Integer.toString(one + two));
	}
	void subtract(int one, int two) {
		answer.setText(Integer.toString(one - two));
	}
	void multiply(int one, int two) {
		answer.setText(Integer.toString(one * two));
	}
	void divide(int one, int two) {
		float ONE = one;
		float TWO = two;
		answer.setText(Float.toString(ONE / TWO));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource()==add) {
			add(Integer.parseInt(firstNumber.getText()),Integer.parseInt(secondNumber.getText()));
		}else if(e.getSource()==subtract) {
			subtract(Integer.parseInt(firstNumber.getText()),Integer.parseInt(secondNumber.getText()));
		}else if(e.getSource()==multiply) {
			multiply(Integer.parseInt(firstNumber.getText()),Integer.parseInt(secondNumber.getText()));
		}else if(e.getSource()==divide) {
			divide(Integer.parseInt(firstNumber.getText()),Integer.parseInt(secondNumber.getText()));
		}
		frame.pack();

	}
}
