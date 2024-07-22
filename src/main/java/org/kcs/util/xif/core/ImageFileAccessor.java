package org.kcs.util.xif.core;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ImageFileAccessor {
	private static final Logger logger = LogManager.getLogger(ImageFileAccessor.class);
	private static final String TEMP_FILENAME = "thumbnail.jpg";
	private String fileName = "";

	public ImageFileAccessor(String fileName) {
		if (fileName.equals("")) {
			fileName = TEMP_FILENAME;
		} 
		else {
			this.fileName = fileName;
		}
		logger.debug("Using file {}", fileName);
	}

	public File getFile() {
		final File imageFile = new File(fileName);
		logger.debug("The file is {}", imageFile.getName());
		return imageFile;
	}
}
