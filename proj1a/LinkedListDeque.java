public class LinkedListDeque<T> {
    public TNode sentinel;
    public int size;
    public LinkedListDeque(T item){
        sentinel = new TNode(null,sentinel,sentinel);
        sentinel.next=new TNode(item,sentinel,sentinel);
        sentinel.previous=sentinel.next;
        size=1;
    }

    public LinkedListDeque(){
        sentinel = new TNode(null,sentinel,sentinel);
        size=0;
    }

    public boolean isEmpty(){
        if (size==0)
            return true;
        return false;
    }

    public int size(){
        return size;
    }

    public void addFirst(T item){
        if (isEmpty()){
            sentinel.next = new TNode(item,sentinel,sentinel);
            sentinel.previous=sentinel.next;
            size=size+1;
            return;
        }
        sentinel.next = new TNode(item,sentinel.next,sentinel);
        sentinel.next.next.previous=sentinel.next;
        size=size+1;
    }

    public void addLast(T item){
        if (isEmpty()){
            sentinel.next = new TNode(item,sentinel,sentinel);
            sentinel.previous=sentinel.next;
            size=size+1;
            return;
        }
        sentinel.previous = new TNode(item,sentinel,sentinel.previous);
        sentinel.previous.previous.next=sentinel.previous;
        size=size+1;
    }

    public void printDeque(){
        TNode pointer=sentinel;
        for (int i=0;i<size;i++){
            System.out.print(pointer.next.first);
            if (i<size-1){
                System.out.print(" ");
            }
            pointer=pointer.next;
        }
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        T feedback=sentinel.next.first;
        sentinel.next=sentinel.next.next;
        sentinel.next.previous=sentinel;
        size=size-1;
        return feedback;
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        T feedback=sentinel.previous.first;
        sentinel.previous=sentinel.previous.previous;
        sentinel.previous.next=sentinel;
        size=size-1;
        return feedback;
    }

    public T get(int index){
        if (index>=size)
            return null;
        TNode pointer= sentinel.next;
        for (int i=0;i<index;i++){
            pointer=pointer.next;
        }
        return pointer.first;
    }

    public T getRecursive(int index){
        if (index>=size)
            return null;
        return sentinel.next.getRecursion(index);
    }
//    public static void main(String[] args) {
//        LinkedListDeque<Integer> l= new LinkedListDeque<>();
//        l.addFirst(45);
//        l.addFirst(67);
//        l.addLast(0);
//        l.addLast(99);
//        l.printDeque();
//        l.removeLast();
//        l.printDeque();
//        System.out.print(12%7);
//
//
//    }

    private class TNode {
        private T first;
        private TNode next;
        private TNode previous;

        public TNode(T m, TNode n, TNode p){
            first=m;
            next=n;
            previous=p ;
        }

        public T getRecursion(int index){
            if (index==0)
                return first;
            return next.getRecursion(index-1);
        }
    }
}
