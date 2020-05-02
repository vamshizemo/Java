/*
1. Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster,etc. In the base class, provide methods that are common to all
 Rodents, and override these in the derived classes to perform different behaviors depending on the specific type of Rodent. Create an
 array of Rodent, fill it with different specific types of Rodents, and call your base-class methods to see what happens. Make the
 methods of Rodent abstract whenever possible and all classes should have default constructors that print a message about that class.
*/

package Assignment.JavaAssignment7.part1;

abstract class Rodent {

    public Rodent() {
        System.out.println("This is Rodent class");
    }
    abstract void eat();
    abstract void jump();
    abstract void run();
}

class Mouse extends Rodent{
    public Mouse() {
        System.out.println("This is Mouse class");
    }

    @Override
    void eat() {
        System.out.println("Mouse is eating");

    }

    @Override
    void jump() {
        System.out.println("Mouse is jumping");
    }

    @Override
    void run() {
        System.out.println("Mouse is running");

    }
}

class Gerbil extends Rodent{
    @Override
    void eat() {
        System.out.println("Gerbil is eating");
    }

    @Override
    void jump() {
        System.out.println("Gerbil is Jumping");

    }

    @Override
    void run() {
        System.out.println("Gerbil is running");
    }

    public Gerbil() {
        System.out.println("This is Gerbil class");
    }
}
class Hamster extends Rodent{
    @Override
    void eat() {
        System.out.println("Hamster is eating");
    }

    @Override
    void jump() {
        System.out.println("Hamster is Jumping");
    }

    @Override
    void run() {
        System.out.println("Hamster is Running");
    }

    public Hamster() {
        System.out.println("This is Hamster Class");
    }
}