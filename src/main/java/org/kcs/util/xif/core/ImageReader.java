package org.kcs.util.xif.core;

import java.io.File;

import java.io.IOException;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ImageReader {

	private static final Logger logger = LogManager.getLogger(ImageReader.class);
	private File sourceFile;
    private Metadata metadata;

    public ImageReader(Metadata metadata) {
        this.metadata = metadata;
    }

	public ImageReader(File imageFile) {
		this.sourceFile = imageFile;
	}
	
	public ImageReader() {
	}
	
    public String showOff() {
        String output = "";
        if (metadata == null) {
            try {
                metadata = readMetadata(sourceFile);
            } catch (ImageProcessingException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (metadata != null) {
            output = outputMetaData(metadata);
        }
        return output;
    }
	
	public void setFile (File file) {
		this.sourceFile = file;
		logger.debug("File is set.");
	}

	private String outputMetaData(Metadata metaData) {
		logger.debug("Any directories?");
		String outputString = "";
		for (Directory directory : metaData.getDirectories()) {
			for (Tag tag : directory.getTags()) {
				outputString = outputString + String.format("[%s] - %s = %s", directory.getName(), tag.getTagName(), tag.getDescription() + "\n");
			}
			if (directory.hasErrors()) {
				for (String error : directory.getErrors()) {
					logger.error("ERROR: %s", error);
				}
			}
		}
		return outputString;
	}
	
	public File getSourceFile() {
	    return sourceFile;
	}
	
    public Metadata readMetadata(File file) throws ImageProcessingException, IOException {
        return ImageMetadataReader.readMetadata(file);
    }
}
