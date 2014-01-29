package com.epam.novik.runner;

import java.io.File;
import java.io.IOException;

import com.epam.novik.file.ifaces.AbstractFileService;
import com.epam.novik.file.ifaces.impl.FileManipulationService;

public class Runner {
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(Runner.class);

	public static void main(String[] args) {
		File fromFile = new File("files/from.txt");
		File toFile = new File("files/to.txt");
		try {
			AbstractFileService fileService = new FileManipulationService();
			fileService.copyFromFileToFile(fromFile, toFile, "");
			log.info("DONE");
		} catch (IOException e) {
//			log.error("Error occured while appendig file content from file "
//					+ fromFile.getName() + " to file " + toFile.getName() + ":\n" + e.getMessage(), e);
		}
	}
}
