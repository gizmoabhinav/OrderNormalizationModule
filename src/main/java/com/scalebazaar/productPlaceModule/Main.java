package com.scalebazaar.productPlaceModule;

import com.scalebazaar.productscema.ProductScemaScalelabs;
import com.scalebazaar.productscema.RuleFile;

//import java.io.FileNotFoundException;

public class Main {


    
    
	public static void main(String args[]){
		/*System.out.println("hi");
		Utils obUtils = new Utils();
		CovertToDifferentClients obCovertToDifferentClients = new CovertToDifferentClients();
		try {
			obUtils.readCSV();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String [] > row = obUtils.readCsvLineByLine("abc" , "ab");
		obCovertToDifferentClients.covertToScalelabs(row);
		*/RuleFile objRulefile = new RuleFile();
		objRulefile.genRuleFile("amazon");
		System.out.println();
		objRulefile.genRuleFile("ebay");
		System.out.println();
		objRulefile.genRuleFile("lazada");
		System.out.println();
		objRulefile.genRuleFile("11street");
		System.out.println();
		ProductScemaScalelabs objProductScemaScalelabs = new ProductScemaScalelabs();
		objRulefile.genRuleFile(objProductScemaScalelabs.getMap());
		
		
	}

}
