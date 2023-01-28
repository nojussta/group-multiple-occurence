import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] input = {110, 124, 110, 110, 55, 44, 55, 44, 2, 2, 1, 2, 3};
        ArrayList<Integer> mostFrequent = MostFrequent(input);
        for (Integer value : mostFrequent) {
            System.out.println(value);
        }
        ArrayList<Integer> groupedNumbers = groupNumbers(input);
        System.out.println(groupedNumbers);
    }

    public static ArrayList<Integer> groupNumbers(int[] input) {
        HashMap<Integer, Integer> index = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            if (!index.containsKey(input[i])) {
                index.put(input[i], i);
                result.add(input[i]);
            } else {
                result.add(index.get(input[i]), input[i]);
            }
        }

        return result;
    }

    public static ArrayList<Integer> MostFrequent(int arr[]) {
        Map<Integer, Integer> hp = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            if (hp.containsKey(key)) {
                int freq = hp.get(key);
                freq++;
                hp.put(key, freq);
            } else {
                result.add(key);
                hp.put(key, 1);
            }
        }

        ArrayList<Integer> rez = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            int key = result.get(i);
            int freq = hp.get(key);
            for (int l = 0; l < freq; l++) {
                rez.add(key);
            }
        }
        return rez;
    }
}