package vamshiraghav.assignment.main;

import vamshiraghav.assignment.data.DefaultInit;
import vamshiraghav.assignment.singleton.Singleton;

public class JavaAssignment5 {
    public static void main(String[] args) {
        DefaultInit object1=new DefaultInit();
        object1.printVariables();
        object1.printLocalVariables();
        /*
        printLocalVariables() method of DefaultInit class fails to compile and execute
        because uninitialized local variables cannot take default values like the
        uninitialized member variables.
        Uninitialized member variables of class takes default values of 0 for int and
        null for string and char type.
         */
        Singleton object2=Singleton.initialize("singleton class text");
        object2.printText();
    }

}
