package Week3.hottestTempManyRefactored; /**
 * Find the highest (hottest) temperature in any number of files of CSV weather data chosen by the user.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CSVMax {
	public CSVRecord hottestHourInFile(CSVParser parser) {
		//start with largestSoFar as nothing
		CSVRecord largestSoFar = null;
		//For each row (currentRow) in the CSV File
		for (CSVRecord currentRow : parser) {
			// use method to compare two records
			largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
		}
		//The largestSoFar is the answer
		return largestSoFar;
	}

	public CSVRecord coldestHourInFile(CSVParser parser) {

		CSVRecord smallestSoFar = null;
		for (CSVRecord currentRow : parser) {
			// use method to compare two records
			smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar);
		}
		return smallestSoFar;
	}

	public String fileWithColdestTemperature () {
		CSVRecord smallestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		String Fname="";
		CSVRecord temp;
		// iterate over files
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
			temp = smallestSoFar;
			smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar);
			if(temp != smallestSoFar){
				Fname=f.getName();
			}
		}
		//The largestSoFar is the answer
		return Fname;
	}

	public CSVRecord hottestInManyDays() {
		CSVRecord largestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		// iterate over files
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			// use method to get largest in file.
			CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
			// use method to compare two records
			largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
		}
		//The largestSoFar is the answer
		return largestSoFar;
	}

	public CSVRecord lowestHumidityInManyFiles () {
		CSVRecord smallestSoFar = null;
		DirectoryResource dr = new DirectoryResource();
		CSVRecord temp;
		// iterate over files
		for (File f : dr.selectedFiles()) {
			FileResource fr = new FileResource(f);
			CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
			temp = smallestSoFar;
			smallestSoFar = getSmallestHumidOfTwo(currentRow, smallestSoFar);

		}

		return smallestSoFar;
	}

	public CSVRecord lowestHumidityInFile(CSVParser parser){
		CSVRecord smallestSoFar = null;
		for (CSVRecord currentRow : parser) {
			// use method to compare two records
			smallestSoFar = getSmallestHumidOfTwo(currentRow, smallestSoFar);
		}
		return smallestSoFar;

	}

	public double averageTemperatureInFile(CSVParser parser){
		int count=0;
		double sum=0;
		for(CSVRecord record:parser){
			count++;
			sum+= Double.parseDouble(record.get("TemperatureF"));
		}
		return sum/count;
	}

	public double averageTemperatureWithHighHumidityInFile(CSVParser parser,int value){


		int count=0;
		double sum=0;
		for(CSVRecord record:parser){

			if(Integer.parseInt(record.get("Humidity"))>=value) {
				count++;
				sum += Double.parseDouble(record.get("TemperatureF"));
			}
		}
		return sum/count;

	}

	public CSVRecord getLargestOfTwo (CSVRecord currentRow, CSVRecord largestSoFar) {
		//If largestSoFar is nothing
		if (largestSoFar == null) {
			largestSoFar = currentRow;
		}
		//Otherwise
		else {
			double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
			double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
			//Check if currentRow’s temperature > largestSoFar’s
			if (currentTemp > largestTemp) {
				//If so update largestSoFar to currentRow
				largestSoFar = currentRow;
			}
		}
		return largestSoFar;
	}

	public CSVRecord getSmallestOfTwo (CSVRecord currentRow, CSVRecord smallestSoFar) {

		if (smallestSoFar == null) {
			smallestSoFar = currentRow;
		}
		//Otherwise
		else {
			double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
			double smallestTemp = Double.parseDouble(smallestSoFar.get("TemperatureF"));
			//Check if currentRow’s temperature > largestSoFar’s
			if (currentTemp < smallestTemp && currentTemp!=-9999) {
				//If so update largestSoFar to currentRow
				smallestSoFar = currentRow;
			}
		}
		return smallestSoFar;
	}

	public CSVRecord getSmallestHumidOfTwo(CSVRecord currentRow, CSVRecord smallestSoFar){
		if (!currentRow.get("Humidity").equals("N/A")) {
			if (smallestSoFar == null) {
				smallestSoFar = currentRow;
			}
			//Otherwise
			else {
				double currentHumid = Double.parseDouble(currentRow.get("Humidity"));
				double smallestHumid = Double.parseDouble(smallestSoFar.get("Humidity"));
				//Check if currentRow’s temperature > largestSoFar’s
				if (currentHumid < smallestHumid) {
					//If so update smallestsofar to currentRow
					smallestSoFar = currentRow;
				}
			}
		}
		return smallestSoFar;
	}

	public void testHottestInDay () {
		FileResource fr = new FileResource("data/2015/weather-2015-01-01.csv");
		CSVRecord largest = hottestHourInFile(fr.getCSVParser());
		System.out.println("hottest temperature was " + largest.get("TemperatureF") +
				" at " + largest.get("TimeEST"));
	}

	public void testColdestHourInFile () {
		FileResource fr = new FileResource();
		CSVRecord smallest = coldestHourInFile(fr.getCSVParser());
		//System.out.println("coldest temperature was " + smallest.get("TemperatureF") +
		//		" at " + smallest.get("TimeEST"));
		System.out.println("coldest temperature was " + smallest.get("TemperatureF") +
				" at " + smallest.get("TimeEDT"));
	}

	public void testLowestHumidityInFile(){
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		CSVRecord csv = lowestHumidityInFile(parser);
		System.out.println("Lowest Humidity was "+csv.get("Humidity") +" at "+csv.get("DateUTC"));
	}

	public void testFileWithColdestTemperature(){
		String fName=fileWithColdestTemperature();
		System.out.println("Coldest day was in file "+fName);
		FileResource parser = new FileResource("./Java1/Week3/hottestTempManyRefactored/data/2013/"+fName);
		CSVRecord record = coldestHourInFile(parser.getCSVParser());
		System.out.println("Coldest temperature on that day was "+record.get("TemperatureF"));
		parser = new FileResource("./Java1/Week3/hottestTempManyRefactored/data/2013/"+fName);
		for(CSVRecord record1:parser.getCSVParser()){
			System.out.println(record1.get("DateUTC")+" : "+record1.get("TemperatureF"));
		}

	}

	public void testHottestInManyDays () {
		CSVRecord largest = hottestInManyDays();
		System.out.println("hottest temperature was " + largest.get("TemperatureF") +
				   " at " + largest.get("DateUTC"));

	}

	public void testAverageTemperatureInFile () {
		FileResource fr= new FileResource();
		CSVParser parser = fr.getCSVParser();
		double average = averageTemperatureInFile(parser);
		System.out.println("Average temperature in file is  "+average);

	}

	public void testLowestHumidityInManyFiles () {
		CSVRecord lowesthumid = lowestHumidityInManyFiles();
		System.out.println("Lowest Humidity was "+lowesthumid.get("Humidity") +" at "+lowesthumid.get("DateUTC"));

	}

	public void testAverageTemperatureWithHighHumidityInFile(){
		FileResource fr = new FileResource();
		double average = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(),80);
		if (average>0){
			System.out.println("Average Temp when high Humidity is "+average);
		}
		else{
			System.out.println("No temperatures with that humidity");
		}

	}

	public static void main(String[] args) {
		CSVMax obj = new CSVMax();
		//obj.testColdestHourInFile();
		//System.out.println(obj.fileWithColdestTemperature());
		obj.testFileWithColdestTemperature();
		//obj.testLowestHumidityInFile();
		//obj.testLowestHumidityInManyFiles();
		//obj.testAverageTemperatureInFile();
		//obj.testAverageTemperatureWithHighHumidityInFile();
		//String currentDirectory = System.getProperty("user.dir");
		//System.out.println("The current working directory is " + currentDirectory);
	}
}
