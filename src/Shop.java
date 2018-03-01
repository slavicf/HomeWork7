import com.alibaba.fastjson.JSON;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
//
//    public List<Fruit> getSpoiledFruits(LocalDate date) {
//        int dSize = store.deliveries.size();
//        for (int i = 0; i < dSize; i++){
//            int fSize = store.deliveries.get(i).fruits.size();
//            for (int j = 0; j < fSize; j++){
//                System.out.println(store.deliveries.get(i).fruits.get(i).expiration);
//            }
//        }
//        return new List<Fruit>() {
//            @Override
//            public int size() {
//                return 0;
//            }
//
//            @Override
//            public boolean isEmpty() {
//                return false;
//            }
//
//            @Override
//            public boolean contains(Object o) {
//                return false;
//            }
//
//            @Override
//            public Iterator<Fruit> iterator() {
//                return null;
//            }
//
//            @Override
//            public Object[] toArray() {
//                return new Object[0];
//            }
//
//            @Override
//            public <T> T[] toArray(T[] a) {
//                return null;
//            }
//
//            @Override
//            public boolean add(Fruit fruit) {
//                return false;
//            }
//
//            @Override
//            public boolean remove(Object o) {
//                return false;
//            }
//
//            @Override
//            public boolean containsAll(Collection<?> c) {
//                return false;
//            }
//
//            @Override
//            public boolean addAll(Collection<? extends Fruit> c) {
//                return false;
//            }
//
//            @Override
//            public boolean addAll(int index, Collection<? extends Fruit> c) {
//                return false;
//            }
//
//            @Override
//            public boolean removeAll(Collection<?> c) {
//                return false;
//            }
//
//            @Override
//            public boolean retainAll(Collection<?> c) {
//                return false;
//            }
//
//            @Override
//            public void clear() {
//
//            }
//
//            @Override
//            public Fruit get(int index) {
//                return null;
//            }
//
//            @Override
//            public Fruit set(int index, Fruit element) {
//                return null;
//            }
//
//            @Override
//            public void add(int index, Fruit element) {
//
//            }
//
//            @Override
//            public Fruit remove(int index) {
//                return null;
//            }
//
//            @Override
//            public int indexOf(Object o) {
//                return 0;
//            }
//
//            @Override
//            public int lastIndexOf(Object o) {
//                return 0;
//            }
//
//            @Override
//            public ListIterator<Fruit> listIterator() {
//                return null;
//            }
//
//            @Override
//            public ListIterator<Fruit> listIterator(int index) {
//                return null;
//            }
//
//            @Override
//            public List<Fruit> subList(int fromIndex, int toIndex) {
//                return null;
//            }
//        };
//    }
}
