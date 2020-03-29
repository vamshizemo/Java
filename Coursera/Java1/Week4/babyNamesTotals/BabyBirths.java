
/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;

public class BabyBirths {
	public void printNames () {
		FileResource fr = new FileResource();
		totalBirths(fr);
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			if (numBorn <= 100) {
				System.out.println("Name " + rec.get(0) +
						   " Gender " + rec.get(1) +
						   " Num Born " + rec.get(2));
			}
		}
	}

	public void totalBirths (FileResource fr) {
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;
			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
			}
			else {
				totalGirls += numBorn;
			}
		}
		System.out.println("total births = " + totalBirths);
		System.out.println("female girls = " + totalGirls);
		System.out.println("male boys = " + totalBoys);
	}

	public void totalNames (FileResource fr) {
		int totalNames = 0;
		int totalBoysNames = 0;
		int totalGirlsNames = 0;
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalNames += numBorn;
			if (rec.get(1).equals("M")) {
				totalBoysNames += 1;
			}
			else {
				totalGirlsNames += 1;
			}
		}
		System.out.println("total births = " + totalNames);
		System.out.println("female names = " + totalGirlsNames);
		System.out.println("male names = " + totalBoysNames);
	}

	public int getRank(int year, String name,String gender){
		int rank=0;
		//FileResource fr=new FileResource("Java1/Week4/babyNamesTotals/testing/yob"+year+"short.csv");
		FileResource fr=new FileResource("Java1/Week4/babyNamesTotals/data/yob"+year+".csv");
		CSVParser parser = fr.getCSVParser(false);
		for(CSVRecord rec:parser){
			if(rec.get(0).equals(name) && rec.get(1).equals(gender)){
				rank++;
				return rank;
			}else if(rec.get(1).equals(gender)){
				rank++;
			}
		}
		return -1;
	}

	public String getName(int year, int searchRank,String gender){
		int rank=0;
		//FileResource fr=new FileResource("Java1/Week4/babyNamesTotals/testing/yob"+year+"short.csv");
		FileResource fr=new FileResource("Java1/Week4/babyNamesTotals/data/yob"+year+".csv");
		CSVParser parser = fr.getCSVParser(false);
		for(CSVRecord rec:parser){
			if(rec.get(1).equals(gender)){
				rank++;
				if(rank==searchRank){
					return rec.get(0);
				}
			}
		}
		return "NO NAME";
	}

	public void whatIsNameInYear(String name,int year,int newYear,String gender){
		int rank=getRank(year,name,gender);
		String newName = getName(newYear,rank,gender);
		String gen;
		if (gender.equals("F")){
			gen = "she";
		}else {
			gen = "he";
		}
		System.out.println(name+" born in "+year+" would be "+newName+" if "+gen+" was born in "+newYear+".");
	}

	public int yearOfHighestRank(String name,String gender){
		int year=-1;
		int temprank;
		int bestrank=0;
		for(int i=1880;i<2015;i++){
			temprank = getRank(i,name,gender);
			if(temprank!=-1){
				if(bestrank==0){
					bestrank=temprank;
					year=i;
				}else{
					if(bestrank>temprank){year=i;}
					bestrank=Math.min(bestrank,temprank);


				}
			}
		}
		return year;
	}

	public double getAverageRank(String name,String gender){
		double trank=0;
		int fileCount=0;
		int rank=0;
		DirectoryResource dr=new DirectoryResource();
		for(File f:dr.selectedFiles()) {
			FileResource fr=new FileResource(f);
			CSVParser parser = fr.getCSVParser(false);
			rank = 0;
			for (CSVRecord rec : parser) {
				if (rec.get(0).equals(name) && rec.get(1).equals(gender)) {
					rank++;
					break;
				} else if (rec.get(1).equals(gender)) {
					rank++;
				}
			}
			trank+=rank;
			fileCount++;
		}
		trank=trank/fileCount;
		if(trank==0){return -1.0;}
		return trank;

	}

	public int getTotalBirthsRankedHigher(int year, String name,String gender){

		int rank=0;
		int birthSum=0;
		//FileResource fr=new FileResource("Java1/Week4/babyNamesTotals/testing/yob"+year+"short.csv");
		FileResource fr=new FileResource("Java1/Week4/babyNamesTotals/data/yob"+year+".csv");
		CSVParser parser = fr.getCSVParser(false);
		for(CSVRecord rec:parser){
			if(rec.get(0).equals(name) && rec.get(1).equals(gender)){
				return birthSum;
			}else if(rec.get(1).equals(gender)){
				birthSum+=Integer.parseInt(rec.get(2));
			}
		}
		return -1;

	}

	public void testTotalBirths () {
		//FileResource fr = new FileResource();
		FileResource fr = new FileResource("Java1/Week4/babyNamesTotals/data/yob1905.csv");
		totalBirths(fr);
		totalNames(fr);
	}

	public static void main(String[] args) {
		BabyBirths bbobj = new BabyBirths();
		bbobj.testTotalBirths();
		//bbobj.printNames();
		//System.out.println(bbobj.getRank(1960,"Emily","F"));
		//System.out.println(bbobj.getRank(1971,"Frank","M"));
		//System.out.println(bbobj.getRank(1990,"Drew","M"));
		//System.out.println(bbobj.getName(1980,350,"F"));
		//System.out.println(bbobj.getName(1982,450,"M"));
		//bbobj.whatIsNameInYear("Susan",1972,2014,"F");
		//bbobj.whatIsNameInYear("Owen",1974,2014,"M");
		//System.out.println(bbobj.yearOfHighestRank("Genevieve","F"));
		//System.out.println(bbobj.yearOfHighestRank("Mich","M"));
		//System.out.println(bbobj.getAverageRank("Susan","F"));
		//System.out.println(bbobj.getAverageRank("Robert","M"));
		//System.out.println(bbobj.getTotalBirthsRankedHigher(1990,"Emily","F"));
		//System.out.println(bbobj.getTotalBirthsRankedHigher(1990,"Drew","M"));
	}
}
