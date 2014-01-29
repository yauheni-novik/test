package com.epam.novik.file.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {

private final static String LINE_SEPARATOR_KEY = "line.separator";
	
	public static void appendToFile(File file, String content, String regexp) throws IOException{
		FileWriter fileWritter = new FileWriter(file, true);
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        content = applyRegexp(content, regexp);
        bufferWritter.write(content);
        bufferWritter.close();
	}
	
	public static StringBuilder concatLines(File file) throws FileNotFoundException{
		Scanner scanner = new Scanner(new FileInputStream(file));
		try{
			StringBuilder result = new StringBuilder();
			while(scanner.hasNextLine()){
				result.append(scanner.nextLine());
				if(scanner.hasNextLine()){
					result.append(System.getProperty(LINE_SEPARATOR_KEY));
				}
			}
			return result;
		}finally{
			scanner.close();
		}
	}
	
	private static String applyRegexp(String content, String regexp){
		StringBuilder res = new StringBuilder();
		
		Pattern pattern = Pattern.compile(regexp);
	    // in case you would like to ignore case sensitivity,
	    // you could use this statement:
	    // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(content);
		
	    while(matcher.find()){
	    	res.append(matcher.group(1)).append(" - ").append(matcher.group()).append(System.getProperty(LINE_SEPARATOR_KEY));	    	
	    }
	    
		return res.toString();
	}
}
