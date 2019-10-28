package org.kcs.util.xif.core;

import java.io.File;
import java.io.IOException;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public class ImageReader {

	private File sourceFile;

	public ImageReader(File imageFile) {
		this.sourceFile = imageFile;
	}
	
	public ImageReader() {
	}

	public String showOff() {
		String output = "";
		if (sourceFile != null) {
			Metadata metaData;
			try {
				metaData = ImageMetadataReader.readMetadata(sourceFile);
				output = outputMetaData(metaData);
			} catch (ImageProcessingException e) {
				System.out.println("Image Processing Exception");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("IOException");
				e.printStackTrace();
			}

		}
		return output;
	}
	
	public void setFile (File file) {
		this.sourceFile = file;
		System.out.println("File is set.");
	}

	private String outputMetaData(Metadata metaData) {
		System.out.println("Any directories?");
		String outputString = "";
		for (Directory directory : metaData.getDirectories()) {
			for (Tag tag : directory.getTags()) {
				outputString = outputString + String.format("[%s] - %s = %s", directory.getName(), tag.getTagName(), tag.getDescription() + "\n");
//				System.out.format("[%s] - %s = %s", directory.getName(), tag.getTagName(), tag.getDescription());
//				System.out.println("\n");
			}
			if (directory.hasErrors()) {
				for (String error : directory.getErrors()) {
					System.err.format("ERROR: %s", error);
				}
			}
		}
		System.out.println(outputString);
		return outputString;
	}
}
