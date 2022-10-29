import java.util.*;

public class Hashfunctions {
    record Person (String name){

    }
    record Daimond (String name){}

    public static void main(String[] args) {
        Map<Person, Daimond> hashes = new HashMap<>();
        hashes.put(new Person("Jameela"), new Daimond("Africa"));
        //Record does all the hardworking if no record then you have to manually override
        System.out.println(new Person("Jameela").hashCode());
        //Without override, it is going to think that Jameela is different from the other when in fact they are both the same and give them another hashcode
    }
    //Hashfunctions.Lists and Maps are the most important

    public static class LinkedLists {
        public static void main(String[] args) {
            LinkedList<Person> note = new LinkedList<>();
            note.add(new Person("Romero", 14));
            note.add(new Person("Jose", 15));
            note.addFirst(new Person("yusha", 16));
            note.addLast(new Person("Abraham", 20));
            ListIterator<Person> personListIterator = note.listIterator();
            while(personListIterator.hasNext()){
                System.out.println(personListIterator.next());
            }
            System.out.println();
            while(personListIterator.hasPrevious()){
                System.out.println(personListIterator.previous());
            }

        }
        static record Person(String name, int age){

        }
    }

    public static class Lists {
        public static void main(String[] args) {
            List<String> colors = new ArrayList<String>();
            colors.add("Red");
            colors.add("Blue");
            colors.add("Green");
            System.out.println(colors);
            System.out.println(colors.size());
            System.out.println(colors.contains("Red"));

            for (String color : colors){
                System.out.println("jerry");
            }
            colors.forEach(System.out::println);
        }
    }

    public static class Map {
        public static void main(String[] args) {
            java.util.Map<Integer, Person> dora = new HashMap<>();
            dora.put(1,new Person("Alexa"));
            dora.put(2,new Person("Alexa"));
            dora.put(2,new Person( "alexander"));
            System.out.println(dora.size());
            System.out.println(dora.get(1));
            System.out.println(dora.containsKey(3));
            System.out.println(dora.entrySet());
            System.out.println(dora.keySet());
            System.out.println(dora);
            dora.entrySet().forEach(x -> System.out.println(x.getKey()+" "+x.getValue()));
            dora.remove(2);
            System.out.println(dora);
            System.out.println(dora.getOrDefault(4, new Person("Maryam")));


        }

        record Person (String name){

        }
    }

    public static class PriorityQueues{



        public static void main(String args[])

        {

            //Priority Queue = A FIFO data structure that serves elements

            //                             with the highest priorities first

            //				  before elements with lower priority



            //Strings in default order

            Queue<String> queue = new PriorityQueue<>();



            //Strings in reverse order

            //Queue<String> queue = new PriorityQueue<>(Collections.reverseOrder());



            queue.offer("B");

            queue.offer("C");

            queue.offer("A");

            queue.offer("F");

            queue.offer("D");



            while(!queue.isEmpty()) {

                System.out.println(queue.poll());

            }

        }

    }

    public static class Qeues {
        public static void main(String[] args) {
            Queue<Person> supermarket = new LinkedList<>();
            supermarket.add(new Person("Alex", 21));
            supermarket.add(new Person("Maryam", 23));
            supermarket.add(new Person("Joe", 29));
            System.out.println(supermarket.size());
            System.out.println(supermarket.peek());
            System.out.println(supermarket.poll());
            System.out.println(supermarket.size());
            System.out.println(supermarket.peek());
        }

        static record Person(String name, int age) {

        }
    }

    public static class Sets {
        public static void main(String[] args) {
            Set<Ball> Balls = new HashSet();
            Balls.add(new Ball("Blue"));
            Balls.add(new Ball("Blue"));
            Balls.add(new Ball("Red"));
            Balls.add(new Ball("Yellow"));
            Balls.remove(new Ball("Red"));
            Balls.forEach(System.out::println);
            System.out.println(Balls.size());
            Balls.remove(new Ball("Red"));
            //If you want order to matter change it form Hashset to Treeset

        }
        record Ball(String color){

        }
    }

    public static class Stacks {
        public static void main(String[] args) {

            Stack<Integer> first = new Stack<>();
            first.push(2);
            first.push(3);
            first.push(4);
            System.out.println(first.peek());
            System.out.println(first.size());
            System.out.println(first.pop());
            System.out.println(first.size());
            System.out.println(first.empty());
            System.out.println(first.firstElement());
        }
    }
}
public class DynamicArrays{



    public static void main(String[] args) {



        DynamicArray dynamicArray = new DynamicArray(5);



        dynamicArray.add("A");

        dynamicArray.add("B");

        dynamicArray.add("C");



        //System.out.println(dynamicArray.get(0));

        //dynamicArray.insert(0, "X");

        //dynamicArray.delete("A");

        //System.out.println(dynamicArray.search("C"));



        System.out.println(dynamicArray);

        System.out.println("size: " + dynamicArray.size);

        System.out.println("capacity: " + dynamicArray.capacity);

        System.out.println("empty: " + dynamicArray.isEmpty());

    }

}
public class DynamicArray {



    int size;

    int capacity = 10;

    Object[] array;



    public DynamicArray() {

        this.array = new Object[capacity];

    }

    public DynamicArray(int capacity) {

        this.capacity = capacity;

        this.array = new Object[capacity];

    }



    public Object get(int index) {

        return array[index];

    }



    public void add(Object data) {



        if(size >= capacity) {

            grow();

        }

        array[size] = data;

        size++;

    }



    public void insert(int index, Object data) {



        if(size >= capacity) {

            grow();

        }

        for(int i = size; i > index; i--) {

            array[i] = array[i - 1];

        }

        array[index] = data;

        size++;

    }



    public void delete(Object data) {



        for(int i = 0; i < size; i++) {

            if(array[i] == data) {

                for(int j = 0; j < (size - i - 1); j++){

                    array[i + j] = array[i + j + 1];

                }

                array[size - 1] = null;

                size--;

                if(size <=(int) (capacity/3)) {

                    shrink();

                }

                break;

            }

        }

    }



    public int search(Object data) {



        for(int i = 0; i < size; i++) {

            if(array[i] == data) {

                return i;

            }

        }

        return -1;

    }



    private void grow() {



        int newCapacity = (int)(capacity * 2);

        Object[] newArray = new Object[newCapacity];



        for(int i = 0; i < size; i++) {

            newArray[i] = array[i];

        }

        capacity = newCapacity;

        array = newArray;

    }



    private void shrink() {



        int newCapacity = (int)(capacity / 2);

        Object[] newArray = new Object[newCapacity];



        for(int i = 0; i < size; i++) {

            newArray[i] = array[i];

        }

        capacity = newCapacity;

        array = newArray;

    }



    public boolean isEmpty() {

        return size == 0;

    }



    public String toString() {



        String string = "";



        for(int i = 0; i < capacity; i++) {

            string += array[i] + ", ";

        }

        if(string != "") {

            string = "[" + string.substring(0, string.length() - 2) + "]";

        }

        else {

            string = "[]";

        }

        return string;

    }

}
