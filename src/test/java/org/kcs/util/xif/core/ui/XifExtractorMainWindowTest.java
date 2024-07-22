package org.kcs.util.xif.core.ui;

import org.junit.jupiter.api.Test;
import org.kcs.util.xif.core.ImageReader;
import org.kcs.util.xif.core.ui.XifExtractorMainWindow;
import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class XifExtractorMainWindowTest {

    @Test
    public void testXifExtractorMainWindow() {
        // Create a mock ImageReader for testing
        ImageReader reader = new ImageReader();

        // Create an instance of XifExtractorMainWindow
        XifExtractorMainWindow mainWindow = new XifExtractorMainWindow(reader);

        // Test the frame
        JFrame frame = mainWindow.buildFrame();
        assertNotNull(frame);
        assertEquals("Xif Extractor", frame.getTitle());
        assertEquals(JFrame.EXIT_ON_CLOSE, frame.getDefaultCloseOperation());
        assertEquals(new Dimension(400, 300), frame.getSize());

     // Test the content panel
        Container contentPane = frame.getContentPane(); // get the contentPane from the frame
        assertNotNull(contentPane);
        // Get the components of the contentPane
        Component[] components = contentPane.getComponents();
        // Check if the components are not null and the length is greater than 0
        assertNotNull(components);
        if(components.length > 0) {
            // Get the first component
            Component component = components[0];
            // Check if the component is a JPanel
            assertTrue(component instanceof JPanel);
            // Cast the component to JPanel
            JPanel panel = (JPanel) component;
            // Get the components of the panel
            Component[] panelComponents = panel.getComponents();
            // Check if the panelComponents are not null and the length is greater than 0
            assertNotNull(panelComponents);
            if(panelComponents.length > 0) {
                // Get the first component of the panel
                Component panelComponent = panelComponents[0];
                // Check if the panelComponent is a JScrollPane
                assertTrue(panelComponent instanceof JScrollPane);
                // Cast the panelComponent to JScrollPane
                JScrollPane scrollPane = (JScrollPane) panelComponent;
                assertNotNull(scrollPane);
                JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();
                assertNotNull(textArea);
                assertEquals("Metadata", textArea.getText());
            }
        }
    }
}