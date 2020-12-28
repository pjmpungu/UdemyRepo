package com.foundations;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.swing.JOptionPane;

import javax.swing.*;

public class HelloWorld {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter pw= new PrintWriter("output.txt");
		pw.println("Line 1");
		pw.println("Line 2");
		pw.println("Line 3");
		pw.close();
		File file=new File("output.txt");
		if(file.exists()) {
			Scanner key=new Scanner(file);
			while(key.hasNext()) {
				System.out.println(key.nextLine());
			}
			key.close();
		}
		

	}

}
