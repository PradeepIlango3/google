import java.util.*;

public class FriendsOfFriends {

    Map<Person, Set<Person>> graph = new HashMap<>();
    int id = 0;
    HashMap<Integer, Person> map = new HashMap<>();

    class Person {
        int id;
        String name;
        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object ob) {
            if (this == ob) return true;
            if (ob == null || (this.getClass() != ob.getClass())) return false;
            Person a = (Person) ob;
            if (a.id == this.id) return true;
            return false;
        }

        @Override
        public int hashCode() {
            return this.id;
        }
    }

    public void addFriend(Person a, Person b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    public Person createPerson(String name) {
        Person person = new Person(id, name);
        id++;
        graph.put(person, new HashSet<>());
        map.put(person.id, person);
        return person;
    }

    public List<Person> suggestFriends(Person a) {
        boolean[] visited = new boolean[id];
        int[] level = new int[id];
        int[] count = new int[id];
        int l = 0;
        Queue<Person> q = new LinkedList<>();
        q.add(a);
        visited[a.id] = true;
        int max = 0;
        while(!q.isEmpty() && l <=1) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Person p = q.remove();
                for (Person adjP: graph.get(p)) {
                    if (!visited[adjP.id]) {
                        q.add(adjP);
                        level[adjP.id] = level[p.id] + 1;
                        visited[adjP.id] = true;
                    }
                    if (level[adjP.id] == 2) {
                        count[adjP.id]++;
                        if (max < count[adjP.id]) {
                            max = count[adjP.id];
                        }
                    }
                }
            }
            l++;
        }
        if (max == 0) return Collections.emptyList();
        List<Person>  friends = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                friends.add(map.get(i));
            }
        }
        return friends;
    }

    public int totalPersons() {
        return graph.size();
    }

    public static void main(String[] args) {
        FriendsOfFriends friendsOfFriends = new FriendsOfFriends();
        Person a = friendsOfFriends.createPerson("Pradeep");
        Person b = friendsOfFriends.createPerson("Dinagar");
        Person c = friendsOfFriends.createPerson("Prabhu");
        Person d = friendsOfFriends.createPerson("Giridhar");
        Person e = friendsOfFriends.createPerson("Naveen");
        friendsOfFriends.addFriend(a, b);
        friendsOfFriends.addFriend(a, c);
        friendsOfFriends.addFriend(c, d);
        friendsOfFriends.addFriend(c, e);
        friendsOfFriends.addFriend(b, e);
        friendsOfFriends.addFriend(b, c);
        System.out.println(friendsOfFriends.totalPersons());
        List<Person> f = friendsOfFriends.suggestFriends(a);
        for (Person p :  f) {
            System.out.println(p.name);
        }
    }
}
