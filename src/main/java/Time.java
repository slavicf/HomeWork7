import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Time {

    public static LocalDate getDate() {
        return LocalDate.now();
    }

    public static LocalDate getDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static boolean isExpired (LocalDate deliveryDate, int expiration, LocalDate actualDate) {
        LocalDate expire = deliveryDate.plusDays(expiration);
        return expire.isBefore(actualDate);
    }
}
