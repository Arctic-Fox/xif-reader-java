package org.kcs.util.xif.core.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
        frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout()); // Set the layout to BorderLayout

        JLabel fileNameLabel = new JLabel(" ", JLabel.CENTER);
        fileNameLabel.setPreferredSize(new Dimension(100, 50));

        JTextArea textArea = new JTextArea("Metadata");
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        RunButton runButton = new RunButton(reader, textArea);
        ImageChooserButton imageChooserButton = new ImageChooserButton(reader, fileNameLabel);
        
        contentPanel.add(imageChooserButton, BorderLayout.PAGE_START);
        contentPanel.add(runButton, BorderLayout.PAGE_END);
        contentPanel.add(fileNameLabel, BorderLayout.NORTH);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        frame.getContentPane().add(contentPanel);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                frame.dispose();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    protected JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Xif Extractor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        return frame;
    }
}