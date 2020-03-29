/**
 * Reads a chosen CSV file of country exports and prints each country that exports coffee.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {
	public void listExporters(CSVParser parser, String exportOfInterest) {
		//for each row in the CSV File
		for (CSVRecord record : parser) {
			//Look at the "Exports" column
			String export = record.get("Exports");
			//Check if it contains exportOfInterest
			if (export.contains(exportOfInterest)) {
				//If so, write down the "Country" from that row
				String country = record.get("Country");
				System.out.println(country);
			}
		}
	}

	public void whoExportsCoffee() {
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		listExporters(parser, "coffee");
	}

	public void tester(){
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		listExportersTwoProducts(parser,"cotton","flowers");
		parser = fr.getCSVParser();
		System.out.println(countryInfo(parser,"Nauru"));
		parser = fr.getCSVParser();
		System.out.println(numberOfExporters(parser,"cocoa"));
		parser = fr.getCSVParser();
		countriesValueMore(parser , "$999,999,999,999");


	}

	public String countryInfo(CSVParser parser, String country){
		for(CSVRecord record: parser){
			if (record.get("Country").contains(country)){
				return (record.get("Country")+": "+record.get("Exports")+": "+record.get("Value (dollars)"));
			}
		}

		return "NOT FOUND";

	}

	public void listExportersTwoProducts(CSVParser parser,String exportItem1, String exportItem2){
		for(CSVRecord record: parser){

			if (record.get("Exports").contains(exportItem1) && record.get("Exports").contains(exportItem2)){
				System.out.println((record.get("Country")));
			}
		}


	}

	public int numberOfExporters(CSVParser parser,String exportitem){
		int count=0;
		for(CSVRecord record:parser){
			if(record.get("Exports").contains(exportitem)){
				count++;
			}
		}
		return count;
	}

	public void countriesValueMore(CSVParser parser,String value){
		System.out.println("countries with export values greater than : "+value);
		for(CSVRecord record: parser){
			String gvalue=record.get("Value (dollars)");
			gvalue=gvalue.replace("$","").replace(",","");
			value = value.replace("$","").replace(",","");

			if(Long.parseLong(gvalue)>Long.parseLong(value)){
				System.out.println(record.get("Country"));
			}
		}
	}

	public static void main(String[] args) {
		WhichCountriesExport wch = new WhichCountriesExport();
		wch.tester();


	}
}
