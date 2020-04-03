/*
3. Create a class with a constructor that takes a String argument.
During construction, print the argument. Create an array of object
references to this class, but don’t actually create objects to assign
 into the array. When you run the program, notice whether the
 initialization messages from the constructor calls are printed.

4. Complete the previous exercise by creating objects to attach
to the array of references.

 */

package Assignment.JavaAssignment6;

public class Part3 {
    private String text;
    public Part3(String text){
        this.text = text;
        System.out.println(text);
    }

    public static void main(String[] args) {
        Part3[] objects;
        //Part3 : for part3 it doesnt print anything
        objects=new Part3[5];
        for(int i=0;i<5;i++){
            objects[i]=new Part3("text is :"+i);
        }
        // Part4 : for part4 it prints the input arguments when
        //constructed.
    }
}
