public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int start = 0;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }

    public void addFirst(T item) {
        if (items.length == size) {
            resize(size * 2);
        }
        start = start - 1;
        if (start < 0) {
            start = start + items.length;
        }
        items[start] = item;
        size = size + 1;
    }

    public void addLast(T item) {
        if (items.length == size) {
            resize(size * 2);
        }
        items[(start + size) % items.length] = item;
        size = size + 1;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        int num;
        if ((start + size) > items.length) {
            num = items.length - start;
        } else {
            num = size;
        }
        System.arraycopy(items, start, temp, 0, num);
        System.arraycopy(items, 0, temp, num, size - num);
        start = 0;
        items = temp;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = start; i < size + start; i++) {
            System.out.print(items[i % items.length]);
            if (i < size + start - 1) {
                System.out.print(" ");
            }
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        double ratio = (double) (size - 1) / items.length;
        if (ratio < 0.26 & items.length >= 16) {
            resize(items.length / 2);
        }
        T retrunVal = items[start];
        items[start] = null;
        start = start + 1;
        if (start >= items.length) {
            start = start % items.length;
        }
        size = size - 1;
        return retrunVal;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        double ratio = (double) (size - 1) / items.length;
        if (ratio < 0.26 & items.length >= 16) {
            resize(items.length / 2);
        }
        int target = (start + size) % items.length - 1;
        if (target < 0) {
            target = target + items.length;
        }
        T retrunVal = items[target];
        items[target] = null;
        size = size - 1;
        return retrunVal;
    }

    public T get(int index) {
        if (index >= size | index < 0) {
            return null;
        }
        return items[(start + index) % items.length];
    }

}

