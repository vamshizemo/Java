/*
        2. Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle. Add a balance( ) method to Unicycle and Bicycle,
        but not to Tricycle. Create instances of all three types and upcast them to an array of Cycle. Try to call
        balance( ) on each element of the array and observe the results. Downcast and call balance( ) and observe what happens.
*/
package Assignment.JavaAssignment7.part2;

import java.util.logging.Logger;

public class Cycle {
    static Logger logger = Logger.getLogger(Cycle.class.getName());
    public Cycle() {
        logger.info("This is a Cycle class");
    }
}
class Unicycle extends Cycle{
    public Unicycle() {
        logger.info("This is Unicycle class");
    }

    void balance(){
        logger.info("Balancing Unicylce");
    }
}
class Bicycle extends Cycle{
    public Bicycle() {
        logger.info("This is Bicycle class");
    }

    void balance(){
        logger.info("Balancing BiCycle");
    }

}
class Tricycle extends Cycle{
    public Tricycle() {
        logger.info("This is Tricycle class");
    }
}
