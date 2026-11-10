/*
 a.	JFrame (SimpleCounter / frame): The main application window, titled "My Frame" with a size of 350x120 pixels.

	JLabel (label): A static text label that displays the text "Counter Value:".
	
	JTextField (textField): A text field with a width of 10 columns. It is set to non-editable (setEditable(false)) and used to display the updated numeric value of the counter.
	
	JButton (countButton): A clickable button labeled "Count" that listens for user clicks to increment the counter value.
	
	FlowLayout: The layout manager applied to the frame to position and align the components in a sequential flow.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCounter extends JFrame implements ActionListener 
{
	private JLabel label;
	private JTextField textField;
	private JButton countButton;
	private int count = 0;
	
	public SimpleCounter() 
	{
		label = new JLabel("Counter Value:");
		textField = new JTextField(10);
		textField.setText("0");
		textField.setEditable(false); 
		
		countButton = new JButton("Count");

		countButton.addActionListener(this);
		
		setLayout(new FlowLayout());
		add(label);
		add(textField);
		add(countButton);
	}

	public void actionPerformed(ActionEvent e) 
	{
		count++;
		textField.setText(String.valueOf(count));
	}
	
	public static void main(String[] args) 
	{
		SimpleCounter frame = new SimpleCounter();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("My Frame");
		frame.setSize(350, 120);
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);
	}
}

