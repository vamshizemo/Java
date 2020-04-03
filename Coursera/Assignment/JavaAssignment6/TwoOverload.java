/*
2. Create a class with two (overloaded) constructors.
Using this, call the second constructor inside the first one.
 */
package Assignment.JavaAssignment6;

public class TwoOverload {
    public String getText() {
        return text;
    }

    private String text;
    public TwoOverload(int num){
        this(Integer.toString(num));
    }
    public TwoOverload(String value){
        text=value;
    }

    public static void main(String[] args) {
        TwoOverload object = new TwoOverload(100);
        System.out.println(object.getText());
    }
}
