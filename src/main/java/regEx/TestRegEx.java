package regEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegEx {


    public static void main(String[] args) {
        Pattern MEDIA_CODE_POINTOFSERVICE_PATTERN = Pattern.compile("(([0-9]+)-([0-9]+))?(.jpg|.png|)?");
        String fileName = "921-01.jpg";
        Matcher matcher = MEDIA_CODE_POINTOFSERVICE_PATTERN.matcher(fileName);
        if (matcher.find()) {
            String name = matcher.group(2);
            System.out.println("name " + name);
            String number = matcher.group(3);
            System.out.println("number " + number);
            String format = matcher.group(4);
            System.out.println("format " + format);
        }
    }
}
