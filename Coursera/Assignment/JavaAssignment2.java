/*

Write a java function that checks if the input string contains all
the letters of the alphabet a-z (case-insensitive). Write time and
space complexity of your solution as comments in the source file.

Time complexity:O(n)
Space Complexity:O(1)

*/
package Assignment;

import edu.duke.FileResource;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class JavaAssignment2 {
    public boolean checkAllAphabets(String input){
        HashSet<Integer> alphaSet= new HashSet<Integer>();
        int length = input.length();
        int a=(int)'a';
        int z=(int)'z';
        int A=(int)'A';
        int Z=(int)'Z';
        int temp=0;
        while(length>0){
            length--;
            temp=(int)input.charAt(length);
            if (temp>=a && temp <=z){
                alphaSet.add(temp-a);
            }else if(temp>=A && temp <=Z){
                alphaSet.add(temp-A);
            }
           if(alphaSet.size()==26){
               return true;
           }
        }
        return false;
    }

    public static void main(String[] args) {
        JavaAssignment2 object = new JavaAssignment2();
        Scanner scan = new Scanner(System.in);
        Long startTime= System.nanoTime();
        String test1="The quick brown fox jumps over the lazy dog ";
        String test2="Cozy lummox gives smart squid who asks for job pen";
        System.out.println(object.checkAllAphabets(test1));
        System.out.println(object.checkAllAphabets(test2));
        FileResource file= new FileResource("/home/vamshi/IdeaProjects/Coursera/Assignment/java2data.txt");
        System.out.println(object.checkAllAphabets(file.asString()));
        Long endTime = System.nanoTime();
        double exTime = ((double)(endTime-startTime))/1000000000;
        System.out.println(exTime);
        System.out.println("Enter the input String :");
        System.out.println(object.checkAllAphabets(scan.nextLine()));

    }
}
