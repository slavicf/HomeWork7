
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

    }
}
