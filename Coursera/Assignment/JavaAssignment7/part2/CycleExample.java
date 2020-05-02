/*
        2. Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle. Add a balance( ) method to Unicycle and Bicycle,
        but not to Tricycle. Create instances of all three types and upcast them to an array of Cycle. Try to call
        balance( ) on each element of the array and observe the results. Downcast and call balance( ) and observe what happens.
*/
package Assignment.JavaAssignment7.part2;

public class CycleExample {

    public static void main(String[] args) {
        Cycle[] cycles = {new Unicycle(), new Bicycle(), new Tricycle()};
//        upcasting
        /*for(Cycle cycle:cycles){
            cycle.balance();
        }*/

//        Downcasting
        ((Unicycle) cycles[0]).balance();
        ((Bicycle) cycles[1]).balance();
//        Tricycle class doesnot have balance method
//        ((Tricycle)cycles[2]).balance();
    }
}
