package vamshiraghav.assignment.singleton;

public class Singleton {
    private String text;
    public static Singleton initialize(String text){
        Singleton object= new Singleton();
        object.text=text;
        return object;
    }
    public void printText(){
        System.out.println(text);
    }
}
