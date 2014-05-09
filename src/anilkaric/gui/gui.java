package anilkaric.gui;

/**
 * @author Rohat Anil
 * @date 20140508
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class gui extends JFrame {

	JTabbedPane tab = new JTabbedPane();
	JButton button = new JButton("button");
	JTextArea txtarea = new JTextArea(3,4);
	JTextArea txtarea2 = new JTextArea(3,3);
	JTextArea txtarea3 = new JTextArea(3,4);
	//JButton button2 = new JButton("Hallo");
	JButton button3 = new JButton("Geheimalphabet generieren: ");
	JButton button4 = new JButton("decrypt");
	JButton button5 = new JButton("Rüberall");
	JButton button6 = new JButton("encrypt");
	JPanel panel = new JPanel(); // Hauptpanel
	JPanel panel2 = new JPanel(); //Gridlayout für SOUTH
	JPanel panel3 = new JPanel(); //GridLayout für CENTER 
	//ImageIcon icon = new ImageIcon("Desktop/10171214_586514091444543_29872569_n.jpg");
	JLabel label = new JLabel("Text eingeben: ");
	JLabel label2 = new JLabel("Ausgabe: ");
	JLabel label3 = new JLabel("Keyword: ");
	
	public gui(){
		
		//Buttons und panels auf Stammpanel adden
		tab.add(panel,"Keyword");
		this.add(tab);
		panel.setLayout(new GridLayout(2,1));
		
		//Layout von 2 panels bearbeiten die wird dann unten auf unser Hauptpanel hinzufügen.
		panel2.setLayout(new GridLayout(3,1));
		panel3.setLayout(new GridLayout(6,1));
		
		//hier fügen wir unsere zwei Panel, die wir oben bearbeitet haben, auf unser Hauptpanel
		//hinzu.
		panel.add(panel2);
		panel.add(panel3);
		
		//auf dem oberen Panel geben wir ein label,textarea und ein button hinzu. 
		//Das wurde in einem Gridlayout eingestellt mit 3 Zeilen und 1 Spalte
		panel2.add(label);
		panel2.add(txtarea);
		panel2.add(button3);
		
		//Auf dem unteren Panel geben wir 2 Laben, 2 Textarea und 2 Buttons hinzu.
		//Das wurde ebenfalls in einem Gridlayout einstellt und hat 6 Zeilen und 1 Spalte.
		panel3.add(label3);
		panel3.add(txtarea2);
		panel3.add(button4);
		panel3.add(button6);
		panel3.add(label2);
		panel3.add(txtarea3);
		
		
		
		
		
		
		
		
		
		
		//Frame verwalten
		//this.add(tab);
		this.setSize(400,400);
		this.setVisible(true);
		this.setLocationRelativeTo(getParent());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main (String [] args){
		gui fenster = new gui();
	}
}
