package com.epam.novik.file.ifaces.impl;

import java.io.File;
import java.io.IOException;

import com.epam.novik.file.ifaces.AbstractFileService;

public class FileManipulationService extends AbstractFileService {

	public void copyFromFileToFile(File fromFile, File toFile, String regexp)
			throws IOException {
		StringBuilder fromContent = getFileContent(fromFile);

		addContentToFile(toFile, fromContent.toString());
	}

}
