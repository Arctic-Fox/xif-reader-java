package org.kcs.util.xif.core;

import java.io.File;

public class ImageFileAccessor {
	
	private static final String TEMP_FILENAME = "/home/arcticfox/Pictures/minis/20190831_224523.jpg";
	private String fileName = "";

	public ImageFileAccessor(String fileName) {
		if (fileName.equals("")) {
			fileName = TEMP_FILENAME;
		} 
		else {
			this.fileName = fileName;
		}
		System.out.println("Using file " + fileName);
	}

	public File getFile() {
		final File imageFile = new File(fileName);
		System.out.println("The file is " + imageFile.getName());
		return imageFile;
	}
}
