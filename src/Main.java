import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] arr = {110, 124, 110, 110, 55, 44, 55, 44, 2, 2, 1, 2, 3};
//        ArrayList<Integer> answ = MostFrequent(arr);
//        for (Integer value : answ) {
//            System.out.println(value);
//        }
        ArrayList<Integer> groupedNumbers = groupNumbers(arr);
        System.out.println(groupedNumbers);
    }

    public static ArrayList<Integer> groupNumbers(int[] input) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> newMap = new HashMap<>();
        for (int i : input) {
            newMap.put(i, newMap.getOrDefault(i, 0) + 1);
        }
        for (int i : newMap.keySet()) {
            int count = newMap.get(i);
            for (int j = 0; j < count; j++) {
                result.add(i);
            }
        }
        return result;
    }

    public static ArrayList<Integer> MostFrequent(int arr[]) {
        Map<Integer, Integer> hp = new HashMap<>();
        ArrayList<Integer> answ = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            if (hp.containsKey(key)) {
                int freq = hp.get(key);
                freq++;
                hp.put(key, freq);
            } else {
                answ.add(key);
                hp.put(key, 1);
            }
        }

        ArrayList<Integer> rez = new ArrayList<>();
        for (int i = 0; i < answ.size(); i++) {
            int key = answ.get(i);
            int freq = hp.get(key);
            for (int l = 0; l < freq; l++) {
                rez.add(key);
            }
        }
        return rez;
    }
}