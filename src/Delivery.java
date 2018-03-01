import java.util.ArrayList;

public class Delivery {                                     // поставка

    private ArrayList<Fruit> fruits = new ArrayList<>();   // фрукты
    public String date;                                     // дата поставки

    public void add (Fruit fruit) {
        fruits.add(fruit);
    }

}
