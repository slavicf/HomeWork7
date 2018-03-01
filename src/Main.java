import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Main {

    private static Shop shop = new Shop();
    private static String pathDelivery1 = "files/delivery1.txt";
    private static String pathDelivery2 = "files/delivery2.txt";
    private static String pathDelivery3 = "files/delivery3.txt";
    private static String path2Shop = "files/shop.txt";

    public static void main(String[] args) {

//        CreateDelivery.serializeObject(pathDelivery1, pathDelivery2, pathDelivery3);
        shop.addFruits(pathDelivery1);
        shop.addFruits(pathDelivery2);
        shop.addFruits(pathDelivery3);
        shop.save(path2Shop);
        shop = new Shop();
        shop.load(path2Shop);

        String dateString = "2015.05.15";
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        System.out.println(date.format(DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("ru"))));
        LocalDate date2 = date.plusDays(30);
        System.out.println(date2.format(DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("ru"))));
        System.out.println(date.isAfter(date2));
        System.out.println(date + ", " + date2);

//        Date date = new Date();
//        System.out.println(date);
//        date.;
//        System.out.println(date);

//        String date_s = " 2011-01-18 00:00:00.0";
//        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
//        Date date = dt.parse();
//        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd");
//        System.out.println(dt1.format(date));
    }
}
