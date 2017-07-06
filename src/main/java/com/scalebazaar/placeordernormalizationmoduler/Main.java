package com.scalebazaar.placeordernormalizationmoduler;

import java.util.ArrayList;

//import java.io.FileNotFoundException;

public class Main {


    
    
	public static void main(String args[]){
		System.out.println("hi");
		Utils obUtils = new Utils();
		CovertToDifferentClients obCovertToDifferentClients = new CovertToDifferentClients();
		/*try {
			obUtils.readCSV();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		ArrayList<String [] > row = obUtils.readCsvLineByLine("abc" , "ab");
		obCovertToDifferentClients.covertToScalelabs(row);
	}

}
