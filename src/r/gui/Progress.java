package r.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.beans.*;

public class Progress extends JPanel implements ActionListener, 
                                        PropertyChangeListener {

    private JProgressBar progressBar;
    private JButton startButton;
    private Task task;
    
    class Task extends SwingWorker<Void, Void>{

    		public Void doInBackground(){
    	
    			setProgress(0);
    			
    			
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignore) {}
    			setProgress(1);
    		
    			try {
                    Thread.sleep(500);
                } catch (InterruptedException ignore) {}
    			setProgress(2);
    			
    	
    			return null;
    		}
    		
            public void done() {
            
            }
    }


    public Progress() {
        super(new BorderLayout());

        //Create the demo's UI.
        startButton = new JButton("Start");
        startButton.setActionCommand("start");
        startButton.addActionListener(this);

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        JPanel panel = new JPanel();
        panel.add(startButton);
        panel.add(progressBar);

        add(panel, BorderLayout.PAGE_START);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }
    /**
     * Invoked when the user presses the start button.
     */
    public void actionPerformed(ActionEvent evt) {
    //    startButton.setEnabled(false);
     //   setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        //Instances of javax.swing.SwingWorker are not reusuable, so
        //we create new instances as needed.
        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute();
    }

    /**
     * Invoked when task's progress property changes.
     */
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            progressBar.setValue(progress);
            System.out.println(progress);
        } 
    }
    
    /**
     * Create the GUI and show it. As with all GUI code, this must run
     * on the event-dispatching thread.
     */
    public static JComponent createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ProgressBarDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new Progress();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        return newContentPane;
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
    	
    	
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
