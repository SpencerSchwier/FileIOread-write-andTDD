package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		
		File myFile = new File("alices_adventures_in_wonderland.txt");
		int wordCount = 0;
		int sentenceCount = 0;
		
		
		try (Scanner myScanner = new Scanner(myFile)) {
				
			while(myScanner.hasNextLine()) {
				String currentLine = myScanner.nextLine();
				String[] stringArray = currentLine.split(" +");
				for(String current : stringArray) {
					//System.out.println(currentLine);
					
					if (!current.equals("")) {
						wordCount++;
					
						if (current.contains(".")||current.contains("!")||current.contains("?")&&!current.contains("_")) {
							sentenceCount++;
						}
					
					}
				}
				
			}
		}
			
		catch (FileNotFoundException e) {
						
		}
		System.out.println("Word count is: " + wordCount) ;
		System.out.println("Sentence count is: " + sentenceCount) ;
		}
	}

		
