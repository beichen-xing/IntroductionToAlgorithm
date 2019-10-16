import java.util.HashMap;

public class HashMapTest {

// ALL of the following methods can be done in O(1) on average by HashMap
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("one",1);
        hm.put("two",2);
        hm.put("three",3);
        System.out.println(hm);

        System.out.println(hm.get("one"));
        hm.remove("one");
        System.out.println(hm);
        System.out.println(hm.getOrDefault("five",0));
        System.out.println(hm.containsKey("two"));

        hm.put("one",4);
        hm.compute("two",(k,v)->5*5);
        System.out.println(hm);

        hm.putIfAbsent("five",5);
        hm.computeIfAbsent("six",k->6);
        System.out.println(hm);


    // for-loop
        for (String key: hm.keySet()) {
            System.out.println(key);
        }
        for (Integer v: hm.values()) {
            System.out.println(v);
        }

        for(HashMap.Entry e: hm.entrySet()){
            System.out.println(e);
        }
    }
}
