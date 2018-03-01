import com.alibaba.fastjson.JSON;

public class Shop {

    private Store store = new Store();

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
}
