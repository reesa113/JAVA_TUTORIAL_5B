/*
 a. JFrame (SimpleCounter / frame): The main application window, titled "My Frame" with a size of 350x120 pixels.

	JLabel (label): A static text label that displays the text "Counter Value:".
	
	JTextField (textField): A text field with a width of 10 columns. It is set to non-editable (setEditable(false)) and used to display the updated numeric value of the counter.
	
	JButton (countButton): A clickable button labeled "Count" that listens for user clicks to increment the counter value.
	
	FlowLayout: The layout manager applied to the frame to position and align the components in a sequential flow.
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener 
{
	private JLabel label1, label2, label3, label4;
	private JTextField textNum1, textNum2, textResult;
	private JButton addButton, subtractButton, multiplyButton, divideButton;
	
	public SimpleCalculator() 
	{
		// Create components
		label1 = new JLabel("Simple Calculator");
		label2 = new JLabel("Enter first number:");
		label3 = new JLabel("Enter second number:");
		label4 = new JLabel("Result:");
		textNum1 = new JTextField(10);
		textNum2 = new JTextField(10);
		textResult = new JTextField(10);
		textResult.setEditable(false); // make result field non-editable
		addButton = new JButton("+");
		addButton.addActionListener(this);
		subtractButton = new JButton("-");
		subtractButton.addActionListener(this);
		multiplyButton = new JButton("x");
		multiplyButton.addActionListener(this);
		divideButton = new JButton("÷");
		divideButton.addActionListener(this);
		
		JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 3, 3));
		buttonPanel.add(addButton);
		buttonPanel.add(subtractButton);
		buttonPanel.add(multiplyButton);
		buttonPanel.add(divideButton);
		
		// Layout setup
		setLayout(new GridLayout(5, 2, 5, 5));
		add(label1);
		add(new JLabel("")); // empty cell for spacing
		add(label2);
		add(textNum1);
		add(label3);
		add(textNum2);
		add(label4);
		add(textResult);
		add(new JLabel("")); // spacing
		add(buttonPanel);
	}
	
	// Handle button click
	public void actionPerformed(ActionEvent e) 
	{
		try 
		{
			double num1 = Double.parseDouble(textNum1.getText());
			double num2 = Double.parseDouble(textNum2.getText());
			double result = 0;
			
			if (e.getSource() == addButton) 
			{
				result = num1 + num2;
			} 
			else if (e.getSource() == subtractButton) 
			{
				result = num1 - num2;
			} 
			else if (e.getSource() == multiplyButton) 
			{
				result = num1 * num2;
			} 
			else if (e.getSource() == divideButton) 
			{
				if (num2 == 0) 
				{
					JOptionPane.showMessageDialog(this, "Cannot divide by zero!");
					return;
				}
				result = num1 / num2;
			}
			
			textResult.setText(String.valueOf(result));
		} 
		catch (NumberFormatException ex) 
		{
			JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
		}
	}
	
	public static void main(String[] args) 
	{
		SimpleCalculator frame = new SimpleCalculator();
		// Frame setup
		frame.setTitle("Simple Calculator");
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // center on screen
		frame.setVisible(true);
	}
}
