package DateTimeUtl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//Solution below adapted from https://github.com/ixxeden/duke/blob/master/src/main/java/duke/Utility/Util.java
public class DataTimeUtl {
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";


    public static LocalDateTime convertDT(String dt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
        LocalDateTime formattedDT = LocalDateTime.parse(dt, formatter);
        return formattedDT;
    }

}
