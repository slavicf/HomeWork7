import com.alibaba.fastjson.JSON;

import java.time.LocalDate;
import java.util.*;

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

    public ArrayList<Fruit> getSpoiledFruits(LocalDate actualDate) {
        ArrayList<Fruit> list = new ArrayList<>();
        int dSize = store.deliveries.size();
        for (int i = 0; i < dSize; i++){
            int fSize = store.deliveries.get(i).fruits.size();
            for (int j = 0; j < fSize; j++){
                Fruit fruit = store.deliveries.get(i).fruits.get(j);
                int expiration = fruit.getExpiration();
                String deliveryDate = fruit.getDeliveryDate();
                if(Time.isExpired(deliveryDate, expiration, actualDate)) {
                    list.add(fruit);
                }
            }
        }
        return list;
    }

    public ArrayList<Fruit> getAvailableFruits(LocalDate actualDate) {
        ArrayList<Fruit> list = new ArrayList<>();
        int dSize = store.deliveries.size();
        for (int i = 0; i < dSize; i++){
            int fSize = store.deliveries.get(i).fruits.size();
            for (int j = 0; j < fSize; j++){
                Fruit fruit = store.deliveries.get(i).fruits.get(j);
                int expiration = fruit.getExpiration();
                String deliveryDate = fruit.getDeliveryDate();
                if(!Time.isExpired(deliveryDate, expiration, actualDate)) {
                    list.add(fruit);
                }
            }
        }
        return list;
    }
}
