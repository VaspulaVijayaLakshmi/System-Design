public class MyConcurrentHashMap<K,V>{

   public final Bucket<K,V>[] buckets;
   public final int capacity;

   public MyConcurrentHashMap(int capacity){
      this.capacity = capacity;

      buckets = new Bucket[capacity];

      for(int i=0;i<capacity;i++){
         buckets[i] = new Bucket<>();
      }
   }


   public void put(K key, V value){

      int index = getBucketIndex(key);
      Bucket<K,V> bucket = buckets[index];

      bucket.lock.lock();

      try{

         for(Node<K,V> node: bucket.nodes){

            if(node.key.equals(key)) {
               node.value = value;
            }
         }

         bucket.nodes.add(new Node<>(key,value));

      }finally{
         bucket.lock.unlock();
      }
   }


   public V get(K key){

      int index=getBucketIndex(key);
      Bucket<K,V> bucket=buckets[index];

      //lock is needed because it can be modified by other node
      bucket.lock.lock();

      try{

         for(Node<K,V> node: bucket.nodes){

            if(node.key.equals(key)){
               return node.value;
            }
         }

         return null;

      }
      finally{
         bucket.lock.unlock();
      }
   }


   public void remove(K key){

      int index = getBucketIndex(key);
      Bucket<K,V> bucket = buckets[index];

      bucket.lock.lock();

      try{

         for(int i=0; i<bucket.nodes.size(); i++){

            if(bucket.nodes.get(i).key.equals(key)){
               bucket.nodes.remove(i);
               break;
            }

         }

      }finally{
         bucket.lock.unlock();
      }
   }


   private int getBucketIndex(K key){
      return Math.abs(key.hashCode()) % capacity;
   }


}
