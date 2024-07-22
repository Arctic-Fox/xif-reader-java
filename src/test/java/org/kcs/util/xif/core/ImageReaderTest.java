package org.kcs.util.xif.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

public class ImageReaderTest {
	
	@BeforeEach
	public void init() {
	    MockitoAnnotations.initMocks(this);
	}

    @Test
    public void testShowOffWithValidFile() {
        Metadata metadata = mock(Metadata.class);
        Directory directory = mock(Directory.class);
        Tag tag = mock(Tag.class);

        when(metadata.getDirectories()).thenReturn(Arrays.asList(directory));
        when(directory.getTags()).thenReturn(Arrays.asList(tag));
        when(directory.getName()).thenReturn("testDirectory");
        when(tag.getTagName()).thenReturn("testTag");
        when(tag.getDescription()).thenReturn("testDescription");

        ImageReader imageReader = new ImageReader(metadata);
        String output = imageReader.showOff();

        assertEquals("[testDirectory] - testTag = testDescription\n", output);
    }

    @Test
    public void testShowOffWithInvalidFile() {
        File file = new File("invalid_file.jpg"); // Use a real file object
        ImageMetadataReader imageMetadataReader = mock(ImageMetadataReader.class);
        
        try {
            when(imageMetadataReader.readMetadata(file)).thenThrow(new ImageProcessingException("Test Exception"));
        } catch (ImageProcessingException | IOException e) {
            // Handle the exception
        }
        
        ImageReader imageReader = new ImageReader(file) {
            @Override
            public Metadata readMetadata(File file) throws ImageProcessingException, IOException {
                if (file == null) {
                    throw new NullPointerException("File cannot be null");
                }
                return imageMetadataReader.readMetadata(file);
            }
        };

        assertThrows(RuntimeException.class, () -> imageReader.showOff());
    }

    @Test
    public void testSetFile() {
        File file = mock(File.class);
        ImageReader imageReader = new ImageReader();
        imageReader.setFile(file);

        assertEquals(file, imageReader.getSourceFile());
    }
}