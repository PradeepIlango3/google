import javafx.util.Pair;

import java.util.*;

public class ScratchBook {
    static class Student {
        int marks;
        String name;
        public Student(String name, int marks) {
            this.marks = marks;
            this.name = name;
        }
    }
    public static void main(String[] args) {

        //Stack
        System.out.println("Stack");
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(1);
        stack.push(2);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

        //LinkedList
        System.out.println("LinkedList:");
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.addFirst(3);
        list.removeFirst();
        System.out.println("size: "+list.size());
        System.out.println(list);
        List<Integer> empty = Collections.EMPTY_LIST;


        //String
        System.out.println("String");
        String exp = "/a/b//c";
        String[] split = exp.split("/");
        for (String i : split) {
            System.out.print(i+ " ");
        }

        //Queue
        System.out.println("Queue");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);

        //Dequeue
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(5);
        deque.addFirst(10);
        deque.remove(5);

        //PriorityQueue
        System.out.println("PriorityQueue");
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        pq.add(1);
        pq.add(2);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        pq.add(5);
        for (int i : pq) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(pq.peek());
        Student[] students = new Student[4];
        for (int i = 0; i < 4; i++) {
            students[i] = new Student(("Student : " + i), (i+1)*100);
        }
        PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.marks - o1.marks;
            }
        });
        studentPriorityQueue.addAll(Arrays.asList(students));
        System.out.println(studentPriorityQueue.size());
        System.out.println(studentPriorityQueue.isEmpty());
        while (!studentPriorityQueue.isEmpty()) {
            System.out.println(studentPriorityQueue.peek().name);
            System.out.println(studentPriorityQueue.peek().marks);
            studentPriorityQueue.remove();
        }
        Comparator<Student> c = Collections.reverseOrder(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.marks - o1.marks;
            }
        });
        PriorityQueue<Pair<Integer, Integer>> newPQ = new PriorityQueue<Pair<Integer, Integer>>(new Comparator<Pair<Integer, Integer>>(){
            @Override
            public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
                return a.getKey() -b.getKey();
            }
        });
        newPQ.add(new Pair<>(13, 100));
        newPQ.add(new Pair<>(130, 100));
        newPQ.add(new Pair<>(3, 100));
        newPQ.add(new Pair<>(123, 100));
        System.out.println(newPQ.size());
        System.out.println(newPQ.peek());
        System.out.println(newPQ.remove(new Pair<>(123, 100)));
        System.out.println(newPQ.size());

        //Map
        System.out.println("Map");
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(1, true);
        map.put(5, true);
        map.remove(5);
        System.out.println(map.size());

        //Arrays
        Integer[] sam = new Integer[] {5,6,2};
        List<Integer> list1 = Arrays.asList(sam);
        Collections.sort(list1, new Comparator<Integer>() {
            @Override
            public int compare(Integer a , Integer b) {
                return a -b;
            }
        });
        System.out.println(sam);

        //Comparator
        Comparator c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a-b;
            }
        };
        Comparator c2 = Collections.reverseOrder(c1);
        System.out.println(c1);
        System.out.println(c2);
        Integer[] g = new Integer[] {3, 2, 10, 23 , 100, 1};
        Arrays.sort(g, c1);
        System.out.println(g[0]);
        Arrays.sort(g, c2);
        System.out.println(g[0]);

        //Pair and Map
        Map<Pair<Integer, Integer>, Boolean> seen = new HashMap<>();
        seen.put(new Pair<>(0,2), true);
        seen.put(new Pair<>(0,2), true);
        Pair<Integer, Integer> item = new Pair<>(5,75);
        seen.put(item, true);
        System.out.println(seen.containsKey(item));
        System.out.println(seen.containsKey(new Pair<>(0,2)));
        
        //ArrayList
        ArrayList<Integer> listA = new ArrayList<>();
        listA.add(1);
        listA.remove(5);
    }
}
