package r.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


public class ProgressBar extends JFrame implements ActionListener, 
                                        PropertyChangeListener {

	
    private JProgressBar progressBar;
    private JButton cancel;
    private JLabel statusLabel;
    private JLabel timeLeftLabel;
    
    private int distance = 10;
    private int width = 200;
    private int height = 20;
    private int windowWidth = distance * 2 + width * 2 + 6;
    private int windowHeight = 5 * distance + 4 * height + 30;
    
    

    public ProgressBar(String message) {
    	
        Container c = getContentPane();
        c.setLayout(null);
		setSize(windowWidth, windowHeight);
		setTitle("myDiskBackup");
		setLocationRelativeTo(null);
		setResizable(false);
		//setAlwaysOnTop(true);

        cancel = new JButton("Cancel");


        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setString("");
        progressBar.setStringPainted(true);
        
        statusLabel = new JLabel(message);
        timeLeftLabel = new JLabel();
        
  
        
       c.add(statusLabel);
       statusLabel.setBounds(distance, distance, width * 2, height);
       c.add(timeLeftLabel);
       timeLeftLabel.setBounds(distance, 2 * distance + height, width * 2, height);
       
       c.add(progressBar);
       progressBar.setBounds(distance, 3* distance + 2 * height, width * 2, height);
       
        c.add(cancel);
        cancel.setBounds(distance + width, 4* distance + 3 * height, width, height);
        cancel.addActionListener(this);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent evt) {

    	if(evt.getSource() == cancel){
    		setVisible(false);
    	}
    }

    /**
     * Invoked when task's progress property changes.
     */
    public void propertyChange(PropertyChangeEvent evt) {
    	if(evt.getPropertyName() == "message"){
    		statusLabel.setText((String)evt.getNewValue());
    		if(progressBar.getValue() == 0){
    			progressBar.setIndeterminate(true);
    		}
    	}
    	if(evt.getPropertyName() == "progress"){
    	int progress = (Integer) evt.getNewValue();
    	//System.out.println("progress = " + progress);
    	if(progress == 100){
    		setVisible(false);
    	}else if(progress == 0){
    		setVisible(true);
    		progressBar.setValue(0);
    	}else{
    		progressBar.setIndeterminate(false);
    		progressBar.setValue(progress);
    	}
    	}
    }
    
    /**
     * Create the GUI and show it. As with all GUI code, this must run
     * on the event-dispatching thread.
     */
    public static ProgressBar createAndShowGUI(String message) {
    	ProgressBar progress = new ProgressBar(message);
        return (ProgressBar)progress;
    }
}
