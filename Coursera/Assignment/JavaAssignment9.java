/*
String and Type Information

Using the documentation for java.util.regex.Pattern as a
resource, write and test a regular expression that checks
 a sentence to see that it begins with a capital letter and
 ends with a period.

 */
package Assignment;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class JavaAssignment9 {
    public boolean isBegingWithCapsNEndsWithPer(String sentence){
        String reg="[A-Z][^.]+.";
        Pattern p=Pattern.compile(reg);
        Matcher m=p.matcher(sentence);
        return m.matches();
    }

    public static void main(String[] args) {
        JavaAssignment9 object=new JavaAssignment9();
        String test1,test2,test3,test4;
        test1="This is the,first sentence.";
        test2="this is second sentence.";
        test3= "this is third sentence. And more,";
        test4= "hi,This is third sentence. And more,";
        System.out.println(object.isBegingWithCapsNEndsWithPer(test1));
        System.out.println(object.isBegingWithCapsNEndsWithPer(test2));
        System.out.println(object.isBegingWithCapsNEndsWithPer(test3));
        System.out.println(object.isBegingWithCapsNEndsWithPer(test4));

    }
}
