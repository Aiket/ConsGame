import java.util.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JSONParser {
    public List<Enemy> getEnemies(String pathToEnemies) {
        Gson gson = new Gson();
        List<Enemy> outputList = new List<Enemy>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Enemy> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Enemy enemy) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Enemy> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Enemy> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Enemy get(int index) {
                return null;
            }

            @Override
            public Enemy set(int index, Enemy element) {
                return null;
            }

            @Override
            public void add(int index, Enemy element) {

            }

            @Override
            public Enemy remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Enemy> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Enemy> listIterator(int index) {
                return null;
            }

            @Override
            public List<Enemy> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

        try (Reader reader = new FileReader(pathToEnemies)) {

            outputList = gson.fromJson(reader, new TypeToken<List<Enemy>>() {
            }.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputList;
    }

    public Boss getBoss(String pathToBoss) {
        Gson gson = new Gson();
        Boss boss = new Boss();

        try (Reader reader = new FileReader(pathToBoss)) {

            boss = gson.fromJson(reader, new TypeToken<Boss>() {
            }.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return boss;
    }
}

