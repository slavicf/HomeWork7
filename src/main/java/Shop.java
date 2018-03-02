import com.alibaba.fastjson.JSON;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

public class Shop {

    public Store store = new Store();

    public void addFruits(String pathToJsonFile) {          // метод принимает путь к файлу внутри которого находится json с фруктами и датой поставки
        String json = File.read(pathToJsonFile);
        if(json != null) {
            Delivery delivery = JSON.parseObject(json, Delivery.class);
            store.deliveries.add(delivery);
        }
    }

    public void save(String pathToJsonFile) {               // сохранит всю информацию со склада лавки в json файл
        String json = JSON.toJSONString(store);
        File.write(pathToJsonFile, json);
    }

    public void load(String pathToJsonFile) {               // удаляет текущую информацию из коллекции и загружает новую из сохраненной версии
        String json = File.read(pathToJsonFile);
        if(json != null) {
            store = JSON.parseObject(json, Store.class);
        }
    }

    public List<Fruit> getSpoiledFruits(LocalDate actualDate) {    // какие продукты испортятся к заданной дате
        return selection(actualDate, false);
    }

    public List<Fruit> getSpoiledFruits(LocalDate actualDate, FruitType fruitType) {    // фильтруeт по заданному типу фрукта
        List<Fruit> list = getSpoiledFruits(actualDate);
        Predicate<Fruit> listPredicate = p-> p.getFruitType() != fruitType;
        list.removeIf(listPredicate);
        return list;
    }

    public List<Fruit> getAvailableFruits(LocalDate actualDate) {  // готовы к продаже продукты
        return selection(actualDate, true);
    }

    public List<Fruit> getAvailableFruits(LocalDate actualDate, FruitType fruitType) {    // фильтруeт по заданному типу фрукта
        List<Fruit> list = getAvailableFruits(actualDate);
        Predicate<Fruit> listPredicate = p-> p.getFruitType() != fruitType;
        list.removeIf(listPredicate);
        return list;
    }

    private List<Fruit> selection(LocalDate actualDate, boolean good) {
        List<Fruit> list = new ArrayList<>();
        int dSize = store.deliveries.size();
        for (int i = 0; i < dSize; i++){
            int fSize = store.deliveries.get(i).fruits.size();
            for (int j = 0; j < fSize; j++){
                Fruit fruit = store.deliveries.get(i).fruits.get(j);
                int expiration = fruit.getExpiration();
                LocalDate deliveryDate = Time.getDate(fruit.getDeliveryDate());
                boolean selected = Time.isExpired(deliveryDate, expiration, actualDate) ^ good;
                if(selected) list.add(fruit);
            }
        }
        return list;
    }

    public List<Fruit> getAddedFruits(LocalDate date) {      // продукты которые были доставлены в заданную дату
        return delivered(date);
    }

    public List<Fruit> getAddedFruits(LocalDate actualDate, FruitType fruitType) {
        List<Fruit> list = getAddedFruits(actualDate);
        Predicate<Fruit> listPredicate = p-> p.getFruitType() != fruitType;
        list.removeIf(listPredicate);
        return list;
    }

    public List<Fruit> delivered (LocalDate date) {
        List<Fruit> list = new ArrayList<>();
        int dSize = store.deliveries.size();
        for (int i = 0; i < dSize; i++){
            int fSize = store.deliveries.get(i).fruits.size();
            for (int j = 0; j < fSize; j++){
                Fruit fruit = store.deliveries.get(i).fruits.get(j);
                LocalDate deliveryDate = Time.getDate(fruit.getDeliveryDate());
                if(deliveryDate.isEqual(date)) list.add(fruit);
            }
        }
        return list;
    }
}
