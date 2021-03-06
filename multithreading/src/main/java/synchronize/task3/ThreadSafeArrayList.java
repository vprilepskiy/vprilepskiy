package synchronize.task3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThreadSafeArrayList<T> implements Iterable<T> {

    private List<T> list = new ArrayList();

    public synchronized boolean add(T element) {
        return this.list.add(element);
    }

    @Override
    public synchronized Iterator<T> iterator() {
        return copy(this.list).iterator();
    }

    private Iterable<T> copy(List<T> list) {
        return new ArrayList<>(list);
    }
}