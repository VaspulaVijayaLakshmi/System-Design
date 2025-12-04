package LLD_Interview_Problems.BloomFilter;

import LLD_Interview_Problems.BloomFilter.strategy.HashStrategy;

import java.util.BitSet;
import java.util.List;

public class BloomFilter {

    int bitSetSize;
    int NoOfHashFunctions;
    BitSet bitSet;
    List<HashStrategy> hashStrategies;

    private BloomFilter(Builder builder){
        this.bitSetSize = builder.bitSetSize;
        this.NoOfHashFunctions = builder.noOfHashFunctions;
        this.hashStrategies = builder.hashStrategies;
        this.bitSet = new BitSet(bitSetSize);
    }


    public void add(String data){

        //pass through all hash fucntions and add to bitset
        for(HashStrategy hashStrategy : hashStrategies){
            int hash = hashStrategy.calculateHash(data);
            int bitSetIndex= Math.abs(hash % bitSetSize);
            bitSet.set(bitSetIndex);

            System.out.println("Item "+data+ " added to bitSet");

        }

    }


    public boolean mayContain(String data){

        //if it is not present in any one then its defitely not present
        for(HashStrategy hashStrategy : hashStrategies){

            int hash = hashStrategy.calculateHash(data);
            int bitSetIndex= Math.abs(hash % bitSetSize);
            if(!bitSet.get(bitSetIndex)){
                return false;
            }

        }
        return true;
    }



    public static class Builder{

        int bitSetSize;
        int noOfHashFunctions;
        List<HashStrategy> hashStrategies;


        public Builder(int bitSetSize, int noOfHashFunctions){
            this.bitSetSize = bitSetSize;
            this.noOfHashFunctions = noOfHashFunctions;
        }

        public Builder withHashStrategies(List<HashStrategy> hashStrategies){
            this.hashStrategies = hashStrategies;
            return this;
        }

        public BloomFilter build(){
            return new BloomFilter(this);
        }

    }


}
