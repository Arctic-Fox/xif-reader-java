package org.kcs.util.xif.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kcs.util.xif.core.ImageReader;
import org.kcs.util.xif.core.ui.XifExtractorMainWindow;

public class XifEditor {
	
	private static final Logger logger = LogManager.getLogger(XifEditor.class);

	public static void main(String[] args) {
		logger.debug("Let's open it....");
		ImageReader reader = new ImageReader();
		@SuppressWarnings("unused")
		XifExtractorMainWindow window = new XifExtractorMainWindow(reader);
	}

}
