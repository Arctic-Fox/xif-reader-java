package org.kcs.util.xif.main;

import java.io.File;

import org.kcs.util.xif.core.ImageFileAccessor;
import org.kcs.util.xif.core.ImageReader;
import org.kcs.util.xif.core.ui.XifExtractorMainWindow;

public class XifEditor {
	
	private static String fileName = "";

	public static void main(String[] args) {
		


		if (args.length > 0) {
			System.out.println("Got parameter " + args[0]);
			fileName = args[0];
		}
		System.out.println("Let's try it...");
//		ImageFileAccessor fileAccessor = new ImageFileAccessor(fileName);
//		File image = fileAccessor.getFile();
		System.out.println("Now let's open it....");
//		ImageReader reader = new ImageReader(image);
		ImageReader reader = new ImageReader();
//		reader.showOff();
		XifExtractorMainWindow window = new XifExtractorMainWindow(reader);
		
		
	}

}
