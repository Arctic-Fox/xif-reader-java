package org.kcs.util.xif.core.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileSystemView;

import org.kcs.util.xif.core.ImageReader;

public class ImageChooserButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1392291180133218922L;

	public ImageChooserButton(ImageReader reader, JLabel fileNameLabel) {
		super("Choose Image File");
		
		this.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                int returnValue = fileChooser.showOpenDialog(null);
                
        		if (returnValue == JFileChooser.APPROVE_OPTION) {
        			File selectedFile = fileChooser.getSelectedFile();
        			System.out.println(selectedFile.getAbsolutePath());
        			fileNameLabel.setText(selectedFile.getName());
        			reader.setFile(selectedFile);
        		}
            }
        });
	}
	
}
