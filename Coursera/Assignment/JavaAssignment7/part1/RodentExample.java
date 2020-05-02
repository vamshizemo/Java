/*
1. Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster,etc. In the base class, provide methods that are common to all
 Rodents, and override these in the derived classes to perform different behaviors depending on the specific type of Rodent. Create an
 array of Rodent, fill it with different specific types of Rodents, and call your base-class methods to see what happens. Make the
 methods of Rodent abstract whenever possible and all classes should have default constructors that print a message about that class.
*/
package Assignment.JavaAssignment7.part1;

public class RodentExample {
    public static void main(String[] args) {
        Rodent[] rodents = {new Mouse(),new Gerbil(),new Hamster() };
        for(Rodent rodent:rodents){
            rodent.eat();
            rodent.jump();
            rodent.run();
        }
    }
}
