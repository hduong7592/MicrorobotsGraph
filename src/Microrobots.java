import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;

public class Microrobots extends JPanel {

	
    
    public Microrobots(JFrame frame) {
		
        this.setLayout(new GridLayout(1,1));
		this.add(new GridBoard());
		
	}
    	
	
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Application
    //
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Micro Robots");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(new Microrobots(frame), BorderLayout.CENTER);
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
}
