//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MyConcurrentHashMap<String,Integer> map =
                new MyConcurrentHashMap<>(10);


        map.put("A",100);

        System.out.println(
                map.get("A")
        );


        map.remove("A");


    }
}