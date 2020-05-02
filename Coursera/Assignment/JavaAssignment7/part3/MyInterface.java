/*

3. Create three interfaces, each with two methods. Inherit a new interface that combines the
        three, adding a new method. Create a class by implementing the new interface and
        also inheriting from a concrete class. Now write four methods, each of which takes one
        of the four interfaces as an argument. In main( ), create an object of your class and
        pass it to each of the methods.
*/

package Assignment.JavaAssignment7.part3;

import java.util.logging.Logger;

public class MyInterface {
    public static void delegateMethodA(InterfaceOne impl){impl.methodA();}
    public static void delegateMethodC(InterfaceTwo impl){impl.methodC();}
    public static void delegateMethodE(InterfaceThree impl){impl.methodE();}
    public static void delegateMethodG(InterfaceFour impl){impl.methodG();}

    public static void main(String[] args) {
        ImplClass testClass= new ImplClass();
        delegateMethodA(testClass);
        delegateMethodC(testClass);
        delegateMethodE(testClass);
        delegateMethodG(testClass);
    }
}
interface InterfaceOne{
    void methodA();
    void methodB();
}
interface InterfaceTwo{
    void methodC();
    void methodD();
}
interface InterfaceThree{
    void methodE();
    void methodF();
}
interface InterfaceFour extends InterfaceOne,InterfaceTwo,InterfaceThree{
    void methodG();
}
class ConcreteClass{
    static Logger logger = Logger.getLogger(MyInterface.class.getName());
    void myMethod(){
        logger.info("This is Concrete class method");
    }
}
class ImplClass extends ConcreteClass implements InterfaceFour{
    @Override
    public void methodA() {
        logger.info("In the methodA");
    }

    @Override
    public void methodB() {
        logger.info("In the methodB");
    }

    @Override
    public void methodC() {
        logger.info("In the methodC");
    }

    @Override
    public void methodD() {
        logger.info("In the methodD");
    }

    @Override
    public void methodE() {
        logger.info("In the methodE");
    }

    @Override
    public void methodF() {
        logger.info("In the methodF");
    }

    @Override
    public void methodG() {
        logger.info("In the methodG");
    }


}
