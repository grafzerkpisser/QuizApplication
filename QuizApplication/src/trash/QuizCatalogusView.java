package trash;

//import GuiTest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utils.QuizCatalogus;



//SWING
import javax.swing.*;

public class QuizCatalogusView extends JPanel{
	JList list;
	DefaultListModel overzicht;
	int aantalQuizen=10;
	
	public void ListModelExample()
		{
		 setLayout(new BorderLayout());
		    overzicht = new DefaultListModel();
		    list = new JList(overzicht);
		    JScrollPane pane = new JScrollPane(list);
		    JButton addButton = new JButton("Voeg quiz toe");
		    JButton removeButton = new JButton("Verwijder quiz");
		    for (int i = 0; i< aantalQuizen; i++ )
		    	overzicht.addElement("Quiz" + i	);
		    addButton.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		          overzicht.addElement("Element " + aantalQuizen);
		          aantalQuizen++;
		        }
		      });
		    removeButton.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		          if (overzicht.getSize() > 0)
		            overzicht.removeElementAt(0);
		        }
		      });
		    add(pane, BorderLayout.NORTH);
		    add(addButton, BorderLayout.WEST);
		    add(removeButton, BorderLayout.EAST);
		    	
		}
	public static void main(String s[]) {
	    JFrame frame = new JFrame("List Model Example");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setContentPane(new QuizCatalogusView());
	    frame.setSize(260, 200);
	    frame.setVisible(true);
	  }
	}
	

	

