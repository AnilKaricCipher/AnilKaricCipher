package anilkaric.test;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;

import org.junit.Test;

import anilkaric.MyException;
import anilkaric.gui.CipherController;

public class TestCipherController {

	@Test
	public void controllerTest() throws MyException {
			CipherController f = new CipherController();
			JButton b = new JButton("hallo");
			b.setActionCommand("ver");
			ActionEvent g = new ActionEvent(b, 0, null);
			f.actionPerformed(g);
			JComboBox h = new JComboBox();
			ItemEvent i = new ItemEvent(h, 0, null, 0);
			f.itemStateChanged(i);
	}

}
