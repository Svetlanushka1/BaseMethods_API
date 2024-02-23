package data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatesUtils {
    public static String getDateString() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        return dateFormat.format(currentDate);
    }
}
