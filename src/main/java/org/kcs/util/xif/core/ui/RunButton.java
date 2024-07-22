package org.kcs.util.xif.core.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import org.kcs.util.xif.core.ImageReader;

public class RunButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8660525141119725126L;

	public RunButton(final ImageReader reader, final JTextArea textArea) {
		super("Run");
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(reader.showOff());
			}
		});
	}
}
