package twentytwenty.day25;

import java.util.HashMap;

public class Problem {

    //https://adventofcode.com/2020/day/25
    public static void main(String[] args) {
        var pk1 = 12092626L;
        var pk2 = 4707356L;
//        var pk1 = 5764801L;
//        var pk2 = 17807724L;

        var subjNum = 7L;

        var cache = new HashMap<Long, Integer>(); //Cache for enc key -> loop size
        var val = 1L;
        int loopSize = 0;
        while (!(cache.containsKey(pk1) && cache.containsKey(pk2))) {
            loopSize++;
            val = val * subjNum;
            val = val % 20201227;
            cache.put(val, loopSize);
        }

        var encKey = 1L;
        var loopSizePk1 = cache.get(pk1);

        for (int i = 0; i < loopSizePk1; i++) {
            encKey = encKey * pk2;
            encKey = encKey % 20201227;
//            System.out.println("enc key = " + encKey);
        }
        
        System.out.println("enc key = " + encKey);
    }
}
