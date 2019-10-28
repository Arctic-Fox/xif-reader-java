package org.kcs.util.xif.core.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.kcs.util.xif.core.ImageReader;

public class XifExtractorMainWindow {
	
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 300;

	public XifExtractorMainWindow(ImageReader reader) {
		JFrame frame = buildFrame();
		frame.setLayout(new GridLayout(3,2));
		
		frame.addWindowListener(new WindowAdapter() {
	          public void windowClosing(WindowEvent windowEvent){
	             System.exit(0);
	          }        
	       });  
		
		final JPanel labelPanel = new JPanel();
		JLabel fileNameLabel = new JLabel(" ", JLabel.CENTER);
		fileNameLabel.setSize(100,50);
		
		JTextArea textArea = new JTextArea("Metadata");
		JScrollPane scrollPane = new JScrollPane(textArea);
//		labelPanel.add(fileNameLabel);
//		
		final JPanel comboPanel = new JPanel();
		comboPanel.add(new ImageChooserButton(reader, fileNameLabel), BorderLayout.NORTH);
		comboPanel.add(new RunButton(reader, textArea), BorderLayout.SOUTH);

		frame.add(fileNameLabel);
		frame.add(comboPanel);
		frame.add(scrollPane);

		frame.setVisible(true);
	}
	
	private JFrame buildFrame() {
		JFrame frame = new JFrame();
		frame.setTitle("Xif Extractor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
//		frame.pack();
		return frame;
	}
	

	
}
