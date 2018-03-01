public class Fruit {                                        // класс фрукта

    private FruitType fruitType;                                    // вид фрукта (Apple, Apricot, Banana, Lemon, Mango, Orange, Peach, Pear, Plum, Strawberry)
    private int expiration;                                         // срок годности
    private String deliveryDate;                                    // дата поставки
    private double price;                                           // цена

    public Fruit(FruitType fruitType, int expiration, String deliveryDate, double price) {
        this.fruitType = fruitType;
        this.expiration = expiration;
        this.deliveryDate = deliveryDate;
        this.price = price;
    }

    public FruitType getFruitType() {
        return fruitType;
    }

    public int getExpiration() {
        return expiration;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Fruit{" + fruitType +
                ", expiration=" + expiration +
                ", deliveryDate='" + deliveryDate + '\'' +
                ", price=" + price +
                '}';
    }
}
