public class ArrayDeque<Item>{
    private Item[] items;
    private int size;
    private int start=0;

    public ArrayDeque(Item item){
        items= (Item[]) new Object[8];
        items[start]=item;
        size=size+1;
    }

    public ArrayDeque(){
        items= (Item[]) new Object[8];
        size=0;
    }

    public void addFirst(Item item){
        if (items.length==size){
            resize(size*2);
        }
        start=start-1;
        if (start<0)
            start=start+ items.length;
        items[start]=item;
        size=size+1;
    }

    public void addLast(Item item){
        if (items.length==size){
            resize(size*2);
        }
        items[(start+size)% items.length]=item;
        size=size+1;
    }

    public void resize(int capacity){
        Item[] temp= (Item[]) new Object[capacity];
        System.arraycopy(items,start,temp,0,items.length-start);
        System.arraycopy(items,0,temp,items.length-start,start);
        start=0;
        items=temp;
    }

    public boolean isEmpty(){
        if (size==0)
            return true;
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (int i=start;i<size+start;i++){
            System.out.print(items[i% items.length]);
            if (i<size+start-1){
                System.out.print(" ");
            }
        }
    }
    public Item removeFirst(){
        if (isEmpty()){
            return null;
        }
        Item retrun_val=items[start];
        items[start]=null;
        start=start+1;
        if (start>= items.length)
            start=start% items.length;
        size=size-1;
        return retrun_val;
    }
    public Item removeLast(){
        if (isEmpty()){
            return null;
        }
        int target=(start+size)% items.length-1;
        Item retrun_val=items[target];
        items[target]=null;
        size=size-1;
        return retrun_val;
    }
    public Item get(int index){
        if (index>=size){
            return null;
        }
        return items[(start+index)% items.length];
    }

//    public static void main(String[] args) {
//        ArrayDeque<Integer> test= new ArrayDeque<>();
//        int i=0;
//        while (i<1000000){
//            test.addLast(i);
//            i=i+1;
//        }
//        test.printDeque();
    }
}
