
public class Main {

    static Shop shop = new Shop();
    static String pathDelivery1 = "files/delivery1.txt";
    static String pathDelivery2 = "files/delivery2.txt";
    static String pathDelivery3 = "files/delivery3.txt";
    static String path2Shop = "files/shop.txt";

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
