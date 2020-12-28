package com.foundations;

import java.io.*;
import java.util.*;

public class FilesAndArrays {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		int arr[]=new int[10];
		int i=0;
		File file=new File("Values.txt");
		if(file.exists()) {
			Scanner key = new Scanner(file);
			while(key.hasNext() && i<arr.length) {
				arr[i]=key.nextInt();
				i++;
			}
			key.close();
			
		}
		System.out.println(Arrays.toString(arr));
		

	}

}
