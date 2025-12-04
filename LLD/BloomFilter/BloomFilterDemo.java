package LLD_Interview_Problems.BloomFilter;

import LLD_Interview_Problems.BloomFilter.strategy.HashStrategy;
import LLD_Interview_Problems.BloomFilter.strategy.MD5HashStrategy;
import LLD_Interview_Problems.BloomFilter.strategy.SHA1HashStrategy;

import java.util.List;

public class BloomFilterDemo {

    public static void main(String[] args) {

        System.out.println("Bloom Filter Demo");

     List<HashStrategy> hashStrategies = List.of(
             new SHA1HashStrategy(),
             new MD5HashStrategy()
     );
        BloomFilter bloomFilter = new BloomFilter.Builder(10,3)
                .withHashStrategies(hashStrategies)
                .build();

        String data1 = "apple";
        String data2 = "amazon";
        String data3 = "ballon";


        bloomFilter.add(data1);
        bloomFilter.add(data2);
        bloomFilter.add(data3);

        String data4 = "city";
        boolean containsCity= bloomFilter.mayContain(data4);

        System.out.println("Bloom Filter Contains :  "+data4+" : "+containsCity);


    }
}
