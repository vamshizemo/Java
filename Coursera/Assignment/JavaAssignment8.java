/*
Error Handling

Create three new types of exceptions. Write a class with a
method that throws all three. In main( ), call the method
but only use a single catch clause that will catch all three
types of exceptions. Add a finally clause and verify that
your finally clause is executed, even if a NullPointerException
is thrown.
 */
package Assignment;

class ExceptionA extends Exception{
    public ExceptionA(String text){
        super(text);
    }
}
class ExceptionB extends Exception{
    public ExceptionB(String text){
        super(text);
    }
}
class ExceptionC extends Exception{
    public ExceptionC(String text){
        super(text);
    }
}
class AllExceptions{
    public void throwException(String text) throws ExceptionA,ExceptionB,ExceptionC {

            if(text.equals("A")){
                throw new ExceptionA("A");
            }else if(text.equals("B")){
                throw new ExceptionB("B");
            }else if(text.equals("C")){
                throw new ExceptionC("C");
            }

    }
}
public class JavaAssignment8 {
    public static void main(String[] args){
        AllExceptions exception = new AllExceptions();
        try{
            exception.throwException("A");
            exception.throwException("B");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Final exception reached");
        }
    }

}
