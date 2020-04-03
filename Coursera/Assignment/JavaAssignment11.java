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

public class JavaAssignment11 {
    public void charCountToFile() throws IOException {
        String path="./Assignment/";
        System.out.println("Enter the file name:");
        Scanner scan = new Scanner(System.in);
        String fName = scan.nextLine();
        scan.close();
        try {
            File file = new File(path + fName);
            System.out.println(path + fName);
            HashMap<Character, Integer> fileMap = new HashMap<Character, Integer>();
            char temp;
            if (!file.isDirectory()) {
                FileReader reader = new FileReader(file.toString());
                int character;
                while ((character = reader.read()) != -1) {
                    temp = (char) character;
                    if(fileMap.containsKey(temp)) {
                        fileMap.put(temp,fileMap.get(temp)+1);
                    }else{
                        fileMap.put(temp,1);

                    }
                }
                reader.close();
                System.out.println("file read..");
                FileWriter writer = new FileWriter("./Assignment/MyFile.txt", false);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                for(char c:fileMap.keySet()){
                    bufferedWriter.write(c +" = "+fileMap.get(c));
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                System.out.println("file written");


            }
            else {
                System.out.println("Enter the correct file name..");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws  IOException{
        JavaAssignment11 object = new JavaAssignment11();
        try {
            object.charCountToFile();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}