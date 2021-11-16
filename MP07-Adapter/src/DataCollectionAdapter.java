import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataCollectionAdapter<T> implements DataCollection<T>, Iterable<T> {
    List<T> data;

    DataCollectionAdapter(ArrayList<T> list) {
        // data = new ArrayList<T>();
        data = list;
    }

    @Override
    public boolean put(T t) {
        return data.add(t);
    }

    @Override
    public T elemAt(int index) {
        if (index >= 0 && index < length())
            return data.get(index);
        return null;
    }

    @Override
    public int length() {
        return data.size();
    }

    @Override
    public Iterator createIterator() {
        return data.iterator();
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }
}
