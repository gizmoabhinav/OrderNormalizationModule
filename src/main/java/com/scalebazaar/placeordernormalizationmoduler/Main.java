package com.scalebazaar.productPlaceModule;

import java.util.ArrayList;
import java.util.Arrays;

import com.scalebazaar.productscema.ProductScemaLazada;
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
		RuleFile objRulefile = new RuleFile();
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
*/
		ProductScemaScalelabs objProductScemaScalelabs = new ProductScemaScalelabs();
		Utils utilob = new Utils();
		ArrayList<String[]> arli = new ArrayList<>();
		arli = utilob.readCsvLineByLine();
		for(int i = 0 ; i < arli.size(); i++){
			System.out.println(Arrays.asList(arli.get(i)));
		}
		System.out.println(arli.get(0).length);
		ProductScemaLazada psl = new ProductScemaLazada();
		ArrayList<Long> li = new ArrayList<>();
		for(int i=0 ; i<arli.get(0).length; i++){
			psl.set(arli.get(0)[i], arli.get(1)[i]);
		}
		System.out.println(psl.toString());
		//@TODO check if all elements are same as in the csv
		System.out.println(psl.getElements());
		RestEndpoint oRep = new RestEndpoint();
		li = oRep.queryCategoryId();
		
		
//		System.out.println(li.toString());
//		oRep.queryCategoryId();
//		
//		for(long a : li){
//			oRep.GetCategoryAttribute(a);
//		}
//		createLazadaAttributes(psl, long CategoryId);
		
	}}