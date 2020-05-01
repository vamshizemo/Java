/*
String and Type Information

Using the documentation for java.util.regex.Pattern as a
resource, write and test a regular expression that checks
 a sentence to see that it begins with a capital letter and
 ends with a period.

 */
package Assignment;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class JavaAssignment9 {

    private static Logger logger = Logger.getLogger(JavaAssignment9.class.getName());
    private static final Pattern pattern = Pattern.compile("[A-Z][^.]+\\.");
    private Matcher match;

    public boolean isStartsWithCapsAndEndsWithPeriod(String sentence){
        match=pattern.matcher(sentence);
        return match.matches();
    }

    public static String toMessage(Boolean bool){
        if(bool) {return "Pattern Found"; }
        else{return "Pattern Not Found"; }
    }

    public static void main(String[] args) {
        JavaAssignment9 customPatternFinder=new JavaAssignment9();

        String[] testStrings={
        "This is the,first sentence.",
        "this is second sentence.",
        "this is third sentence. And more,",
        "hi,This is third sentence. And more,",
        "Apple",
        "Friend.",
        "."};
        for(String testString : testStrings) {
            logger.info(testString+" --> "+toMessage(
                    customPatternFinder.isStartsWithCapsAndEndsWithPeriod(testString)));
        }

    }
}
