package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {

    public static String getCurrentDateTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd, hh:mma");

        return dateFormat.format(date);
    }

    public static String getTimeInMinSecFormat(long time) {
        int minutes = (int) ((time / 1000) / 60);
        int seconds = (int) (time / 1000) % 60;

        return "" + minutes + " min " + seconds + " sec";
    }
}