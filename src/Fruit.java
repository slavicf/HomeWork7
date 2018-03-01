class Fruit {                                        // класс фрукта

    public FruitType fruitType;                                    // вид фрукта (Apple, Apricot, Banana, Lemon, Mango, Orange, Peach, Pear, Plum, Strawberry)
    public int expiration;                                         // срок годности
    public String deliveryDate;                                    // дата поставки
    public double price;                                           // цена

    public Fruit(FruitType fruitType, int expiration, String deliveryDate, double price) {
        this.fruitType = fruitType;
        this.expiration = expiration;
        this.deliveryDate = deliveryDate;
        this.price = price;
    }

}
