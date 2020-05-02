//5. Create a class with an inner class that has a non-default constructor (one that takes arguments).
// Create a second class with an inner class that inherits from the first inner class.

package Assignment.JavaAssignment7.part5;
public class Demo {
    public static void main(String[] args) {
        BaseClassTwo theBaseClassTwo = new BaseClassTwo("Hello World!");

    }

}
class BaseClassOne{
    class InnerClass{
        String message;
        public InnerClass(String message) {
            this.message = message;
            System.out.println("You are in a inner class ");
            System.out.println("Message :"+message);
        }
    }
}
class BaseClassTwo{
    public BaseClassTwo(String message) {
        InnerClassChild innerChild = new InnerClassChild(message);
    }

    class InnerClassChild extends BaseClassOne.InnerClass{
        public InnerClassChild(String message) {
            new BaseClassOne().super(message);
        }
    }
}
