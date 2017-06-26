package com.scalebazaar.placeordernormalizationmoduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {


    public static void readCSV() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/ADMINIBM/abc.csv"));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            System.out.print(scanner.next()+"|");
        }
        scanner.close();
    }

	public static void main(String args[]){
		System.out.println();
	}

}
