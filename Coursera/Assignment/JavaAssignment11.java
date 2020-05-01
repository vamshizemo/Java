/*
I/O

Using TextFile and a Map<Character,Integer>, create a
program that takes the file name as a command line argument
 and counts the occurrence of all the different characters.
 Save the results in a text file.

 */

package Assignment;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class JavaAssignment11 {
    private static Logger logger = Logger.getLogger(JavaAssignment11.class.getName());

    public void writeCharCountToFile(String path) throws IOException {

        logger.info("Enter the file name:");
        Scanner scan = new Scanner(System.in);
        String fName = scan.nextLine();
        scan.close();
        File file = new File(path + fName);
        logger.info(path + fName);
        Map<Character, Integer> fileMap = new HashMap<>();
        char temp;
        if (!file.isDirectory()) {
            FileReader reader = new FileReader(file.toString());
            int character;
            while ((character = reader.read()) != -1) {
                temp = (char) character;
                if (fileMap.containsKey(temp)) {
                    fileMap.put(temp, fileMap.get(temp) + 1);
                } else {
                    fileMap.put(temp, 1);

                }
            }
            reader.close();
            logger.info("file read..");
            FileWriter writer = new FileWriter(path + "MyFile.txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (char c : fileMap.keySet()) {
                bufferedWriter.write(c + " = " + fileMap.get(c));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            logger.info("file written");


        } else {
            logger.info("Enter the correct file name..");
        }


    }

    public static void main(String[] args) {
        JavaAssignment11 fileProcessor = new JavaAssignment11();
        String path = "./Assignment/";
        try {
            fileProcessor.writeCharCountToFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
