/*
4. Create a Cycle interface, with implementations Unicycle, Bicycle and Tricycle. Create factories for
each type of Cycle, and code that uses these factories.
*/

package Assignment.JavaAssignment7.part4;

class CycleFactory {
    static Cycle newUnicycle(){
        return new Unicycle();
    }
    static Cycle newBicycle(){
        return new Bicycle();
    }
    static Cycle newTricycle(){
        return new Tricycle();
    }
}
interface Cycle{
    void printWheelCount();
    void printBalanceStatus();
}
class Unicycle implements Cycle{
    int NoOfWheels;
    boolean isbalanced;

    public Unicycle() {
        NoOfWheels = 1;
        this.isbalanced = true;
    }

    @Override
    public void printWheelCount() {
        System.out.println("Unicycle has "+NoOfWheels+" wheel");
    }

    @Override
    public void printBalanceStatus() {
        System.out.println("Unicycle has a balanced status "+isbalanced);
    }
}
class Bicycle implements Cycle{
    int NoOfWheels;
    boolean isbalanced;

    public Bicycle() {
        NoOfWheels = 2;
        this.isbalanced = true;
    }

    @Override
    public void printWheelCount() {
        System.out.println("Bicycle has "+NoOfWheels+" wheels");
    }

    @Override
    public void printBalanceStatus() {
        System.out.println("Bicycle has a balanced status "+isbalanced);
    }
}
class Tricycle implements Cycle{
    int NoOfWheels;
    boolean isbalanced;

    public Tricycle() {
        NoOfWheels = 3;
        this.isbalanced = false;
    }

    @Override
    public void printWheelCount() {
        System.out.println("Tricycle has "+NoOfWheels+" wheels");
    }

    @Override
    public void printBalanceStatus() {
        System.out.println("Tricycle has a balanced status "+isbalanced);
    }
}
class CycleMain{
    public static void main(String[] args) {
        Cycle uniCycle = CycleFactory.newUnicycle();
        Cycle biCycle = CycleFactory.newBicycle();
        Cycle triCycle = CycleFactory.newTricycle();
        
        uniCycle.printWheelCount();
        biCycle.printWheelCount();
        triCycle.printWheelCount();
    }
}

