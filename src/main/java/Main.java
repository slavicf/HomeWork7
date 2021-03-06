import java.time.LocalDate;
import java.util.List;

public class Main {

    static Shop shop = new Shop();
    static String pathDelivery1 = "files/delivery1.txt";
    static String pathDelivery2 = "files/delivery2.txt";
    static String pathDelivery3 = "files/delivery3.txt";
    static String path2Shop = "files/shop.txt";

    static void show(List<Fruit> fruits, LocalDate date, String message) {
        System.out.println("\nНа " + date + message);
        for (Fruit fruit: fruits) {
            System.out.println(fruit);
        }
    }

    public static void main(String[] args) {

//        CreateDelivery.serializeObject(pathDelivery1, pathDelivery2, pathDelivery3);
        shop.addFruits(pathDelivery1);
        shop.addFruits(pathDelivery2);
        shop.addFruits(pathDelivery3);
//        shop.save(path2Shop);
        shop = new Shop();
        shop.load(path2Shop);

        LocalDate date = Time.getDate("2018-03-01");
        List<Fruit> fruits = shop.getSpoiledFruits(date);
        show(fruits, date, " испорчены:");
        fruits= shop.getSpoiledFruits(date, FruitType.Strawberry);
        show(fruits, date, " испорчены:");

        fruits = shop.getAvailableFruits(date);
        show(fruits, date, " готовы к продаже:");
        fruits= shop.getAvailableFruits(date, FruitType.Orange);
        show(fruits, date, " готовы к продаже:");

        date = Time.getDate("2018-01-11");
        fruits = shop.getAddedFruits(date);
        show(fruits, date, " поставлены:");
        fruits = shop.getAddedFruits(date, FruitType.Peach);
        show(fruits, date, " поставлены:");
    }
}
