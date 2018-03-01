import com.alibaba.fastjson.JSON;

public class CreateDelivery {

    public static Delivery delivery;

    public static void fileWrite(String date, String path) {
        delivery.date = date;
        String json = JSON.toJSONString(delivery);
        File.write(path, json);
    }

    public static void serializeObject(String path1, String path2, String path3) {
        delivery = new Delivery();
        delivery.add(new Fruit(FruitType.Apple, 100, "2018-01-01", 5.0));
        delivery.add(new Fruit(FruitType.Apricot, 20, "2018-01-02", 7.0));
        delivery.add(new Fruit(FruitType.Banana, 30, "2018-01-03", 2.0));
        fileWrite("2018.02.05", path1);

        delivery = new Delivery();
        delivery.add(new Fruit(FruitType.Lemon, 80, "2018-01-08", 8.0));
        delivery.add(new Fruit(FruitType.Mango, 100, "2018-01-08", 12.0));
        delivery.add(new Fruit(FruitType.Orange, 70, "2018-01-09", 6.0));
        fileWrite("2018.02.10", path2);

        delivery = new Delivery();
        delivery.add(new Fruit(FruitType.Peach, 15, "2018-01-11", 7.0));
        delivery.add(new Fruit(FruitType.Pear, 120, "2018-01-12", 5.0));
        delivery.add(new Fruit(FruitType.Plum, 45, "2018-01-11", 5.0));
        delivery.add(new Fruit(FruitType.Strawberry, 5, "2018-01-12", 12.0));
        fileWrite("2018.02.15", path3);

    }

}
