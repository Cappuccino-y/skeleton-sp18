public class LinkedListDeque<T> implements Deque<T> {
    private TNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(T item) {
        sentinel.next = new TNode(item, sentinel.next, sentinel);
        sentinel.next.next.previous = sentinel.next;
        size = size + 1;
    }

    @Override
    public void addLast(T item) {
        sentinel.previous = new TNode(item, sentinel, sentinel.previous);
        sentinel.previous.previous.next = sentinel.previous;
        size = size + 1;
    }

    @Override
    public void printDeque() {
        TNode pointer = sentinel;
        for (int i = 0; i < size; i++) {
            System.out.print(pointer.next.first);
            if (i < size - 1) {
                System.out.print(" ");
            }
            pointer = pointer.next;
        }
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T feedback = sentinel.next.first;
        sentinel.next = sentinel.next.next;
        sentinel.next.previous = sentinel;
        size = size - 1;
        return feedback;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T feedback = sentinel.previous.first;
        sentinel.previous = sentinel.previous.previous;
        sentinel.previous.next = sentinel;
        size = size - 1;
        return feedback;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        TNode pointer = sentinel.next;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        return pointer.first;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return sentinel.next.getRecursion(index);
    }

    private class TNode {
        private T first;
        private TNode next;
        private TNode previous;

        TNode(T m, TNode n, TNode p) {
            first = m;
            next = n;
            previous = p;
        }

        T getRecursion(int index) {
            if (index == 0) {
                return first;
            }
            return next.getRecursion(index - 1);
        }
    }
}

