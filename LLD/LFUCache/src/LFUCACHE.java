import java.util.HashMap;
import java.util.Map;

public class LFUCACHE {

    Map<Integer,DLL> freqMap;
    //node map is needed or else we will be traversing the entire DLL for all frequncies
    Map<Integer, Node> nodeMap;

    int capacity;
    int minFreq;


    public LFUCACHE(int capacity){
        this.capacity=capacity;
        minFreq=0;
        freqMap= new HashMap<>();
        nodeMap = new HashMap<>();
    }

    //get
    public int get(int key){

        Node node = nodeMap.get(key);

        //node not present
        if(node==null) return -1;

        //update freq map
        updateFrequency(node);
          return node.val;
        }


        public void  updateFrequency(Node node){

                int freq = node.freq;
                DLL oldFreqList = freqMap.get(freq);

                //remove from old List
                oldFreqList.remove(node);

                //update minFreq if needed
                if(freq == minFreq && oldFreqList.size==0) minFreq++;

                //increase node freq
                node.freq++;

                //add node to new freq list
                DLL newFreqList = freqMap.getOrDefault(node.freq, new DLL());
                newFreqList.addToHead(node);
                freqMap.put(node.freq, newFreqList);

        }


    //put
      public void put(int key, int val){

        if(capacity==0) return ;

          // if key already exists
          if (nodeMap.containsKey(key)) {
              Node node = nodeMap.get(key);
              node.val = val;
              updateFrequency(node);
              return;
          }


          // if capacity full -> evict LFU
          if (nodeMap.size() == capacity) {
              DLL minList = freqMap.get(minFreq);
              Node nodeToRemove = minList.removeFromTail();
              nodeMap.remove(nodeToRemove.key);
          }

          // insert new node with freq = 1
          Node newNode = new Node(key, val);
          minFreq = 1;

          DLL list = freqMap.getOrDefault(1, new DLL());
          list.addToHead(newNode);
          freqMap.put(1, list);

          nodeMap.put(key, newNode);


    }





}
