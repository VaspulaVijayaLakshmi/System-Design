package LLD_Interview_Problems.BloomFilter.strategy;

public class MD5HashStrategy implements  HashStrategy {

    @Override
    public int calculateHash(String data){
        int hash = 0;
        for(int i = 0; i < data.length(); i++){
            hash = (hash * 31 + data.charAt(i)) % Integer.MAX_VALUE;
        }
        return hash;
    }
}
