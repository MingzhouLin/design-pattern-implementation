package Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConvert {
    public static void main(String[] args) throws ParseException {
        System.out.println(convertSecondsToHours("3500"));
    }
    public static String convertSecondsToHours(String seconds) throws ParseException{
//        double h = Math.floor(seconds / 3600);
//        double m = Math.floor(seconds % 3600 / 60);
//        double s = Math.floor(seconds % 3600 % 60);
//
//        String hDisplay = h > 0 ? h + ":"  : "";
//        String mDisplay = m > 0 ? m + ":"  : "";
//        String sDisplay = s > 0 ? String.valueOf(s) : "";
        SimpleDateFormat format = new SimpleDateFormat("ss");
        Date time = format.parse(seconds);

//        return new StringBuilder()
//                .append(hDisplay)
//                .append(mDisplay)
//                .append(sDisplay)
//                .toString();
        return new SimpleDateFormat("HH:mm:ss").format(time);
    }
}
