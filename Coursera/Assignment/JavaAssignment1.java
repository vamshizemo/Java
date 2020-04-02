/*
Create a java program to search through the home directory and look for files that match a regular expression.
The program should be able to take inputs repeatedly and should print out the full absolute path of the matching files found.
Provide appropriate documentation and comments on your code.

Post your code to your GitHub repo and share the url.

 */
package Assignment;


import java.io.File;
import java.io.IOError;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaAssignment1 {
    public void getMatchFiles(String path,String regExp) throws IOError {

        try {
            File f= new File(path);
            Pattern p = Pattern.compile(regExp);
            Matcher m;
            boolean found;

            for (File file : f.listFiles()) {
                    if (file.isDirectory()) {
                        getMatchFiles(path + "/" + file.getName(), regExp);
                    } else {
                        p = Pattern.compile(regExp);
                        m = p.matcher(file.getName());
                        found = m.matches();
                        if (found) {
                            System.out.println(file);
                        }
                    }
                }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        JavaAssignment1 object = new JavaAssignment1();
        String path=System.getProperty("user.home");
        path="/home/vamshi/Documents";
        String input="";
        while(!input.equals("EXIT")){
            System.out.println("Please input file pattern to Search, 'EXIT' for exit");
            input = scan.nextLine();
            System.out.println("search pattern :"+input);
            object.getMatchFiles(path,input);
        }
        System.out.println("Exiting Files search .!!!");
        scan.close();
    }
}
