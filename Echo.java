

import jdsl.core.api.*;
import jdsl.core.ref.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class Echo extends Frame implements ActionListener, WindowListener
{


private  Sequence getWords (String s) {
    Sequence ret = new ArraySequence();
    StringTokenizer  st = new StringTokenizer(s);
    while (st.hasMoreTokens() )  {
            ret.insertLast(st.nextToken() );
    }
    return ret;
}
private   String concatenate(Sequence s) {
    String ret = "";
    for (ObjectIterator i=s.elements(); i.hasNext(); )
        ret += (i.nextObject() + " " );
    return ret;
}

Sequence seq;

Label title = new Label( "Echo" );
TextField inField = new TextField( "", 50 );
TextField outField = new TextField( "", 50 );
Button quitBtn = new Button("Quit");

public Echo() {
      setUpWindow();
}


public void actionPerformed(ActionEvent e) {
        //The user entered text.  
        if (e.getSource()==inField) {
	        String in = inField.getText();
	        //converts the string into a sequence of words
	        seq = getWords(in);
	        //outputs the words.
	        outField.setText(concatenate(seq));
	    // The user clicked the quit button.    
	    } else if (e.getSource()==quitBtn)
            quit();
}

public static void main( String args[]) {
    Echo e = new Echo();
    e.show();
    //String str = "this is a test case" ;
    //System.out.println("words are" +  e.concatenate(e.getWords(str) ) );
}


private void setUpWindow() {
        setTitle("Echo");
        title.setFont( new Font( "Helvetica", Font.BOLD , 24 ) );
        Panel titlePanel = new Panel();
        titlePanel.add(title);

        Panel inPanel = new Panel();
        inPanel.add(new Label("Enter a sentence"));
        inPanel.add(inField);

        outField.setEditable(false);
        Panel outPanel = new Panel();
        outPanel.add(new Label("Result"));
        outPanel.add(outField);

        Panel centerPanel = new Panel();
        centerPanel.add(inPanel);
        centerPanel.add(outPanel);

        Panel btnPanel = new Panel();
        btnPanel.add(quitBtn);

        add(titlePanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
        
        addWindowListener(this);
        quitBtn.addActionListener(this);
        inField.addActionListener(this);
        inField.requestFocus();

	setSize(500,250);
	setLocation(50,50);
}

private void quit() {
        System.exit(0);
}
 
    public void windowActivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {quit();}
    public void windowClosing(WindowEvent e) {quit();}
    public void windowDeactivated(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}    


}