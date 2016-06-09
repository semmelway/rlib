package r.gui;

/**
 * @author Robert Helmbro
 */
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GetString extends JFrame implements ActionListener { 
		
	private Object monitor;
	private ActionEvent actionEvent;
	// Labels
	private JLabel label;
	private JLabel message = new JLabel("");

	// Buttons
	private JButton cancel = new JButton("Cancel");
	private JButton next = new JButton("Next");
		
	// Text Fields
	private JTextField textField=new JTextField();
	
	
	
	int width = 150;
	int height = 20;
	int distance =30;
	int windowWidth = distance * 3 + width *2;
	int windowHeight = height * 4 + distance * 5;
	
	public GetString(String windowTitle, String labelText)
	{
		monitor = new Object();
		
		setTitle(windowTitle);
		Container c= getContentPane();
		c.setLayout(null);
		setSize(windowWidth + 4,windowHeight + 30);
			
		// **************** Labels ********
		label = new JLabel(labelText);
		c.add(label);
		label.setBounds  (distance,distance,width * 2 + distance,height);
		

		c.add(message);
		message.setBounds(distance,distance * 3 + height * 2,width*2+distance,height);

		// **************** Buttons ****************
		c.add(next);
		next.setBounds(distance * 2 + width,distance * 4 + height * 3,width,height);
		next.addActionListener(this);
		
		c.add(cancel);
		cancel.setBounds(distance,distance * 4 + height * 3,width,height);
		cancel.addActionListener(this);

		
		//**************** Text Fields ****************
		c.add(textField);
		textField.setBounds(distance,distance * 2 + height,width * 2 + distance,height);
		
		setVisible(true);
	}//konstruktor
	
	public String shoot(){
		try{
			synchronized (monitor) {
				monitor.wait();
				}
		}catch(InterruptedException ie){ie.printStackTrace();}
		setVisible(false);
		if(actionEvent.getSource() == next)
			return textField.getText();
		else
		return null;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		actionEvent = e;
		synchronized (monitor) {
			monitor.notify();
		}
		
	}//metod
	public static void main(String args[]){
		new GetString("New bundle","Enter bundle name...");
	}
}//class
