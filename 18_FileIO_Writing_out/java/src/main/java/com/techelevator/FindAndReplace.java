package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Enter the name of the source file: ");
		String sourceFileName = userInput.nextLine();
		File sourceFile = new File(sourceFileName);

		
		if (sourceFile.exists() && sourceFile.isFile()) {
			
			System.out.println("Enter the new file name to be created: ");
			String destFileName = userInput.nextLine();
			File destFile = new File(destFileName);
			
			System.out.println("Enter the word to be replaced: ");
			String oldWord = userInput.nextLine();
			
			System.out.println("Enter the new word: ");
			String newWord = userInput.nextLine();
			
			
			try (Scanner sourceScanner = new Scanner (sourceFile)) {
				if (destFile.exists() == false) {
						destFile.createNewFile();  
				}		
						try (PrintWriter destWriter = new PrintWriter(destFile)) {
							while (sourceScanner.hasNextLine()) {
								String line = sourceScanner.nextLine();
								if (line.contains(oldWord)) {
								line = line.replace(oldWord, newWord);
								}
								
								destWriter.println(line);
								
							}
						}
					
			} catch(FileNotFoundException e) {
				System.out.println(sourceFileName + " does not exist!");
			}				
			catch (IOException e) {
				e.printStackTrace();
				
				}
				
			} 
						
		}
	
	}


