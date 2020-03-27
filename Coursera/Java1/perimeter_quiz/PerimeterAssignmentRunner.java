import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count=0;
        for(Point p:s.getPoints()){
            count++;
        }
        // Put code here
        return count;
    }

    public double getAverageLength(Shape s) {

        // Put code here
        return (getPerimeter(s)/getNumPoints(s));
    }

    public double getLargestSide(Shape s) {

        double maxSide = 0.0;

        Point prevPt = s.getLastPoint();

        for (Point currPt : s.getPoints()) {

            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            maxSide = Math.max(currDist,maxSide);
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return maxSide;

    }

    public double getLargestX(Shape s) {
        double x=s.getLastPoint().getX();
        for(Point p:s.getPoints()){
            x= Math.max(x,p.getX());
        }

        // Put code here
        return x;
    }

    public double getLargestPerimeterMultipleFiles() {
        double largPer=0;
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles()){
            FileResource fr= new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            largPer= Math.max(largPer,length);
        }
        // Put code here
        return largPer;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double largPer=0;
        DirectoryResource dr=new DirectoryResource();
        for(File f:dr.selectedFiles()){
            if(temp==null){
                temp=f;
            }
            FileResource fr= new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if (largPer<length){temp=f;}
            largPer= Math.max(largPer,length);
        }
        // Put code here

        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points "+getNumPoints(s));
        System.out.println("average length of shape "+getAverageLength(s));
        System.out.println("largest side of shape is " + getLargestSide(s));
        System.out.println("largest x value is " + getLargestX(s));
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("largest perimeter :"+getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        System.out.println("File with largest perimeter :"+getFileWithLargestPerimeter());
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
