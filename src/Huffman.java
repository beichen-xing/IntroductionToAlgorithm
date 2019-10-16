import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class Huffman {

    public static int huffman(PriorityQueue<Integer> pq, int N){
        for(int i = 0; i < N - 1; i++){
            System.out.println(i);
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a+b);
            System.out.println(pq);
        }
        return pq.poll();
    }


    public static void main(String[] args) {
        HashMap<Character,Integer> hm = new HashMap<>();

        hm.put('a',45);
        hm.put('b',13);
        hm.put('c',12);
        hm.put('d',16);
        hm.put('e',9);
        hm.put('f',5);

        PriorityQueue<Integer> pq = new PriorityQueue<>(hm.values());
        int N = pq.size();

        System.out.println(hm);
        System.out.println(pq);
        System.out.println(huffman(pq,N));


    }
}
