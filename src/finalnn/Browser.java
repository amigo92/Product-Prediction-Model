/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalnn;

/**
 *
 * @author DELL
 */


import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;

/*
 * Browser.java uses these files:
 *   images/Open16.gif
 *   images/Save16.gif
 */

public class Browser extends JPanel
                             implements ActionListener {
    static JFrame frame = new JFrame("Browse");
    static int flag;
    static private final String newline = "\n";
    JButton openButton, saveButton;
    JTextArea log;
    JFileChooser fc;

    public Browser() {
        super(new BorderLayout());

        //Create the log first, because the action listeners
        //need to refer to it.
        log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        //Create a file chooser
        fc = new JFileChooser();

        //Uncomment one of the following lines to try a different
        //file selection mode.  The first allows just directories
        //to be selected (and, at least in the Java look and feel,
        //shown).  The second allows both files and directories
        //to be selected.  If you leave these lines commented out,
        //then the default mode (FILES_ONLY) will be used.
        //
        //fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        //Create the open button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
       // openButton = new JButton("Open a File...",
          //                       createImageIcon("images/Open16.gif"));
        //openButton.addActionListener(this);

        //Create the save button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        saveButton = new JButton("Save a File...");
        saveButton.addActionListener(this);

        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
       // buttonPanel.add(openButton);
        buttonPanel.add(saveButton);

        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {

        //Handle open button action.
        //if (e.getSource() == openButton) {
          //  int returnVal = fc.showOpenDialog(Browser.this);

            //if (returnVal == JFileChooser.APPROVE_OPTION) {
              //  File file = fc.getSelectedFile();
                /////This is where a real application would open the file.
                //log.append("Opening: " + file.getName() + "." + newline);
                  
            //else {
              //  log.append("Open command cancelled by user." + newline);
            //}
            //log.setCaretPosition(log.getDocument().getLength());

        //Handle save button action.
         if (e.getSource() == saveButton) {
            int returnVal = fc.showSaveDialog(Browser.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would save the file.
                log.append("Saving: " + file.getName() + "." + newline);
                 ButtonListener.setFile(file);
                //System.exit(flag);
                frame.setVisible(false);
            } else {
                log.append("Save command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
        }
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Browser.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
           // System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
     static void createAndShowGUI() {
        //Create and set up the window.
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new Browser());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
      //  if(flag==1){frame.setVisible(false);} 
    }

    public static void main() {
        createAndShowGUI();
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
       /* SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE); 
                createAndShowGUI();
            }
        });*/
        //return 0;
    }
}